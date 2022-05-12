package com.kodilla.snake.gui;

import com.kodilla.snake.controls.Handler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import static com.kodilla.snake.gui.GameSceneBackground.BG_HEIGHT;
import static com.kodilla.snake.gui.GameSceneBackground.BG_WIDTH;

public class GameScene {

    private final Canvas canvas = new Canvas(BG_WIDTH, BG_HEIGHT);
    private Handler handler;

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public GraphicsContext getGraphicsContext() {
        return canvas.getGraphicsContext2D();
    }

    public Scene getGameScene() {
        Group root = new Group();
        root.getChildren().add(canvas);
        Scene gameScene = new Scene(root);
        gameScene.setOnKeyPressed(handler);

        return gameScene;
    }
}