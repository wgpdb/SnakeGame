package com.kodilla.snake.controls;

import com.kodilla.snake.Game;
import com.kodilla.snake.gui.Asset;
import com.kodilla.snake.gui.MainMenuScene;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Handler implements EventHandler<KeyEvent> {

    private Direction direction = Direction.LEFT;
    private Stage stage;
    private final Timeline timeline;
    private final Game game;
    private final Asset asset;
    private final MainMenuScene mainMenuScene;

    public Handler(Timeline timeline, Game game, Asset asset, MainMenuScene mainMenuScene) {
        this.timeline = timeline;
        this.game = game;
        this.asset = asset;
        this.mainMenuScene = mainMenuScene;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public void handle(KeyEvent event) {
        KeyCode code = event.getCode();
        if (code == KeyCode.RIGHT || code == KeyCode.D) {
            if (direction != Direction.LEFT) {
                direction = Direction.RIGHT;
            }
        } else if (code == KeyCode.LEFT || code == KeyCode.A) {
            if (direction != Direction.RIGHT) {
                direction = Direction.LEFT;
            }
        } else if (code == KeyCode.UP || code == KeyCode.W) {
            if (direction != Direction.DOWN) {
                direction = Direction.UP;
            }
        } else if (code == KeyCode.DOWN || code == KeyCode.S) {
            if (direction != Direction.UP) {
                direction = Direction.DOWN;
            }
        } else if (code == KeyCode.SPACE) {
            if (game.isGamePaused()) {
                timeline.play();
            } else {
                game.initPauseGame();
            }
            game.setGamePaused(!game.isGamePaused());
        } else if (code == KeyCode.ESCAPE) {
            if (!game.isGameOver()) {
                timeline.pause();
                asset.getResumeGameButton().setDisable(false);
            } else {
                asset.getResumeGameButton().setDisable(true);
            }
            stage.setScene(mainMenuScene.getMainMenuScene());
        }
    }
}