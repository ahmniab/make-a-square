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
        ThreadTracker __main_tracker = GlobalData.getInstance().MainTracker;
        if (success) {
            tracker.threadState = ThreadState.SUCCEEDED;
            __main_tracker.threadState = ThreadState.SUCCEEDED;
            __main_tracker.square.data = tracker.square.data;

        }else {
            __main_tracker.threadState = ThreadState.SUCCEEDED;
            tracker.threadState = ThreadState.FAILED;
        }
        if(tracker.UpdateWindow != null) tracker.UpdateWindow.run();
        if(__main_tracker.UpdateWindow != null) __main_tracker.UpdateWindow.run();

    }

}
