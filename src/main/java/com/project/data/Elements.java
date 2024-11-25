package com.project.data;


import java.util.List;

public class Elements {
    public static ThreadTracker [] GenerateNTrackers(int n){
        ThreadTracker [] trackers = new ThreadTracker[n];
        int ThreadId = 0;
        for(int i = 0; i<n; i++)
            trackers[i] = new ThreadTracker(new Square() , ThreadId++);

        return trackers;
    }
    public static String StateString(ThreadState state){
        String s = "Failed to get status";
        switch (state){
            case FAILED      -> s = "Failed To Solve"      ;
            case RUNNING     -> s = "Running Now"          ;
            case SUCCEEDED   -> s = "Succeeded"            ;
            case NOT_STARTED -> s = "Thread Didn't Started";
        }
        return s;
    }
}
