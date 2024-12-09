package com.project.data;

import com.project.app.PuzzleSolver;

public class GlobalData {
    public static int TrackerNumber = 0;
    public static Piece[] pieces;
    public static ThreadTracker[] trackers;
    public static ThreadTracker MainTracker;
    public static PuzzleSolver[] solvers;
    public static boolean SolutionFound;
    
    public static void Init (int _NumberOfTrackers, Piece[] _pieces) {
        TrackerNumber = _NumberOfTrackers;
        pieces = _pieces;
        GenerateNTrackers();
        MainTracker = new ThreadTracker(new Square() , -1);
        MainTracker.threadState = ThreadState.NOT_STARTED;
        SolutionFound = false;
    }
    
    private static void GenerateNTrackers (){
        trackers = new ThreadTracker[TrackerNumber];
        for (int i = 0; i < TrackerNumber; i++) {
            trackers[i] = new ThreadTracker(new Square() , i);
        }
    }
    
    public static synchronized void SubmitSolution(ThreadTracker tracker){
        if(!SolutionFound) {
            MainTracker.threadState = ThreadState.SUCCEEDED;
            MainTracker.square.data = tracker.square.data;
            MainTracker.ThreadName = "Solved by " + tracker.ThreadName;
            MainTracker.NameLabel.setText(MainTracker.ThreadName);
            SolutionFound = true;
        }
    }

    private static boolean AllThreadsFailed(){
        for (int i = 0; i < trackers.length; i++) {
            if (trackers[i].threadState != ThreadState.FAILED) {
                return false;
            }

        }
        return true;
    }

    public static synchronized void SubmitFailed(){
        if (SolutionFound) return;
        if (AllThreadsFailed()) {
            MainTracker.threadState = ThreadState.FAILED;
        }
    }
}
