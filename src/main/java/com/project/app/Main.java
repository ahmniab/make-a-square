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
                        "111",
                        "101"
                });
        Piece p2 = new Piece(4,2,
                new String[] {
                        "01",
                        "01",
                        "11",
                        "01"
                });
        Piece p3 = new Piece(1,1,
                new String[] {
                        "1",

                });
        Piece p5 = new Piece(1,1,
                new String[] {
                        "1",

                });
        Piece p4 = new Piece(3,2,
                new String[] {
                        "10",
                        "10",
                        "11"
                });

        Piece[] ps={p,p2,p3,p4,p5};
        Square s = new Square();
        Solver so = new Solver();
        boolean bo = so.Solve(s,ps);
        System.out.println(bo);






    }
}
