package com.project.app;
import com.project.data.*;

public class PieceOperations {

    public static void rotateClockWise(Piece piece) {
        boolean[][] rotated = new boolean[piece.columns][piece.rows];

        for (int i = 0; i < piece.rows; i++)
            for (int j = 0; j < piece.columns; j++)
                rotated[j][piece.rows - 1 - i] = piece.discription[i][j];

        piece.discription = rotated;

        int temp = piece.rows;
        piece.rows = piece.columns;
        piece.columns = temp;
    }

    public static void PrintPiece(Piece piece)
    {
        for (int i = 0; i < piece.rows; i++)
        {
            for (int j = 0; j < piece.columns; j++)
                System.out.print(piece.discription[i][j]?"1":"0");

            System.out.println();
        }


    }
}
