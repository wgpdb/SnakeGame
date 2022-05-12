package com.kodilla.snake.gui;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Asset {

    private final Label menuLabel = new Label();
    private final Label highScoreSceneLabel = new Label();
    private Label highScoresLabel = new Label();

    private final Button resumeGameButton = new Button();
    private final Button startGameButton = new Button();
    private final Button highScoresSceneButton = new Button();
    private final Button returnToMainMenuButton = new Button();
    private final Button exitButton = new Button();

    private final CheckBox wallIsMirrorCheckBox = new CheckBox();
    private final CheckBox hitSnakeDoesNotKillCheckBox = new CheckBox();

    public Label getMenuLabel() {
        menuLabel.setText("Snake - Game Menu");
        menuLabel.setTextFill(Color.rgb(180, 180, 180));
        menuLabel.setFont(new Font(24));
        return menuLabel;
    }

    public Label getHighScoreSceneLabel() {
        highScoreSceneLabel.setText("High Scores TOP 10");
        highScoreSceneLabel.setTextFill(Color.rgb(180, 180, 180));
        highScoreSceneLabel.setFont(new Font(24));
        return highScoreSceneLabel;
    }

    public Label getHighScoresLabel() {
        highScoresLabel.setTextFill(Color.rgb(180, 180, 180));
        highScoresLabel.setFont(new Font(16));
        return highScoresLabel;
    }

    public Button getResumeGameButton() {
        resumeGameButton.setText("Resume Game");
        return resumeGameButton;
    }

    public Button getStartGameButton() {
        startGameButton.setText("Start New Game");
        return startGameButton;
    }

    public Button getHighScoresSceneButton() {
        highScoresSceneButton.setText("High Scores");
        return highScoresSceneButton;
    }

    public Button getReturnToMainMenuButton() {
        returnToMainMenuButton.setText("Return to Main Menu");
        return returnToMainMenuButton;
    }

    public Button getExitButton() {
        exitButton.setText("Exit");
        return exitButton;
    }

    public CheckBox getWallIsMirrorCheckBox() {
        wallIsMirrorCheckBox.setText("Turn walls into mirrors");
        wallIsMirrorCheckBox.setTextFill(Color.rgb(180,180,180));
        return wallIsMirrorCheckBox;
    }

    public CheckBox getHitSnakeDoesNotKillCheckBox() {
        hitSnakeDoesNotKillCheckBox.setText("Immortality mode");
        hitSnakeDoesNotKillCheckBox.setTextFill(Color.rgb(180,180,180));
        return hitSnakeDoesNotKillCheckBox;
    }
}