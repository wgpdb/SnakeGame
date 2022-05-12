package com.kodilla.snake.gameobject;

import com.kodilla.snake.Game;
import com.kodilla.snake.controls.Direction;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

import static com.kodilla.snake.gui.GameSceneBackground.*;

public class Snake {

    private Point snakeHead;
    private final List<Point> snake = new LinkedList<>();
    public static final double SNAKE_SPEED = 180;

    public Point getSnakeHead() {
        return snakeHead;
    }

    public List<Point> getSnake() {
        return snake;
    }

    public void initSnake() {
        for (int i = 0 ; i < 4 ; i++) {
            snake.add(new Point(COLUMN / 2, ROW / 2));
        }
        snakeHead = snake.get(0);
    }

    public void drawSnake(GraphicsContext graphicsContext) {
        graphicsContext.setFill(Color.rgb(12, 109, 16));
        for (Point point : snake) {
            graphicsContext.fillRoundRect(point.getX() * BLOCK_SIZE,
                    point.getY() * BLOCK_SIZE,
                    BLOCK_SIZE - 2, BLOCK_SIZE - 2,
                    10, 10);
        }
        for (int i = snake.size() - 1; i >= 1; i--) {
            snake.get(i).x = snake.get(i - 1).x;
            snake.get(i).y = snake.get(i - 1).y;
        }
    }

    public void snakeControls(Direction direction) {
        switch (direction) {
            case UP -> snakeHead.y--;
            case DOWN -> snakeHead.y++;
            case LEFT -> snakeHead.x--;
            case RIGHT -> snakeHead.x++;
        }
    }

    public void growSnake() {
        snake.add(new Point(-1, -1));
    }

    public void wallIsMirror() {
        if (snakeHead.getX() == -1) {
            snakeHead.x = COLUMN -1;
        }
        else if (snakeHead.getX() > COLUMN -1) {
            snakeHead.x = 0;
        }

        if (snakeHead.getY() == -1) {
            snakeHead.y = ROW -1;
        }
        else if (snakeHead.getY() > ROW -1) {
            snakeHead.y = 0;
        }
    }

    public void hitWall(Game game) {
        if (snakeHead.getX() == -1 || snakeHead.getX() > COLUMN -1 ||
                snakeHead.getY() == -1 || snakeHead.getY() > ROW -1) {
            game.setGameOver(true);
        }
    }

    public void hitSnake(Game game) {
        for (int i = 1; i < snake.size(); i++) {
            if (snakeHead.getX() == snake.get(i).getX() && snakeHead.getY() == snake.get(i).getY()) {
                game.setGameOver(true);
            }
        }
    }
}