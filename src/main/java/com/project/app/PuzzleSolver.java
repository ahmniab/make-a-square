package com.project.app;

import com.project.data.*;
import com.sun.source.tree.IfTree;

import java.util.Stack;

public class PuzzleSolver extends Thread{
    ThreadTracker tracker;
    public PuzzleSolver(ThreadTracker tracker){
        super();
        this.tracker = tracker;

    }
    @Override
    public void run() {
        System.out.println(getName()+" Started");
        tracker.threadState = ThreadState.RUNNING;
        boolean success = Solve();
        if (success) {
            tracker.threadState = ThreadState.SUCCEEDED;
            GlobalData.getInstance().SubmitSolution(tracker.square.data);

        }else {
            tracker.threadState = ThreadState.FAILED;
            GlobalData.getInstance().SubmitFailed();
        }


    }

    public boolean IsValid (Piece p, Square s , int x, int y){
        for(int i=0;i<p.rows;i++)
            for(int j=0;j<p.columns;j++)
                if(p.description[i][j])
                {
                    int XIndex = x + i;
                    int YIndex = y + j;
                    if (XIndex >= 4 )return false;
                    if (YIndex >= 4 )return false;
                    if (s.data[XIndex][YIndex] >= 0) return false;

                }
        return true;

    }

    private Square copySquare(Square s) {
        Square New = new Square();
        for (int i=0 ;i<4 ;i++)
        {
            System.arraycopy(s.data[i], 0, New.data[i], 0, 4);
        }
        return New;

    }

    public Square PutPiece (Piece p,Square s ,int x,int y){
        Square New = copySquare(s);
        for (int i = 0; i < p.rows; i++) {
            for (int j = 0; j < p.columns; j++) {
                if (p.description[i][j]) {
                    New.data[x+i][y+j] = p.piece_number ;
                }
            }
        }
        return New;

    }

    public boolean IsSolved (Square s){
        for (int i = 0;i<4;i++)
            for (int j=0;j<4;j++)
                if(s.data[i][j] == -1)
                    return false ;
        return true ;
    }

    public boolean Solve (){
        Square s = tracker.square;
        Piece [] pieces = tracker.pieces;
        Square S = new Square();
        Stack<com.project.data.State> stack = new Stack<>();
        stack.push(new com.project.data.State( 0, 0, 0 ,S));
        while (!stack.isEmpty()) {
            com.project.data.State cs = stack.pop();

            if (GlobalData.getInstance().MainTracker.threadState == ThreadState.SUCCEEDED) {
                return IsSolved(cs.S);
            }

            if(IsSolved(cs.S)) {
                return true;
            }

            if(cs.index >= pieces.length) return false;

            Piece C_piece = pieces[cs.index];

            int PieceRotations = 4-pieces[cs.index].rotations;
            for (int rotaion = 0;rotaion<PieceRotations; rotaion++) {
                for (int i = cs.x; i < 4; i++) {
                    for (int j = (i == cs.x ? cs.y : 0); j < 4; j++) {
                        if (IsValid(C_piece, cs.S, i, j)) {
                            Square NewSquare = PutPiece(C_piece, cs.S, i, j);
                            stack.push(new com.project.data.State(0, 0, cs.index + 1, NewSquare));
                            s.data = stack.peek().S.data;
                            try {
                                Thread.sleep(300);

                            } catch (Exception e) {
                                break;
                            }
                        }

                    }
                }
                if (cs.index == 0) break;
                PieceOperations.rotateClockWise(pieces[cs.index]);

            }

            pieces[cs.index].ResetRotations();



            for (int i =0;i<4;i++) {
                for (int j = 0; j < 4; j++)
                    System.out.print(stack.peek().S.data[i][j] +"   ");
                System.out.println();
            }
            System.out.println();
            System.out.println();
            System.out.println();

        }
        return false;
    }

}
