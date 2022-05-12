package com.kodilla.snake.gui;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public final class GameSceneBackground {

    public static final int BG_HEIGHT = 800;
    public static final int BG_WIDTH = 800;
    public static final int ROW = 32;
    public static final int COLUMN = 32;
    public static final int BLOCK_SIZE = BG_HEIGHT / ROW;

    public void drawBackground(GraphicsContext graphicsContext) {

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                if ((i + j) % 2 == 0) {
                    graphicsContext.setFill(Color.rgb(50,50,50));
                } else {
                    graphicsContext.setFill(Color.rgb(50,50,50));
                }
                graphicsContext.fillRect(i * BLOCK_SIZE, j * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
            }
        }
    }
}