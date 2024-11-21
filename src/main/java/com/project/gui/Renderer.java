package com.project.gui;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.SpawnData;
import com.project.data.Piece;
import com.project.data.RectSize;
import com.project.data.Square;
import javafx.scene.paint.Color;

public class Renderer {
    final static int BlockWidth = 50;
    final static int Margin = 2;
    public static void DrawPiece(Piece p , int x , int y , float scale){
        int XMargin = 0;
        int YMargin = 0;
        int ScaledWidth = (int)(BlockWidth * scale);

        for (int row = 0; row < p.discription.length; row++) {
            for (int col = 0; col < p.discription[row].length; col++) {
                if(p.discription[row][col]){
                    FXGL.spawn("block",
                            new SpawnData(x + col * (ScaledWidth + YMargin), y + row * (ScaledWidth + XMargin))
                                    .put("color", p.color)
                                    .put("width", ScaledWidth));
                }
                YMargin = Margin ;
            }
            XMargin = Margin;
            YMargin = 0;


        }
    }
    public static void DrawSquare(Square s , int x , int y , float scale ){
        int XMargin = 0;
        int YMargin = 0;
        int ScaledWidth = (int)(BlockWidth * scale);

        for (int row = 0; row < s.data.length; row++) {
            for (int col = 0; col < s.data[row].length; col++) {
                int BlockX = x + col * (ScaledWidth + YMargin);
                int BlockY = y + row * (ScaledWidth + XMargin);
                if(s.data[row][col] == -1){ // empty block
                    FXGL.spawn("block",
                            new SpawnData(BlockX, BlockY)
                                    .put("color", Color.GRAY)
                                    .put("width", ScaledWidth));
                }else {
                    // draw piece color
                }
                YMargin = Margin;
            }
            XMargin = Margin;
            YMargin = 0;


        }
    }
    public static RectSize PXSize(Piece p ,float scale){
        int ScaledWidth = (int)(BlockWidth * scale);

        int h =  p.discription.length    * ScaledWidth + Margin;
        int w =  p.discription[0].length * ScaledWidth + Margin;
        return new RectSize(w,h);
    }
    public static RectSize PXSize(Square s , float scale){
        int ScaledWidth = (int)(BlockWidth * scale);

        int h =  s.data.length    * ScaledWidth + Margin;
        int w =  s.data[0].length * ScaledWidth + Margin;
        return new RectSize(w,h);
    }
}
