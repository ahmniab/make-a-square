package com.project.gui;
import com.almasb.fxgl.app.GameApplication ;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.SpawnData;
import com.project.data.Pieces;
import com.project.data.RectSize;
import com.project.data.Square;
import javafx.scene.paint.Color;


public class Window extends GameApplication {
    final int WindowWidth = 1400, WindowHeight = 750;
    @Override
    protected void initSettings(GameSettings gameSettings) {
        gameSettings.setWidth(WindowWidth);
        gameSettings.setHeight(WindowHeight);
        gameSettings.setTitle("project5 make a square");
    }

    @Override
    protected void initGame() {
        FXGL.getGameWorld().addEntityFactory(new Factory());
        /*
        Renderer.DrawPiece(Pieces.NewOPiece() , 10  , 10);
        Renderer.DrawPiece(Pieces.NewIPiece() , 200 , 10);
        Renderer.DrawPiece(Pieces.NewZPiece() , 300 , 10);
        Renderer.DrawPiece(Pieces.NewLPiece() , 500 , 10);

         */

        Square s = Square.GitInstance();
        RectSize SquareSize = Renderer.PXSize(s);
        Renderer.DrawSquare(s , WindowWidth / 2 - SquareSize.w / 2 ,
                                WindowHeight/ 2 - SquareSize.h / 2 );

    }

    public void start(String[] args) {
        launch(args);
    }
}
