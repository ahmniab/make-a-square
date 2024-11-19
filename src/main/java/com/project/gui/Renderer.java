package com.project.gui;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.SpawnData;
import com.project.data.Piece;
import javafx.scene.paint.Color;

public class Renderer {
    final static int BlockWidth = 50;
    final static int margin = 2;
    public static void DrawPiece(Piece p , int x , int y){
        int XMargin = 0;
        int YMargin = 0;
        for (int row = 0; row < p.discription.length; row++) {
            for (int col = 0; col < p.discription[row].length; col++) {
                if(p.discription[row][col]){
                    FXGL.spawn("block",
                            new SpawnData(x + col * (BlockWidth + YMargin), y + row * (BlockWidth + XMargin))
                                    .put("color", p.color)
                                    .put("width", BlockWidth));
                }
                YMargin = margin;
            }
            XMargin = margin;
            YMargin = 0;


        }
    }
}
