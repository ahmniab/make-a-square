package com.project.data;

import javafx.scene.paint.Color;

public class Piece {
    private static int idCounter = 1;
    public int piece_number;
    public int rows;
    public int columns;
    public int rotations;
    public boolean [][] discription;


    public Piece(int r,int c,String[] Lines) {
        this.piece_number = idCounter++;
        this.rows = r;
        this.columns = c;
        setDiscription(Lines);
    }

    private void setDiscription(String[] Lines) {
        this.discription = new boolean[this.rows][this.columns];
        for (int i= 0;i<this.rows;i++)
            for(int j=0;j<this.columns;j++)
                this.discription[i][j] = Lines[i].charAt(j) == '1';
    }
    private void SetRotations ()
    {
        if (this.rows == this.columns) this.rotations = 3;
        else if (this.rows == 1 || this.columns ==1) this.rotations = 2;
        else this.rotations = 0;


    }
}
