package com.kodilla.tictactoe;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class TicTacToe extends Application {
    //private Image wallpaper = new Image("clouds1.png");

    private Button[][] gameboard;
    private String player;
    private Label label1;
    private int countX;
    private int countO;


    public TicTacToe() {
        gameboard = new Button[3][3];
        player = "X";
        label1 = new Label("Turn: Player X");
        countX = 0;
        countO = 0;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
     /* BackgroundSize backgroundSize = new BackgroundSize(200, 150, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(wallpaper, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background backgroundImg = new Background(backgroundImage); */

        //GridPane grid = new GridPane();
        //grid.setBackground(backgroundImg);

        GridPane grid = new GridPane();
        BorderPane border = new BorderPane();
        gameButtons(grid);

        border.setCenter(grid);
        border.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        label1.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        label1.setTextFill(Color.WHITE);
        border.setTop(label1);
        label1.setAlignment(Pos.CENTER);
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);

        Scene scene = new Scene(border, 1000, 600);

        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void gameButtons(GridPane grid) {

        for(int c = 0; c < 3; c++) {
            for(int r = 0; r < 3; r++) {
                Button button = new Button("");
                button.setFont(Font.font("Arial", FontWeight.BOLD, 60));
                grid.add(button, c, r);
                gameboard[c][r] = button;

                button.setOnAction( e -> {
                    if (button.getText().equals("")) {
                        button.setText(player);
                        if (player.equals("X")) {
                            player = "O";
                            label1.setText("Turn: Player O");
                            countX++;
                            if ((countX % 3) == 0) {
                                checkWinner();
                            }
                        }
                        else {
                            player = "X";
                            label1.setText("Turn: Player X");
                            countO++;
                            if ((countO % 3) == 0) {
                                checkWinner();
                            }
                        }
                        if ((countX + countO) == 9) {
                            gameOver();
                        }
                    }
                });
            }
        }
    }

    public void gameOver() {
        label1.setText("GAME OVER!");
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                gameboard[r][c].setDisable(true);
            }
        }
    }

    public void checkRows() {
        for (int r = 0; r < 3; r++) {
            if (gameboard[r][0].getText().equals(gameboard[r][1].getText()) &&
                    (gameboard[r][0].getText().equals(gameboard[r][2].getText()))) {
                gameOver();
            }
        }
    }

    public void checkCols() {
        for (int c = 0; c < 3; c++) {
            if (gameboard[0][c].getText().equals(gameboard[1][c].getText()) &&
                    (gameboard[0][c].getText().equals(gameboard[2][c].getText()))) {
                gameOver();
            }
        }
    }

    public void checkDiagonalLeft() {
            if (gameboard[0][0].getText().equals(gameboard[1][1].getText()) &&
                    (gameboard[0][0].getText().equals(gameboard[2][2].getText()))) {
                gameOver();
            }
    }

    public void checkDiagonaRight() {
        if (gameboard[0][2].getText().equals(gameboard[1][1].getText()) &&
                (gameboard[0][2].getText().equals(gameboard[2][0].getText()))) {
            gameOver();
        }
    }

    public void checkWinner() {
        checkRows();
        checkCols();
        checkDiagonalLeft();
        checkDiagonaRight();
    }
}