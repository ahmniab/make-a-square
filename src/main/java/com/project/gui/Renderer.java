package com.project.gui;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.SpawnData;
import com.project.data.Piece;
import com.project.data.RectSize;
import com.project.data.Square;
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
    public static void DrawSquare(Square s , int x , int y){
        int XMargin = 0;
        int YMargin = 0;
        for (int row = 0; row < s.data.length; row++) {
            for (int col = 0; col < s.data[row].length; col++) {
                int BlockX = x + col * (BlockWidth + YMargin);
                int BlockY = y + row * (BlockWidth + XMargin);
                if(s.data[row][col] == -1){ // empty block
                    FXGL.spawn("block",
                            new SpawnData(BlockX, BlockY)
                                    .put("color", Color.GRAY)
                                    .put("width", BlockWidth));
                }else {
                    // draw piece color
                }
                YMargin = margin;
            }
            XMargin = margin;
            YMargin = 0;


        }
    }
    public static RectSize PXSize(Piece p){
        int h =  p.discription.length    * (BlockWidth + margin);
        int w =  p.discription[0].length * (BlockWidth + margin);
        return new RectSize(w,h);
    }
    public static RectSize PXSize(Square s){
        int h =  s.data.length    * (BlockWidth + margin);
        int w =  s.data[0].length * (BlockWidth + margin);
        return new RectSize(w,h);
    }
}
