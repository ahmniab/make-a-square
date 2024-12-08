package com.project.data;

import com.project.app.PuzzleSolver;

public class GlobalData {
    public static int TrackerNumber = 0;
    public ThreadTracker[] trackers;
    public ThreadTracker MainTracker;
    public Piece [][] pieces;
    public PuzzleSolver[] solvers;
    private static GlobalData instance = null;
    private GlobalData(){
        GenerateNTrackers();
        MainTracker = new ThreadTracker(new Square() , -1);
        MainTracker.threadState = ThreadState.NOT_STARTED;
    }
    public static GlobalData getInstance(){
        if(instance == null){
            instance = new GlobalData();
        }
        return instance;
    }
    private void GenerateNTrackers (){
        trackers = new ThreadTracker[TrackerNumber];
        for (int i = 0; i < TrackerNumber; i++) {
            trackers[i] = new ThreadTracker(new Square() , i);
        }
    }
}
