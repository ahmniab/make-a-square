package com.project.data;

public class SquareState {
//    public int x;
//    public int y;
    public int index_of_piece;
    public Square S;

    public SquareState (int i, Square grid){
//        x=rows;
//        y= col;
        index_of_piece = i;
        S = grid ;
    }
}
