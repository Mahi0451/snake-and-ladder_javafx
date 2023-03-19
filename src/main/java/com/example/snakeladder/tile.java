package com.example.snakeladder;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
public class tile extends Rectangle {
    //constructor
    public tile(int tileSize) {
        setWidth(tileSize);
        setHeight(tileSize);
        setFill(Color.AQUA);
        setStroke(Color.BLACK);
    }
}