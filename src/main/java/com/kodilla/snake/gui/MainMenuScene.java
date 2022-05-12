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

public class MainMenuScene {

    private final Asset asset;

    public MainMenuScene(Asset asset) {
        this.asset = asset;
    }

    public Scene getMainMenuScene() {
        VBox menuSceneLayout = new VBox();
        menuSceneLayout.setSpacing(15);
        menuSceneLayout.setBackground(new Background(new BackgroundFill(Color.rgb(50,50,50),
                CornerRadii.EMPTY, Insets.EMPTY)));
        menuSceneLayout.setAlignment(Pos.CENTER);

        menuSceneLayout.getChildren().addAll(asset.getMenuLabel(), asset.getHighScoresSceneButton(),
                asset.getResumeGameButton(), asset.getStartGameButton(), asset.getWallIsMirrorCheckBox(),
                asset.getHitSnakeDoesNotKillCheckBox(), asset.getExitButton());

        return new Scene(menuSceneLayout, BG_WIDTH, BG_HEIGHT);
    }
}