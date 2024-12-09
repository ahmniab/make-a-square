package com.project.data;

import com.project.app.Helper;
import com.project.gui.GuiData;
import com.project.gui.Renderer;

public class ThreadTracker {
    public int id;
    public Square square;
    public ThreadState threadState;
    public Piece[] pieces;
    public GuiData guiData;
    
    public ThreadTracker(Square s , int id){
        this.square = s;
        this.id = id;
        if (id != -1) this.pieces = GlobalData.pieces;
        threadState = ThreadState.NOT_STARTED;
    }
    
    public void UpdateWindow(){
        if (guiData == null)
            return;

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++)
                guiData.rectangles.get(row).get(col).setFill(Renderer.GetColor(square.data[row][col]));

        }
        guiData.StatusLabel.setFill(Renderer.StateColor(threadState));
        guiData.StatusLabel.setText(Helper.StateString(threadState));
    }
}
