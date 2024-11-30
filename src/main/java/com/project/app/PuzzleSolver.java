package com.project.app;

import com.project.data.GlobalData;
import com.project.data.ThreadState;
import com.project.data.ThreadTracker;

public class PuzzleSolver extends Thread{
    ThreadTracker tracker;
    public PuzzleSolver(ThreadTracker tracker){
        super();
        this.tracker = tracker;

    }
    @Override
    public void run() {
        tracker.threadState = ThreadState.RUNNING;
        GlobalData data = GlobalData.getInstance();
        Solver s = new Solver(tracker);
        boolean success = s.Solve(data.pieces);
        if (success) {
            tracker.threadState = ThreadState.SUCCEEDED;
        }
        if(tracker.UpdateWindow != null) tracker.UpdateWindow.run();

    }

}
