package com.project.app;
import java.util.Arrays;
import com.project.data.*;
import com.project.gui.*;

public class Main {
    public static void main(String[] args) {
       /* Window window = new Window();
        window.start(args);*/

        Piece p = new Piece(2,3,
                new String[] {
                        "010",
                        "111"
                });

        PieceOperations.PrintPiece(p);

        PieceOperations.rotateClockWise(p);
        System.out.println();
        PieceOperations.PrintPiece(p);

PieceOperations.rotateClockWise(p);
        System.out.println();
        PieceOperations.PrintPiece(p);

PieceOperations.rotateClockWise(p);
        System.out.println();
        PieceOperations.PrintPiece(p);

PieceOperations.rotateClockWise(p);
        System.out.println();
        PieceOperations.PrintPiece(p);

        Window w = new Window();
        w.start(args);




    }
}
