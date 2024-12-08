package com.project.data;


import com.project.app.PuzzleSolver;

import java.util.List;

public class Elements {

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
