package com.project.data;

public class State {
    public int x;
    public int y;
    public int index;
    public Square S;

    public State (int rows,int col,int i,Square grid){
        x=rows;
        y= col;
        index = i;
        S = grid ;
    }
}
