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
            current = RotateCopy(current);
        }

        return rotations.toArray(new Piece[0]);
    }

    public static Piece RotateCopy(Piece p) {
        String[] rotatedLines = new String[p.columns]; // Rotated matrix will have `cols` rows
        for (int j = 0; j < p.columns; j++) {
            StringBuilder newRow = new StringBuilder();
            for (int i = p.rows - 1; i >= 0; i--) {
                newRow.append(p.Lines[i].charAt(j));
            }
            rotatedLines[j] = newRow.toString();
        }
        return new Piece(p.columns, p.rows, rotatedLines, p.piece_number); // Swap rows and cols for new piece
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
