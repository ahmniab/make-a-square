package com.project.app;
import com.project.data.*;
import java.util.ArrayList;
import java.util.List;

public class PieceOperations {

    public static void rotateClockWise(Piece piece) {
        boolean[][] rotated = new boolean[piece.columns][piece.rows];

        for (int i = 0; i < piece.rows; i++)
            for (int j = 0; j < piece.columns; j++)
                rotated[j][piece.rows - 1 - i] = piece.description[i][j];

        piece.description = rotated;

        int temp = piece.rows;
        piece.rows = piece.columns;
        piece.columns = temp;
    }



    public static Piece[] getAllRotations(int rows ,int cols,String [] lines) {
        List<Piece> rotations = new ArrayList<>();
        Piece current = new Piece(rows, cols, lines);
        int Num = Piece.PossibleRotatins(rows,cols);

        // Add all four rotations
        for (int i = 0; i < Num; i++) {
            rotations.add(current);
            current = RotateCopy( current.rows,current.columns, current.Lines);
        }

        return rotations.toArray(new Piece[0]);
    }

    public static Piece RotateCopy(int rows ,int cols,String [] lines) {
        String[] rotatedLines = new String[cols]; // Rotated matrix will have `cols` rows
        for (int j = 0; j < cols; j++) {
            StringBuilder newRow = new StringBuilder();
            for (int i = rows - 1; i >= 0; i--) {
                newRow.append(lines[i].charAt(j));
            }
            rotatedLines[j] = newRow.toString();
        }
        return new Piece(cols, rows, rotatedLines); // Swap rows and cols for new piece
    }

    public static void PrintPiece(Piece piece) {
        for (int i = 0; i < piece.rows; i++)
        {
            for (int j = 0; j < piece.columns; j++)
                System.out.print(piece.description[i][j]?"1":"0");

            System.out.println();
        }

    }

}
