package com.project.data;

public class ThreadTracker {
    public int id;
    public Square square;
    public ThreadState threadState;
    public ThreadTracker(Square s , int id){
        this.square = s;
        this.id = id;
        threadState = ThreadState.NOT_STARTED;
    }
}
