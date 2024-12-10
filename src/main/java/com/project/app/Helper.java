package com.project.app;

import com.project.data.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Helper {
    public static boolean Init(){
        //init vars
        File inputs_path = new File("inputs/");
        File[] files = inputs_path.listFiles();
        Piece[] allPieces;

        // list all files
        if(files!=null){
            int i = 1;
            for(File file : files){
                if(file.isFile())
                    System.out.println((i++) + " : " +file.getName());
            }
        }else return false;

        //genarate pieces
        int file_number = ScanInt("Enter input file number : " , 1 , files.length) - 1;
        try {
            allPieces = GetPiecesFromFile(files[file_number]);
        }
        catch (Exception e){
            return false;
        }

        //init threads
        GlobalData.Init(allPieces[0].rotations, allPieces);

        GlobalData.solvers = new PuzzleSolver[GlobalData.TrackerNumber];
        for (int i = 0; i < GlobalData.TrackerNumber; i++) { // assign trackers to its thread
            GlobalData.solvers[i] = new PuzzleSolver(GlobalData.trackers[i]);
        }

        return true;
    }

    public static int ScanInt(String text, int min, int max){
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.print(text);
            try {
                int x = s.nextInt();
                if (!(x < min || x > max)) return x;
            } catch (Exception e) {
                System.out.println("Invalid input");
                s.nextLine();
            }
        }
    }

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
