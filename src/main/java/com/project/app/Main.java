package com.project.app;
import java.io.IOException;
import java.util.Arrays;
import com.project.data.*;
import com.project.gui.*;

public class Main {
    public static void main(String[] args) throws IOException {

/*
        Piece[] ps = {
                new Piece(3, 2, new String[]{
                        "11", // T-shape
                        "01",
                        "01"
                }),
                new Piece(2, 3, new String[]{
                        "111", // T-shape
                        "010"
                }),
                new Piece(3, 2, new String[]{
                        "01",  // L-shape
                        "01",
                        "11"
                }),

                new Piece(1, 3, new String[]{
                        "111" // Straight horizontal
                }),

                new Piece(1, 1, new String[]{
                        "1" // Straight horizontal
                })
        };*/

/*
        GlobalData data = GlobalData.getInstance();
        data.trackers = Elements.GenerateNTrackers(1);
        data.MainTracker = new ThreadTracker(new Square(),-1);
        data.MainTracker.threadState = ThreadState.RUNNING;
        data.pieces = ps;
        PuzzleSolver solver = new PuzzleSolver(data.trackers[0]);
        solver.start();

        Window w = new Window();
        w.start(args);*/

        Piece[][] pp = DataEntry.ThreadsData("p.txt");
        /*

        Piece[] pp = PieceOperations.getAllRotations(1, 1, new String[]{
                "1"
        });


        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        for (Piece p : pp){
            PieceOperations.PrintPiece(p);
        System.out.println();}*/



    }
}
