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
        System.out.println(getName()+" Started");
        tracker.threadState = ThreadState.RUNNING;
        Solver s = new Solver(tracker);
        boolean success = s.Solve();
        ThreadTracker __main_tracker = GlobalData.getInstance().MainTracker;
        if (success) {
            tracker.threadState = ThreadState.SUCCEEDED;
            __main_tracker.threadState = ThreadState.SUCCEEDED;
            __main_tracker.square.data = tracker.square.data;

        }else {
            __main_tracker.threadState = ThreadState.SUCCEEDED;
            tracker.threadState = ThreadState.FAILED;
        }
        __main_tracker.UpdateWindow();

    }

}
