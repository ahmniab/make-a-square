package com.project.data;

import com.project.app.PuzzleSolver;

public class GlobalData {
    public static int TrackerNumber = 0;
    public ThreadTracker[] trackers;
    public ThreadTracker MainTracker;
    public Piece [][] pieces;
    public PuzzleSolver[] solvers;
    public boolean SolutionFound;
    private static GlobalData instance = null;
    private GlobalData(){
        GenerateNTrackers();
        MainTracker = new ThreadTracker(new Square() , -1);
        MainTracker.threadState = ThreadState.NOT_STARTED;
        SolutionFound = false;
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
    public synchronized void SubmitSolution(int [][] data){
        if(!SolutionFound) {
            MainTracker.threadState = ThreadState.SUCCEEDED;
            MainTracker.square.data = data;
            SolutionFound = true;
        }
    }
    private boolean AllThreadsFailed(){
        for (int i = 0; i < trackers.length; i++) {
            if (trackers[i].threadState != ThreadState.FAILED) {
                return false;
            }

        }
        return true;
    }
    public synchronized void SubmitFailed(){
        if (SolutionFound) return;
        if (AllThreadsFailed()) {
            MainTracker.threadState = ThreadState.FAILED;
        }
    }

}
