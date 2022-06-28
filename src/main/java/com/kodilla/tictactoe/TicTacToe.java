package com.kodilla.tictactoe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TicTacToe extends Application {

    private Image wallpaper = new Image("file:home/jacolec/Obrazy/java_backgrounds/clouds.jpg");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(150, 150, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(wallpaper, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background backgroundImg = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setBackground(backgroundImg);

        Scene scene = new Scene(grid, 1200, 600, Color.BLACK);

        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
