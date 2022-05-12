package com.kodilla.snake.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import static com.kodilla.snake.gui.GameSceneBackground.BG_HEIGHT;
import static com.kodilla.snake.gui.GameSceneBackground.BG_WIDTH;

public class HighScoreScene {

    private final Asset asset;

    public HighScoreScene(Asset asset) {
        this.asset = asset;
    }

    public Scene getHighScoreScene() {
        VBox highScoreSceneLayout = new VBox();
        highScoreSceneLayout.setSpacing(15);
        highScoreSceneLayout.setBackground(new Background(new BackgroundFill(Color.rgb(50,50,50),
                CornerRadii.EMPTY, Insets.EMPTY)));
        highScoreSceneLayout.setAlignment(Pos.CENTER);

        highScoreSceneLayout.getChildren().addAll(asset.getHighScoreSceneLabel(), asset.getHighScoresLabel(),
                asset.getReturnToMainMenuButton());

        return new Scene(highScoreSceneLayout, BG_WIDTH, BG_HEIGHT);
    }
}