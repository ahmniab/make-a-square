package com.project.app;

import com.project.data.*;

import java.io.File;
import java.util.Scanner;

public class Helper {
    static Scanner s = new Scanner(System.in);
    public static boolean Init(){
        //init vars
        File inputs_path = new File("inputs/");
        File[] files = inputs_path.listFiles();
        Piece [][] allPieces;

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
            allPieces = DataEntry.ThreadsData(inputs_path.getName()+"/"+files[file_number].getName());
        }
        catch (Exception e){
            return false;
        }

        //init threads
        GlobalData.TrackerNumber = allPieces.length;
        GlobalData __data = GlobalData.getInstance();
        for (int i = 0; i < __data.trackers.length; i++) { // assign pieces to its thread tracker
            __data.trackers[i].pieces = allPieces[i];
        }

        __data.solvers = new PuzzleSolver[__data.trackers.length];
        for (int i = 0; i < __data.trackers.length; i++) { // assign trackers to its thread
            __data.solvers[i] = new PuzzleSolver(__data.trackers[i]);
        }


        return true;
    }
    public static int ScanInt(String text){
        while (true) {
            System.out.print(text);
            try {
                return s.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
    }
    public static int ScanInt(String text, int min, int max){
        while (true) {
            System.out.print(text);
            try {
                int x = s.nextInt();
                if (!(x < min || x > max)) return x;
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
    }

    public static String StateString(ThreadState state){
        String s = "Failed to get status";
        switch (state){
            case FAILED      -> s = "Failed To Solve"      ;
            case RUNNING     -> s = "Running Now"          ;
            case SUCCEEDED   -> s = "Succeeded"            ;
            case NOT_STARTED -> s = "Thread Didn't Started";
        }
        return s;
    }

}
