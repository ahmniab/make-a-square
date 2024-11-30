package com.project.data;

public class GlobalData {
    public static int TrackerNumber = 0;
    public ThreadTracker[] trackers;
    public ThreadTracker MainTracker;
    public Piece [] pieces;
    private static GlobalData instance = null;
    private GlobalData(){
        trackers =  Elements.GenerateNTrackers(TrackerNumber);
        MainTracker = new ThreadTracker(new Square() , -1);
        MainTracker.threadState = ThreadState.NOT_STARTED;
    }
    public static GlobalData getInstance(){
        if(instance == null){
            instance = new GlobalData();
        }
        return instance;
    }
}
