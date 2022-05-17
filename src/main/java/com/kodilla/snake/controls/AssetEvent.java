package com.kodilla.snake.controls;

import com.kodilla.snake.Game;
import com.kodilla.snake.score.HighScore;
import com.kodilla.snake.gameobject.Food;
import com.kodilla.snake.gameobject.Snake;
import com.kodilla.snake.gui.Asset;
import com.kodilla.snake.gui.GameScene;
import com.kodilla.snake.gui.HighScoreScene;
import com.kodilla.snake.gui.MainMenuScene;
import javafx.animation.Animation;
import javafx.animation.Timeline;
import javafx.stage.Stage;

public class AssetEvent {

    private Stage stage;
    private Asset asset;

    public AssetEvent(Asset asset) {
        this.asset = asset;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void handleOnStartGameButtonAction(GameScene gameScene, Timeline timeline, Game game, Snake snake,
                                              Food food, Handler handler, HighScore highScore) {
        asset.getStartGameButton().setOnAction(event -> {
            if (!timeline.getStatus().equals(Animation.Status.STOPPED)) {
                highScore.saveScoreToList();
            }
            game.initReset(snake, food, handler);
            timeline.play();
            stage.setScene(gameScene.getGameScene());
        });
    }

    public void handleOnResumeGameButtonAction(GameScene gameScene, Timeline timeline, Game game) {
        if (timeline.getStatus().equals(Animation.Status.STOPPED)) {
            asset.getResumeGameButton().setDisable(true);
        }
        asset.getResumeGameButton().setOnAction(event -> {
            game.setGamePaused(false);
            timeline.play();
            stage.setScene(gameScene.getGameScene());
        });
    }

    public void handleOnHighScoreSceneButtonAction(HighScoreScene highScoreScene, HighScore highScore) {
        asset.getHighScoresSceneButton().setOnAction(event -> {
            asset.getHighScoresLabel().setText(highScore.showTopTenScores());
            stage.setScene(highScoreScene.getHighScoreScene());
        });
    }

    public void handleOnReturnToMainMenuButtonAction(MainMenuScene mainMenuScene) {
        asset.getReturnToMainMenuButton().setOnAction(event -> stage.setScene(mainMenuScene.getMainMenuScene()));
    }

    public void handleOnExitButtonAction(HighScore highScore) {
        asset.getExitButton().setOnAction(event -> {
            highScore.closeApplicationEvent();
            System.exit(0);
        });
    }
}