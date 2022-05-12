package com.kodilla.snake;

import com.kodilla.snake.controls.AssetEvent;
import com.kodilla.snake.controls.Handler;
import com.kodilla.snake.gameobject.Food;
import com.kodilla.snake.gameobject.Snake;
import com.kodilla.snake.gui.*;
import com.kodilla.snake.score.HighScore;
import com.kodilla.snake.score.Score;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Duration;

import static com.kodilla.snake.gameobject.Snake.SNAKE_SPEED;

public class SnakeGameRunner {

    private final Image icon = new Image("file:src/main/resources/snake/snake_icon.jpg");

    Timeline timeline = new Timeline();
    GameSceneBackground gameSceneBackground = new GameSceneBackground();
    Snake snake = new Snake();
    Food food = new Food();
    Score score = new Score();
    HighScore highScore = new HighScore(score);
    Asset asset = new Asset();
    AssetEvent assetEvent = new AssetEvent(asset);
    MainMenuScene mainMenuScene = new MainMenuScene(asset);
    HighScoreScene highScoreScene = new HighScoreScene(asset);
    GameScene gameScene = new GameScene();
    Game game = new Game(timeline, gameScene.getGraphicsContext());
    Handler handler = new Handler(timeline, game, asset, mainMenuScene);

    private KeyFrame keyFrame() {
        return new KeyFrame(Duration.millis(SNAKE_SPEED), event -> {
            gameSceneBackground.drawBackground(gameScene.getGraphicsContext());
            snake.drawSnake(gameScene.getGraphicsContext());
            food.drawApple(gameScene.getGraphicsContext());
            snake.snakeControls(handler.getDirection());
            food.eatApple(snake.getSnakeHead().getX(), snake.getSnakeHead().getY(), snake);
            score.setScore(food.getApplesConsumed());
            score.displayScore(gameScene.getGraphicsContext());
            if (!asset.getHitSnakeDoesNotKillCheckBox().isSelected()) {
                snake.hitSnake(game);
            }
            if (asset.getWallIsMirrorCheckBox().isSelected()) {
                snake.wallIsMirror();
            } else {
                snake.hitWall(game);
            }
            game.initPauseGame();
            game.initGameOver(highScore);
        });
    }

    private void timeline() {
        timeline.getKeyFrames().add(keyFrame());
        timeline.setCycleCount(Animation.INDEFINITE);
    }

    public void runGame(Stage stage) {
        stage.setTitle("Snake");
        stage.getIcons().add(icon);
        stage.setResizable(false);
        stage.centerOnScreen();

        handler.setStage(stage);
        assetEvent.setStage(stage);

        highScore.loadScoresFromFile();

        mainMenuScene.getMainMenuScene();

        highScoreScene.getHighScoreScene();

        gameScene.getGameScene();
        gameScene.setHandler(handler);

        timeline();

        assetEvent.getHighScoreSceneButtonAction(highScoreScene, highScore);
        assetEvent.getStartGameButtonAction(gameScene, timeline, game, snake, food, handler, highScore);
        assetEvent.getResumeGameButtonAction(gameScene, timeline, game);
        assetEvent.getReturnToMainMenuButtonAction(mainMenuScene);
        assetEvent.getExitButtonAction(highScore);

        stage.setOnCloseRequest(e -> highScore.closeApplicationEvent());

        stage.setScene(mainMenuScene.getMainMenuScene());
        stage.show();
    }
}