package com.project.gui;
import com.almasb.fxgl.app.GameApplication ;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.project.app.PuzzleSolver;
import com.project.data.*;
import javafx.scene.input.KeyCode;
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
    protected void initInput() {
        FXGL.onKey(KeyCode.ENTER, "Start Solving",
                () -> {
                    GlobalData __data = GlobalData.getInstance();
                    for (int i = 0; i < __data.solvers.length; i++) {
                        if (__data.solvers[i].getState() == Thread.State.NEW) {
                            __data.solvers[i].start();
                        }
                    }
                });
    }

    @Override
    protected void initGame() {
        FXGL.getGameWorld().addEntityFactory(new Factory());
        float ThreadScale = 1f;
        ThreadTracker[] trackers = GlobalData.getInstance().trackers;
        Renderer.DrawThreadTrackers(trackers , ThreadScale);

        ThreadTracker MainTracker = GlobalData.getInstance().MainTracker;

        Renderer.DrawTracker(MainTracker ,
                150 , WindowHeight / 2 -
                        Renderer.PXSize(MainTracker.square,1.5f).h / 2 - 100 ,
                1.5f);


    }

    public void start(String[] args) {
        launch(args);
    }
}
