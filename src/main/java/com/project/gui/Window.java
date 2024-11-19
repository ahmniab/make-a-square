package com.project.gui;
import com.almasb.fxgl.app.GameApplication ;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.SpawnData;
import com.project.data.Pieces;
import javafx.scene.paint.Color;


public class Window extends GameApplication {
    @Override
    protected void initSettings(GameSettings gameSettings) {
        gameSettings.setWidth(1400);
        gameSettings.setHeight(750);
        gameSettings.setTitle("project5 make a square");
    }

    @Override
    protected void initGame() {
        FXGL.getGameWorld().addEntityFactory(new Factory());
        Renderer.DrawPiece(Pieces.NewOPiece() , 10 , 10);
        Renderer.DrawPiece(Pieces.NewIPiece() , 200 , 10);
        Renderer.DrawPiece(Pieces.NewZPiece() , 300 , 10);
        Renderer.DrawPiece(Pieces.NewLPiece() , 500 , 10);
    }

    public void start(String[] args) {
        launch(args);
    }
}
