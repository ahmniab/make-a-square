package com.project.app;
import com.project.data.*;
import com.project.gui.*;

public class Main {
    public static void main(String[] args) {
        if (Helper.Init()) {
            Window window = new Window();
            window.start(args);
        } else {
            System.out.println("Initialization failed");
        }
    }
}
