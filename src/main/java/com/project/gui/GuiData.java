package com.project.gui;

import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class GuiData {
    public Text StatusLabel;
    public List<ArrayList<Rectangle>> rectangles;
    public GuiData(Text StatusLabel, List<ArrayList<Rectangle>> rectangles) {
        this.StatusLabel = StatusLabel;
        this.rectangles = rectangles;
    }
}
