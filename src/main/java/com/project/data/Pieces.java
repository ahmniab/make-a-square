package com.project.data;

public class Pieces  {
    public static int ID = 0;
    public static Piece NewOPiece() {
        boolean [][] discription = {
                {true,true},
                {true,true}
        };

        return new Piece(ID++, discription);

    }
    public static Piece NewIPiece() {
        boolean [][] discription = {
                {true},
                {true},
                {true},
                {true}
        };

        return new Piece(ID++, discription);

    }
    public static Piece NewZPiece() {
        boolean [][] discription = {
                {true , true , false },
                {false , true , true },

        };

        return new Piece(ID++, discription);

    }

    public static Piece NewLPiece() {
        boolean [][] discription = {
                {true , false },
                {true , false },
                {true , true  },

        };

        return new Piece(ID++, discription);

    }

}
