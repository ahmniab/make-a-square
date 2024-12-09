package com.project.data;

import com.project.app.Helper;
import com.project.gui.Renderer;
import javafx.scene.text.Text;

public class ThreadTracker {
    public int id;
    public Square square;
    public ThreadState threadState;
    public Piece [] pieces;
    public String ThreadName;
    public Text NameLabel;
    
    public ThreadTracker(Square s, int id){
        this.square = s;
        this.id = id;
        if (id != -1) this.pieces = GlobalData.pieces;
        threadState = ThreadState.NOT_STARTED;
    }
}
