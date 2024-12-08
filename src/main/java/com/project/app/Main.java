package com.project.app;
import java.io.IOException;
import java.util.Arrays;
import com.project.data.*;
import com.project.gui.*;

public class Main {
    public static void main(String[] args) {
        if (Helper.Init()){
            Window window = new Window();
//            GlobalData.getInstance().StartThreads.run();
            window.start(args);
        }else {
            System.out.println("Initialization failed");
        }


    }
}
