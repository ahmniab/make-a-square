package com.project.app;

import com.project.data.*;
import java.util.Stack;

public class Solver  {
    ThreadTracker t ;
    public Solver(ThreadTracker tracker) {
        t=tracker;
    }

    public boolean IsValid (Piece p,Square s ,int x,int y){
        for(int i=0;i<p.rows;i++)
            for(int j=0;j<p.columns;j++)
                if(p.discription[i][j])
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
                if (p.discription[i][j]) {
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

    public boolean Solve (Piece[] pieces){
        Square s = t.square;
        Stack<State> stack = new Stack<>();
        stack.push(new State( 0, 0, 0 ,s));
        while (!stack.isEmpty()) {

            State cs = stack.pop();
            if(IsSolved(cs.S)) return true ;

            if(cs.index >= pieces.length) return false;

            Piece C_piece = pieces[cs.index];


            for (int i =cs.x; i<4; i++){
                for(int j = ( i == cs.x ? cs.y : 0); j<4; j++){
                    if(IsValid(C_piece,cs.S,i,j)){
                        Square NewSquare = PutPiece(C_piece,cs.S,i,j);
                        stack.push(new State( 0, 0, cs.index + 1, NewSquare));
                    }

                }
            }
            if(PieceOperations.IsRotatable(pieces[cs.index])) {
                PieceOperations.rotateClockWise(pieces[cs.index]);
                stack.push(new State(0, 0, cs.index, cs.S));
            }


            for (int i =0;i<4;i++) {
                for (int j = 0; j < 4; j++)
                    System.out.print(stack.peek().S.data[i][j] +"   ");
                System.out.println();
            }
            s.data = stack.getLast().S.data;
            if (t.UpdateWindow != null)t.UpdateWindow.run();
            System.out.println();
            System.out.println();
            System.out.println();
            try {
                Thread.sleep(300);

            } catch (Exception e) {
                break;
            }

        }
        return false;
    }
}
