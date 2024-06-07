package edu.erciyes.hexgame;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import java.io.File;
import java.nio.file.Paths;

public class HexGameApp extends Application {
    private static final double SIDE_LENGTH_SMALL = 45.0;
    private static final double SIDE_LENGTH_MEDIUM = 35.0;
    private static final double SIDE_LENGTH_LARGE = 20.0;
    private static final int SIZE_GAME_SMALL = 5;
    private static final int SIZE_GAME_MEDIUM = 11;
    private static final int SIZE_GAME_LARGE = 17;
    private HexBoard hexBoard;
    Button btnStart = new Button("Start Game");
    private Label nextGamerLabel;
    private Label gameOverLabel;
    MediaPlayer mediaPlayer;
    BorderPane pane = new BorderPane();

    @Override
    public void start(Stage stage) throws Exception {
        Label nextGamer = new Label("Next Gamer");
        nextGamerLabel = new Label("Next Gamer");

        hexBoard = new HexBoard(nextGamer, this);

        nextGamer.setPadding(new Insets(7, 105, 5, 100));
        nextGamer.setAlignment(Pos.CENTER);
        nextGamer.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        nextGamer.setTextFill(Color.WHITE);
        nextGamer.setMaxWidth(Double.MAX_VALUE);
        nextGamer.setTextFill(Color.BLACK);
        BorderPane.setAlignment(nextGamer, Pos.BOTTOM_RIGHT);

        gameOverLabel = new Label(" GAME \n OVER");
        gameOverLabel.setTextFill(Color.WHITE);
        gameOverLabel.setFont(Font.font("Monospaced", 20));
        gameOverLabel.setAlignment(Pos.CENTER);
        gameOverLabel.setStyle("-fx-background-color: #2E2E2E;");
        gameOverLabel.setVisible(false);

        ToggleGroup toggleGroup = new ToggleGroup();

        RadioButton radioButton1 = createRadioButton("5 x 5", toggleGroup);
        RadioButton radioButton2 = createRadioButton("11 x 11", toggleGroup);
        RadioButton radioButton3 = createRadioButton("17 x 17", toggleGroup);

        btnStart.setStyle("-fx-background-color: blue; -fx-text-fill: white; -fx-font-weight: bold;");

        HBox controlBox = new HBox(10, radioButton1, radioButton2, radioButton3, btnStart, nextGamer, gameOverLabel);
        controlBox.setPadding(new Insets(10));
        controlBox.setAlignment(Pos.CENTER_LEFT);

        radioButton1.setOnAction(actionEvent -> {
            resetLabels();
            stage.setWidth(800.0);
            stage.setHeight(550.0);
            hexBoard.isFirstPlayer = true;
            hexBoard.startButtonControl = false;
            hexBoard.isWinFirstPlayer = false;
            hexBoard.isWinSecondPlayer = false;
            hexBoard.processHexagon(SIZE_GAME_SMALL, SIDE_LENGTH_SMALL);
        });
        radioButton2.setOnAction(actionEvent -> {
            resetLabels();
            stage.setWidth(1100.0);
            stage.setHeight(800.0);
            hexBoard.isFirstPlayer = true;
            hexBoard.startButtonControl = false;
            hexBoard.isWinFirstPlayer = false;
            hexBoard.isWinSecondPlayer = false;
            hexBoard.processHexagon(SIZE_GAME_MEDIUM, SIDE_LENGTH_MEDIUM);
        });
        radioButton3.setOnAction(actionEvent -> {
            resetLabels();
            hexBoard.isFirstPlayer = true;
            hexBoard.startButtonControl = false;
            hexBoard.isWinFirstPlayer = false;
            hexBoard.isWinSecondPlayer = false;
            hexBoard.processHexagon(SIZE_GAME_LARGE, SIDE_LENGTH_LARGE);
        });

        btnStart.setOnMouseClicked(mouseEvent -> {
            hexBoard.startButtonControl = true;
            hexBoard.getNextGamerLabel().setText("Red's Turn");
        });

        Button howToPlayButton = new Button("HOW TO PLAY");
        howToPlayButton.setStyle("-fx-background-color: green; -fx-text-fill: white; -fx-font-weight: bold;");

        howToPlayButton.setOnAction(actionEvent -> {
            String videoFile = "project_videos/how-to-play.mp4";

            Media media = new Media(new File(videoFile).toURI().toString());

            MediaPlayer mediaPlayer = new MediaPlayer(media);

            MediaView mediaView = new MediaView(mediaPlayer);

            Stage videoStage = new Stage();
            BorderPane root = new BorderPane(mediaView);
            Scene scene = new Scene(root, 800, 600);

            mediaView.setPreserveRatio(true);
            mediaView.fitWidthProperty().bind(root.widthProperty());
            mediaView.fitHeightProperty().bind(root.heightProperty());

            videoStage.setScene(scene);
            videoStage.setTitle("How to Play Hex Game");
            videoStage.show();

            mediaPlayer.setAutoPlay(true);
            mediaPlayer.play();
        });

        VBox howToPlayBox = new VBox(howToPlayButton);
        howToPlayBox.setAlignment(Pos.TOP_RIGHT);
        howToPlayBox.setPadding(new Insets(10));

        pane.setBottom(controlBox);
        pane.setCenter(hexBoard.getPane());
        pane.setTop(howToPlayBox);

        Scene scene = new Scene(pane, 1000, 700);
        animateEntry(stage, scene);
        music();
        stage.setTitle("Hex Game");
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("");
        stage.show();
    }

    public void showGameOverLabel() {
        gameOverLabel.setVisible(true);
    }

    private RadioButton createRadioButton(String text, ToggleGroup toggleGroup) {
        RadioButton radioButton = new RadioButton(text);
        radioButton.setToggleGroup(toggleGroup);
        radioButton.setStyle("-fx-font-size: 15px; -fx-pref-width: 90;");
        return radioButton;
    }



    public void music() {
        String s = "project_musics/videoplayback.m4a";
        Media h = new Media(Paths.get(s).toUri().toString());
        mediaPlayer = new MediaPlayer(h);
        mediaPlayer.play();

    }


    private void animateEntry(Stage stage, Scene scene) {
        BorderPane entryPane = new BorderPane();
        entryPane.setStyle("-fx-background-color: black;");

        Scene entryScene = new Scene(entryPane);
        stage.setScene(entryScene);
        stage.setFullScreen(true);

        BorderPane.setAlignment(entryPane, Pos.CENTER);
        Label titleLabel = new Label("HEX GAME");
        titleLabel.setStyle("-fx-font-size: 110px; -fx-text-fill: white;");
        entryPane.setCenter(titleLabel);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(6.3), titleLabel);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);

        TranslateTransition translateTransition = new TranslateTransition(Duration.ZERO, titleLabel);
        translateTransition.setToX(0);
        translateTransition.setToY(0);

        ParallelTransition parallelTransition = new ParallelTransition(fadeTransition, translateTransition);
        parallelTransition.setOnFinished(event -> {
            stage.setScene(scene);
            stage.setFullScreen(false);
        });

        parallelTransition.play();
    }


    private void resetLabels() {
        gameOverLabel.setVisible(false);
        nextGamerLabel.setText("Next Gamer");
    }

}