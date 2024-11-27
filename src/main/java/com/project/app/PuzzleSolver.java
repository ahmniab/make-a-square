package com.project.app;

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
        while (true){
            for (int row = 0; row < 4; row++) {
                for (int col = 0; col < 4; col++) {
                    tracker.square.data[row][col] = (int) (Math.random() * 10) % 6;
                }

            }
            tracker.UpdateWindow.run();
            try {
                Thread.sleep(500);

            } catch (Exception e) {
                break;
            }
        }
    }

}
