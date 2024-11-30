package com.project.app;
import java.util.Arrays;
import com.project.data.*;
import com.project.gui.*;

public class Main {
    public static void main(String[] args) {


        Piece[] ps = {
        new Piece(2, 3,
                new String[]{
                        "111",
                        "101"
                }),
        new Piece(4, 2,
                new String[]{
                        "01",
                        "01",
                        "11",
                        "01"
                }),
        new Piece(1, 1,
                new String[]{
                        "1",

                }),
        new Piece(1, 1,
                new String[]{
                        "1",

                }),
        new Piece(3, 2,
                new String[]{
                        "10",
                        "10",
                        "11"
                })
    };

        GlobalData data = GlobalData.getInstance();
        data.trackers = Elements.GenerateNTrackers(1);
        data.MainTracker = new ThreadTracker(new Square(),-1);
        data.pieces = ps;
        PuzzleSolver solver = new PuzzleSolver(data.trackers[0]);
        solver.start();

        Window w = new Window();
        w.start(args);







    }
}
