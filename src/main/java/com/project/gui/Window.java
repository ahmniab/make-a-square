package com.project.gui;
import com.almasb.fxgl.app.GameApplication ;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.project.data.Pieces;
import com.project.data.RectSize;
import com.project.data.Square;


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
        float scale = 0.5f;

        Renderer.DrawPiece(Pieces.NewOPiece() , 10  , 10 , scale);
        Renderer.DrawPiece(Pieces.NewIPiece() , 200 , 10 , scale);
        Renderer.DrawPiece(Pieces.NewZPiece() , 300 , 10 , scale);
        Renderer.DrawPiece(Pieces.NewLPiece() , 500 , 10 , scale);



        Square s = new Square();

        RectSize SquareSize = Renderer.PXSize(s , scale);
        Renderer.DrawSquare(s , WindowWidth / 2 - SquareSize.w / 2 ,
                                WindowHeight/ 2 - SquareSize.h / 2 , scale);

    }

    public void start(String[] args) {
        launch(args);
    }
}
