package edu.erciyes.hexgame;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;

import java.util.HashSet;
import java.util.Set;

public class HexBoard {
    private double START_X = 75.0;
    private double START_Y = 60.0;
    BorderPane pane = new BorderPane();
    Hexagon hex = new Hexagon();
    private String[][] matrix;
    public boolean isFirstPlayer = true;
    private int numOfMoves = 0;
    GameWinConditions gameWin = new GameWinConditions();
    private Label nextGamerLabel;
    Timeline timeline;
    boolean isWinFirstPlayer = false;
    boolean isWinSecondPlayer = false;
    boolean startButtonControl = false;
    private HexGameApp hexGameApp;

    public HexBoard(Label nextGamerLabel, HexGameApp hexGameApp) {
        this.hexGameApp = hexGameApp;
        this.nextGamerLabel = nextGamerLabel;
    }

    public BorderPane getPane() {
        return pane;
    }

    public Label getNextGamerLabel() {
        return nextGamerLabel;
    }

    public void processHexagon(int sizeGame, double sideLength) {
        matrix = new String[sizeGame][sizeGame];
        pane.getChildren().removeIf(child -> child instanceof Polygon);
        START_X = 75.0;
        START_Y = 60.0;
        for (int i = 0; i < sizeGame; i++) {
            for (int j = 0; j < sizeGame; j++) {
                Polygon hexagon = createHexagon(START_X + j * sideLength * 1.80, START_Y, sideLength);
                hexagon.setRotate(90);
                addMouseEvents(hexagon, i, j, sizeGame);
                pane.getChildren().add(hexagon);
            }
            START_Y = START_Y + sideLength + (sideLength / 2) + 2;
            START_X = START_X + (sideLength / 2) * 1.80;
        }
    }

    public Polygon createHexagon(double x, double y, double sideLength) {
        Polygon polygon = new Polygon();
        for (int i = 0; i < 6; i++) {
            double angleRad = Math.toRadians(60 * i);
            double pointX = x + (sideLength * Math.cos(angleRad));
            double pointY = y + (sideLength * Math.sin(angleRad));
            polygon.getPoints().addAll(pointX, pointY);
        }
        polygon.setFill(Color.WHITE);
        polygon.setStroke(Color.BLACK);
        return polygon;
    }



    private void addMouseEvents(Polygon polygon, int row, int col, int sizeGame) {
        Set<String> visited = new HashSet<>();
        polygon.setOnMouseClicked(mouseEvent -> {
            numOfMoves++;


            if (startButtonControl) {
                if (numOfMoves % 2 == 0) {
                    nextGamerLabel.setText("Red's turn");
                } else {
                    nextGamerLabel.setText("Blue's turn");
                }
                hex.animateColorTransition(polygon, isFirstPlayer);

                matrix[row][col] = isFirstPlayer ? "RED" : "BLUE";
                if (isFirstPlayer) {
                    isWinFirstPlayer = gameWin.checkWinFromBottom(row, col, "RED", matrix, visited);
                    isWinFirstPlayer |= gameWin.checkWin(row, col, "RED", matrix, visited);
                } else {
                    isWinSecondPlayer = gameWin.checkWinFromRight(row, col, "BLUE", matrix, visited);
                    isWinSecondPlayer |= gameWin.checkWin(row, col, "BLUE", matrix, visited);
                }

                System.out.println("Kırmızı oyunucu: " + isWinFirstPlayer + "\nMavi Oyuncu: " + isWinSecondPlayer);

                isFirstPlayer = !isFirstPlayer;
            }

            if (isWinFirstPlayer) {
                nextGamerLabel.setText("GAME OVER: Red Wins \n              Turns: " + numOfMoves);
                hexGameApp.showGameOverLabel();
            } else if (isWinSecondPlayer) {
                nextGamerLabel.setText("GAME OVER: Blue Wins \n              Turns: " + numOfMoves);
                hexGameApp.showGameOverLabel();
            }
        });

        polygon.setOnMouseEntered(event -> {
             timeline = new Timeline(
                    new KeyFrame(Duration.seconds(0.5),
                            new KeyValue(polygon.scaleXProperty(), 1.2),
                            new KeyValue(polygon.scaleYProperty(), 1.2)
                    )
            );
            timeline.play();
            if (isWinFirstPlayer) {
                polygon.setDisable(true);
                timeline.stop();
            }
            if (isWinSecondPlayer) {
                polygon.setDisable(true);
                timeline.stop();

            }
        });

        polygon.setOnMouseExited(event -> {
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.seconds(1),
                            new KeyValue(polygon.scaleXProperty(), 1),
                            new KeyValue(polygon.scaleYProperty(), 1)
                    )
            );
            timeline.play();
        });
    }
}