package com.project.gui;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.SpawnData;
import com.project.data.*;
import javafx.scene.paint.Color;

public class Renderer {
    // global rendering data
    final static int BlockWidth = 50;
    final static int Margin = 2;
    final static int TextSectionSize = 150;


    // thread data
    private final static Color Colors[] = {
            Color.TOMATO ,
            Color.GREENYELLOW ,
            Color.BROWN ,
            Color.CADETBLUE,
            Color.ROYALBLUE,
            Color.DEEPPINK
    };
    public static Color GetColor(int id){
        if (id >= 0 && id <= Colors.length ) return Colors[id];
        return Color.LIGHTGRAY;
    }
    public static Color StateColor(ThreadState state){
        Color c = Color.BLACK;
        switch (state){
            case NOT_STARTED -> c = Color.BLACK;
            case RUNNING     -> c = Color.BLUE ;
            case SUCCEEDED   -> c = Color.GREEN;
            case FAILED      -> c = Color.RED  ;

        }
        return c;
    }
    public static String StateString(ThreadState state){
        String s = "Failed to get status";
        switch (state){
            case FAILED      -> s = "Failed to solve"      ;
            case RUNNING     -> s = "Running now"          ;
            case SUCCEEDED   -> s = "Succeeded"            ;
            case NOT_STARTED -> s = "Thread hasn't started";
        }
        return s;
    }

    //pieces
    public static void DrawPiece(Piece p , int x , int y , float scale){
        int XMargin = 0;
        int YMargin = 0;
        int ScaledWidth = (int)(BlockWidth * scale);

        for (int row = 0; row < p.description.length; row++) {
            for (int col = 0; col < p.description[row].length; col++) {
                if(p.description[row][col]){
                    FXGL.spawn("block",
                            new SpawnData(x + col * (ScaledWidth + YMargin), y + row * (ScaledWidth + XMargin))
                                    .put("color", Colors[p.piece_number])
                                    .put("width", ScaledWidth));
                }
                YMargin = Margin ;
            }
            XMargin = Margin;
            YMargin = 0;


        }
    }
    public static void DrawPieces(Piece[] ps, int x, int y , float scale){
        int XMarginBTWPieces = 30;
        for (int i = 0; i < ps.length; i++) {
            DrawPiece(ps[i], x, y, scale);
            x += XMarginBTWPieces + PXSize(ps[i] , scale).w;
        }
    }

    //trackers
    public static void DrawTracker(ThreadTracker tracker , int x , int y , float scale ){
        FXGL.spawn("StateSquare",
                new SpawnData(x, y)
                        .put("Tracker",tracker)
                        .put("scale", scale));

    }

    public static void DrawThreadTrackers(ThreadTracker [] trackers ,float scale){
        int WindowWidth  = (int) FXGL.getAppWidth();
        RectSize TSize = PXSize(trackers[0].square ,scale);
        int ThreadBlockMargin = 30;
        int text_section = 0;

        for (int i = 0 , row = 0 ; row < 3 ; row++) {
            for (int col = 0 ; col < 2 ; col++) {
                int x = WindowWidth  - (col+1)*(TSize.w + ThreadBlockMargin);
                int y = row*(TSize.h + ThreadBlockMargin) + text_section;
                try {
                    Renderer.DrawTracker(trackers[i], x, y, scale);
                }catch (Exception e){
                    break;
                }

                i++;
            }
            text_section = TextSectionSize;
        }
    }

    // element size
    public static RectSize PXSize(Piece p ,float scale){
        int ScaledWidth = (int)(BlockWidth * scale);

        int h =  p.description.length    * ScaledWidth + Margin;
        int w =  p.description[0].length * ScaledWidth + Margin;
        return new RectSize(w,h);
    }
    public static RectSize PXSize(Square s , float scale){
        int ScaledWidth = (int)(BlockWidth * scale);

        int h =  s.data.length    * ScaledWidth + Margin;
        int w =  s.data[0].length * ScaledWidth + Margin;
        return new RectSize(w,h);
    }
}
