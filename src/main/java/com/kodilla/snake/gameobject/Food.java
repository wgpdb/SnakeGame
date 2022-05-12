package com.kodilla.snake.gameobject;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.awt.*;
import java.util.Random;

import static com.kodilla.snake.gui.GameSceneBackground.*;

public class Food {

    private Point apple;
    private final Image appleImage = new Image("file:src/main/resources/snake/apple.png");
    private int applesConsumed = 0;

    public Point getApple() {
        return apple;
    }

    public Image getAppleImage() {
        return appleImage;
    }

    public int getApplesConsumed() {
        return applesConsumed;
    }

    public void setApplesConsumed(int applesConsumed) {
        this.applesConsumed = applesConsumed;
    }

    public void drawApple(GraphicsContext graphicsContext) {
        graphicsContext.drawImage(getAppleImage(), getApple().getX() * BLOCK_SIZE,
                getApple().getY() * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
    }

    public void initApple(Snake snake) {
        Random random = new Random();
        start:
        while (true) {
            apple = new Point(random.nextInt(ROW), random.nextInt(COLUMN));

            for (Point snakeBody : snake.getSnake()) {
                if (snakeBody.getX() == getApple().getX() && snakeBody.getY() == getApple().getY()) {
                    continue start;
                }
            }
            break;
        }
    }

    public void eatApple(double snakeHeadX, double snakeHeadY, Snake snake) {
        if (snakeHeadX == getApple().getX() && snakeHeadY == getApple().getY()) {
            snake.growSnake();
            applesConsumed++;
            initApple(snake);
        }
    }
}