package com.project.data;

public class Square {
    private static Square instance ;
    public int [][] data ;

    public Square(){
        int [][] _data = {
                {-1 , -1 , -1 , -1}, // -1 = empty
                {-1 , -1 , -1 , -1}, // -1 = empty
                {-1 , -1 , -1 , -1}, // -1 = empty
                {-1 , -1 , -1 , -1}, // -1 = empty
        };
        data = _data;
    }
    public Square(int [][] _data){
        data = _data;
    }
}
