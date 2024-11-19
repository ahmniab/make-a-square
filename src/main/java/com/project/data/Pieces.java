package com.project.data;

import javafx.scene.paint.Color;

public class Pieces  {
    public static int ID = 0;
    public static Piece NewOPiece() {
        boolean [][] discription = {
                {true,true},
                {true,true}
        };

        return new Piece(ID++, Color.TOMATO,discription);

    }
    public static Piece NewIPiece() {
        boolean [][] discription = {
                {true},
                {true},
                {true}
        };

        return new Piece(ID++, Color.GREENYELLOW,discription);

    }
    public static Piece NewZPiece() {
        boolean [][] discription = {
                {true , true , false },
                {false , true , true },

        };

        return new Piece(ID++, Color.BROWN,discription);

    }

    public static Piece NewLPiece() {
        boolean [][] discription = {
                {true , false },
                {true , false },
                {true , true  },

        };

        return new Piece(ID++, Color.CADETBLUE,discription);

    }

}
