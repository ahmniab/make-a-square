package com.project.gui;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

import java.awt.*;

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
}
