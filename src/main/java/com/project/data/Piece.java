package com.project.data;

public class Piece {
    private static int idCounter = 0;
    public int piece_number;
    public int rows;
    public int columns;
    public int rotations;
    public String[] Lines;
    public boolean [][] description;


    public Piece(int r,int c,String[] l) {
        this.piece_number = idCounter++;
        this.rows = r;
        this.columns = c;
        this.Lines = l;
        setDescription(Lines);
        SetRotations();
    }
    public Piece(int r, int c, String[] l, int id) {
        this.piece_number = id;
        this.rows = r;
        this.columns = c;
        this.Lines = l;
        setDescription(Lines);
        SetRotations();
    }

    private void setDescription(String[] Lines) {
        this.description = new boolean[this.rows][this.columns];
        for (int i= 0;i<this.rows;i++)
            for(int j=0;j<this.columns;j++)
                this.description[i][j] = Lines[i].charAt(j) == '1';
    }
    private void SetRotations ()
    {
        if (this.rows == this.columns) this.rotations = 3;
        else if (this.rows == 1 || this.columns ==1) this.rotations = 2;
        else this.rotations = 0;

    }

    public void ResetRotations(){
        SetRotations();
    }

    public static int  PossibleRotatins(int r, int c)
    {
        if (r == c) return  1;
        else if (r == 1 || c ==1) return  2;
        else return  4;
    }
}
