package com.project.data;

public class Piece {
    private static int idCounter = 0;
    public int piece_number;
    public int rows;
    public int columns;
    public int rotations;
    public String[] Lines;
    public boolean[][] description;


    public Piece(int r,int c,String[] l) {
        this.piece_number = idCounter++;
        this.rows = r;
        this.columns = c;
        this.Lines = l;
        setDescription(Lines);
        SetRotations();
    }
    
    public Piece(int r, int c, String[] l, int id) {
        this.piece_number = id;
        this.rows = r;
        this.columns = c;
        this.Lines = l;
        setDescription(Lines);
        SetRotations();
    }
    
    public Piece(Piece p) {
        this.piece_number = p.piece_number;
        this.rows = p.rows;
        this.columns = p.columns;
        this.Lines = p.Lines;
        setDescription(Lines);
        SetRotations();
    }

    private void setDescription(String[] Lines) {
        this.description = new boolean[this.rows][this.columns];
        for (int i= 0;i<this.rows;i++)
            for(int j=0;j<this.columns;j++)
                this.description[i][j] = Lines[i].charAt(j) == '1';
    }
    
    private void SetRotations ()
    {
        this.rotations = PossibleRotations(this);
    }

    private static int PossibleRotations(Piece p)
    {
        if (p.rows == 1 && p.columns == 1) return 1;
        
        if (p.rows == p.columns) {
            int rotations = 4;

            if (IsSymmetricalOnX(p.description)) rotations -= 2;
            if (IsSymmetricalOnY(p.description)) rotations -= 2;

            if (rotations == 0) return 1;

            return rotations;
        } else {
            for (int i = 0; i < p.rows; i++) {
                for (int j = 0; j < p.columns; j++) {
                    if (p.description[i][j] == false) return 4;
                }
            }
            return 2;
        }
    }
    
    public static boolean IsSymmetricalOnX (boolean[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;

        // Check each row in the top half with its mirror row in the bottom half
        for (int i = 0; i < height / 2; i++) {
            boolean[] topRow = matrix[i];
            boolean[] bottomRow = matrix[height - i - 1];

            for (int j = 0; j < width; j++) {
                if (topRow[j] != bottomRow[j]) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public static boolean IsSymmetricalOnY (boolean[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;

        // Check each column in the left half with its mirror column in the right half
        for (int j = 0; j < height; j++) {
            for (int x = 0; x < width / 2; x++) {
                if (matrix[j][x] != matrix[j][width - x - 1]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
