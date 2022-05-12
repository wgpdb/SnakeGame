package com.kodilla.snake;

import com.kodilla.snake.controls.Direction;
import com.kodilla.snake.controls.Handler;
import com.kodilla.snake.gameobject.Food;
import com.kodilla.snake.gameobject.Snake;
import com.kodilla.snake.score.HighScore;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class Game {

    private final Timeline timeline;
    private final GraphicsContext graphicsContext;
    private boolean gamePaused;
    private boolean gameOver;
    private final Font gameMessageDisplayFont = new Font("Verdana", 60);

    public Game(Timeline timeline, GraphicsContext graphicsContext) {
        this.timeline = timeline;
        this.graphicsContext = graphicsContext;
    }

    public boolean isGamePaused() {
        return gamePaused;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGamePaused(boolean gamePaused) {
        this.gamePaused = gamePaused;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public void initPauseGame() {
        if (gamePaused) {
            displayGamePaused();
            timeline.pause();
        }
    }

    public void initGameOver(HighScore highScore) {
        if (gameOver) {
            displayGameOver();
            highScore.saveScoreToList();
            timeline.stop();
        }
    }

    public void initReset(Snake snake, Food food, Handler handler) {
        gamePaused = false;
        gameOver = false;
        snake.getSnake().clear();
        food.setApplesConsumed(0);
        handler.setDirection(Direction.LEFT);
        snake.initSnake();
        food.initApple(snake);
    }

    public void displayGamePaused() {
        graphicsContext.setFill(Color.rgb(180, 180, 180));
        graphicsContext.setFont(gameMessageDisplayFont);
        graphicsContext.setTextAlign(TextAlignment.CENTER);
        graphicsContext.fillText("Game Paused", 400, 400);
    }

    public void displayGameOver() {
        graphicsContext.setFill(Color.rgb(180,180,180));
        graphicsContext.setFont(gameMessageDisplayFont);
        graphicsContext.setTextAlign(TextAlignment.CENTER);
        graphicsContext.fillText("Game Over!", 400, 400);
    }
}