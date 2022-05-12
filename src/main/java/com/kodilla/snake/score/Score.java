package com.kodilla.snake.score;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Score {

    private int score;
    private final Font scoreFont = new Font("Verdana", 20);

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void displayScore(GraphicsContext graphicsContext) {
        graphicsContext.setFill(Color.rgb(180,180,180));
        graphicsContext.setFont(scoreFont);
        graphicsContext.fillText("score: " + getScore(), 680, 35);
    }
}