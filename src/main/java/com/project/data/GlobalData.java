package com.project.data;

import com.project.app.PuzzleSolver;

public class GlobalData {
    public static int TrackerNumber = 0;
    public static Piece[] pieces;
    public static ThreadTracker[] trackers;
    public static ThreadTracker MainTracker;
    public static PuzzleSolver[] solvers;
    
    public static void Init (int _NumberOfTrackers, Piece[] _pieces) {
        TrackerNumber = _NumberOfTrackers;
        pieces = _pieces;
        GenerateNTrackers();
        MainTracker = new ThreadTracker(new Square() , -1);
        MainTracker.threadState = ThreadState.NOT_STARTED;
    }
    
    private static void GenerateNTrackers (){
        trackers = new ThreadTracker[TrackerNumber];
        for (int i = 0; i < TrackerNumber; i++) {
            trackers[i] = new ThreadTracker(new Square() , i);
        }
    }
}
