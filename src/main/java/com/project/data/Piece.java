package com.project.data;

import javafx.scene.paint.Color;

public class Piece {
    public int piece_number;
    public int rows;
    public int columns;
    public boolean [][] discription;
    public Color color;
    public Piece(int piece_number, Color color ,boolean [][] discription ) {
        setDiscription(discription);
        this.color = color;
        this.piece_number = piece_number;
    }

    public Piece(int piece_number, Color color) {
        this.color = color;
        this.piece_number = piece_number;
    }

    public void setDiscription(boolean[][] discription) {
        this.discription = discription;
        this.rows = discription.length;
        this.columns = discription[0].length;
    }
}
