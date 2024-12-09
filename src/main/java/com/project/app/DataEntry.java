package com.project.app;

import com.project.data.Piece;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class DataEntry {


    public static Piece[] GetPiecesFromFile (File file) throws IOException
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            int numPieces = Integer.parseInt(reader.readLine().trim());
            
            Piece[] pieces = new Piece[numPieces];

            for (int i = 0; i < numPieces; i++)
            {
                String[] Dimensions = reader.readLine().trim().split(" ");
                int Rows = Integer.parseInt(Dimensions[0]);
                int Columns = Integer.parseInt(Dimensions[1]);
                List<String> shape = new ArrayList<>();
                for (int j = 0; j < Rows; j++) {
                    shape.add(reader.readLine().trim());
                }
                
                pieces[i] = new Piece(Rows, Columns, shape.toArray(new String[0]), i );

            }

            return pieces;
        }
    }
}
