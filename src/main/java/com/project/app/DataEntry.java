package com.project.app;

import com.project.data.Piece;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class DataEntry {


    public static Piece[] ThreadsData (String filePath) throws IOException
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            int numPieces = Integer.parseInt(reader.readLine().trim());

//            String[] firstDimensions = reader.readLine().trim().split(" ");
//            int FirstRows = Integer.parseInt(firstDimensions[0]);
//            int FirstColumns = Integer.parseInt(firstDimensions[1]);
//            List<String> Firstshape = new ArrayList<>();
//            for (int j = 0; j < FirstRows; j++) {
//                Firstshape.add(reader.readLine().trim());
//            }
//            int numRotation = Piece.rotations;
//            Piece [][] DE = new Piece[numRotation][numPieces];
//            Piece [] FirstRotations = PieceOperations.getAllRotations(FirstRows,FirstColumns,Firstshape.toArray(new String[0]));
//
//            for(int i = 0; i < FirstRotations.length; i++)
//                DE[i][0] = FirstRotations[i];

            Piece [] DE = new Piece[numPieces];

            for (int i = 0; i < numPieces; i++)
            {
                String[] Dimensions = reader.readLine().trim().split(" ");
                int Rows = Integer.parseInt(Dimensions[0]);
                int Columns = Integer.parseInt(Dimensions[1]);
                List<String> shape = new ArrayList<>();
                for (int j = 0; j < Rows; j++) {
                    shape.add(reader.readLine().trim());
                }
                
                DE[i] = new Piece(Rows, Columns, shape.toArray(new String[0]), i );

            }

            return DE;
        }
    }
}
