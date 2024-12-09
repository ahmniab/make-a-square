package com.project.gui;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.project.app.Helper;
import com.project.data.Square;
import com.project.data.ThreadTracker;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class Factory implements EntityFactory {
    @Spawns("block")
    public Entity newBlock(SpawnData data) {
        Color color = data.get("color");
        int width = data.get("width");
        Rectangle rect = new Rectangle(width,width);
        rect.setFill(color);

        return FXGL.entityBuilder(data)
                .view(rect)
                .build();

    }

    @Spawns("StateSquare")
    public Entity newSquare(SpawnData data) {
        float scale = data.get("scale");
        ThreadTracker tracker = data.get("Tracker");
        Square square = tracker.square;
        // Dimensions of a single small square
        int smallSquareSize = (int)(Renderer.BlockWidth * scale);
        int margin = Renderer.Margin;



        int totalSize = square.data.length * smallSquareSize + (square.data.length - 1) * margin;

        List<ArrayList<Rectangle>> rectangles = new ArrayList<ArrayList<Rectangle>>();

        // Create a root entity
        var root = new Entity();
        root.setPosition(data.getX(), data.getY());

        for (int row = 0; row < square.data.length; row++) {
            rectangles.add(new ArrayList<>());
            for (int col = 0; col < square.data[0].length; col++) {

                double x = col * (smallSquareSize + margin) + data.getX();
                double y = row * (smallSquareSize + margin) + data.getY();


                Rectangle smallSquare = new Rectangle(smallSquareSize, smallSquareSize);
                smallSquare.setFill(Renderer.GetColor(square.data[row][col]));
                smallSquare.setTranslateX(x);
                smallSquare.setTranslateY(y);

                // Add to the list for later color changes
                rectangles.get(row).add(smallSquare);

                // Add the square to the game scene
                FXGL.getGameScene().addUINode(smallSquare);
            }
        }

        // status label
        Text StatusLabel = new Text(Helper.StateString(tracker.threadState));
        StatusLabel.setTranslateX(data.getX());
        StatusLabel.setTranslateY(data.getY() + 4 * (smallSquareSize + margin) + 30); // Position below the square
        StatusLabel.setFill(Renderer.StateColor(tracker.threadState)); // Text color
        StatusLabel.setFont(Font.font("Arial", FontWeight.BOLD,20));
        FXGL.getGameScene().addUINode(StatusLabel);


        // thread name label
        Text NameLabel = new Text(tracker.ThreadName);
        NameLabel.setTranslateX(data.getX());
        NameLabel.setTranslateY(data.getY() + 4 * (smallSquareSize + margin) + 60); // Position below the square
        NameLabel.setFill(Renderer.StateColor(tracker.threadState)); // Text color
        NameLabel.setFont(Font.font("Arial", FontWeight.BOLD,20));
        tracker.NameLabel = NameLabel;
        FXGL.getGameScene().addUINode(NameLabel);


        root.addComponent(new UpdateComponent(()->{
                for (int row = 0; row < 4; row++) {
                    for (int col = 0; col < 4; col++)
                        rectangles.get(row).get(col).setFill(Renderer.GetColor(square.data[row][col]));

                }
                StatusLabel.setFill(Renderer.StateColor(tracker.threadState));
                StatusLabel.setText(Helper.StateString(tracker.threadState));
        }));

        return root;
    }


}
