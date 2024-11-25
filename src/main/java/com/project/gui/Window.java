package com.project.gui;
import com.almasb.fxgl.app.GameApplication ;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.project.data.*;
import javafx.stage.Screen;


public class Window extends GameApplication {
    final int WindowWidth = 1400, WindowHeight = 750;
    @Override
    protected void initSettings(GameSettings Settings) {
        Settings.setWidth(WindowWidth);
        Settings.setHeight(WindowHeight);
        Settings.setTitle("project5 make a square");
        Settings.setGameMenuEnabled(false);
    }

    @Override
    protected void initGame() {
        FXGL.getGameWorld().addEntityFactory(new Factory());
        float ThreadScale = 1f;
        ThreadTracker[] trackers = Elements.GenerateNTrackers(6);
        Renderer.DrawThreadTrackers(trackers , ThreadScale);

        ThreadTracker MainTracker = new ThreadTracker(new Square() ,-1);
        MainTracker.threadState = ThreadState.RUNNING;
        Renderer.DrawTracker(MainTracker ,
                150 , WindowHeight / 2 -
                        Renderer.PXSize(MainTracker.square,1.5f).h / 2 - 100 ,
                1.5f);




    }

    public void start(String[] args) {
        launch(args);
    }
}
