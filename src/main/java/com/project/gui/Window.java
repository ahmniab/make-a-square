package com.project.gui;
import com.almasb.fxgl.app.GameApplication ;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.project.data.*;
import javafx.scene.input.KeyCode;

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
                for (int i = 0; i < GlobalData.solvers.length; i++) {
                    if (GlobalData.solvers[i].getState() == Thread.State.NEW) {
                        GlobalData.solvers[i].start();
                    }
                }
                if(GlobalData.MainTracker.threadState == ThreadState.NOT_STARTED)
                    GlobalData.MainTracker.threadState = ThreadState.RUNNING;
            });
    }

    @Override
    protected void initGame() {
        FXGL.getGameWorld().addEntityFactory(new Factory());
        Renderer.DrawThreadTrackers(GlobalData.trackers , 1f);

        ThreadTracker MainTracker = GlobalData.MainTracker;

        Renderer.DrawTracker(MainTracker ,
                150 , WindowHeight / 2 -
                        Renderer.PXSize(MainTracker.square,1.5f).h / 2 - 100 ,
                1.5f);

        float PieceScale = 0.5f;
        int h = (int)Renderer.PXSize(new Square(),PieceScale).h;

        Renderer.DrawPieces(GlobalData.pieces,
                30, WindowHeight - h - 30, PieceScale);
    }

    public void start(String[] args) {
        launch(args);
    }
}
