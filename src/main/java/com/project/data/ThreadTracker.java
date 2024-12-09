package com.project.data;

import javafx.scene.text.Text;

public class ThreadTracker {
    public int id;
    public Square square;
    public ThreadState threadState;
    public String ThreadName;
    public Text NameLabel;
    
    public ThreadTracker(Square s, int id){
        this.square = s;
        this.id = id;
        threadState = ThreadState.NOT_STARTED;
    }
}
