package com.project.data;

public class Square {
    private static Square instance ;
    public int [][] data ;
    public static Square GitInstance(){
        if(instance == null){
            instance = new Square();
        }
        return instance;
    }
    private Square(){
        int [][] _data = {
                {-1 , -1 , -1 , -1}, // -1 = empty
                {-1 , -1 , -1 , -1}, // -1 = empty
                {-1 , -1 , -1 , -1}, // -1 = empty
                {-1 , -1 , -1 , -1}, // -1 = empty
        };
        data = _data;
    }
}
