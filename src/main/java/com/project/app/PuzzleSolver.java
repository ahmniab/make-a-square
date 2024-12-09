package com.project.app;

import com.project.data.*;

import java.util.Stack;

public class PuzzleSolver extends Thread {
    ThreadTracker tracker;
    
    public PuzzleSolver(ThreadTracker tracker){
        super();
        this.tracker = tracker;
        tracker.ThreadName = "Thread " + this.tracker.id;
    }
    
    @Override
    public void run() {
        System.out.println(getName()+" Started");
        tracker.threadState = ThreadState.RUNNING;
        boolean success = Solve();
        if (success) {
            tracker.threadState = ThreadState.SUCCEEDED;
            GlobalData.SubmitSolution(tracker);

        } else {
            tracker.threadState = ThreadState.FAILED;
            GlobalData.SubmitFailed();
        }
    }

    public boolean IsValid (Piece p, Square s, int x, int y){
        for(int i=0; i < p.rows; i++)
            for(int j=0; j < p.columns; j++)
                if(p.description[i][j])
                {
                    int XIndex = x + i;
                    int YIndex = y + j;
                    if (XIndex >= 4) return false;
                    if (YIndex >= 4) return false;
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

    public boolean IsSolved (Square s) {
        for (int i = 0;i<4;i++)
            for (int j=0;j<4;j++)
                if(s.data[i][j] == -1)
                    return false;
        return true;
    }

    public boolean Solve (){
        Square s = tracker.square;
        
        Piece pieces[] = new Piece[GlobalData.pieces.length];
        for (int i = 0; i < pieces.length; i++) {
            pieces[i] = new Piece(GlobalData.pieces[i]);
        }
        
        for (int i = 0; i < tracker.id; i++)
            PieceOperations.rotateClockWise(pieces[0]);
        Square square_state = new Square();
        Stack<SquareState> stack = new Stack<>();
        stack.push(new SquareState(0 ,square_state));
        
        while (!stack.isEmpty()) {
            SquareState current_state = stack.pop();

            if (GlobalData.MainTracker.threadState == ThreadState.SUCCEEDED) {
                return IsSolved(current_state.S);
            }

            if(IsSolved(current_state.S)) {
                return true;
            }
            
            if (current_state.index_of_piece >= pieces.length) return false;

            Piece C_piece = pieces[current_state.index_of_piece];

            int PieceRotations = C_piece.rotations;
            for (int rotaion = 0; rotaion < PieceRotations; rotaion++) {
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (IsValid(C_piece, current_state.S, i, j)) {
                            Square NewSquare = PutPiece(C_piece, current_state.S, i, j);
                            stack.push(new SquareState(current_state.index_of_piece + 1, NewSquare));
                            s.data = stack.peek().S.data;
                            //if (current_state.index_of_piece < pieces.length - 2) continue;
                            try {
                                Thread.sleep(300);
                            } catch (Exception e) {
                                break;
                            }
                        }
                    }
                }
                if (current_state.index_of_piece == 0) break;
                PieceOperations.rotateClockWise(pieces[current_state.index_of_piece]);
            }
            
//            for (int i =0;i<4;i++) {
//                for (int j = 0; j < 4; j++)
//                    System.out.print(stack.peek().S.data[i][j] +"   ");
//                System.out.println();
//            }
//            System.out.println();
//            System.out.println();
//            System.out.println();
        }
        
        return false;
    }
}
