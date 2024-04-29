package com.example.hareketlianalogsaat;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ClockAnimation extends Application
{
    @Override
    public void start(Stage stage) throws Exception {
        ClockPane clockPane = new ClockPane();
        EventHandler<ActionEvent> handler = actionEvent -> clockPane.setCurrentTime();

        Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000), handler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();



        stage.setScene(new Scene(clockPane,300,300));
        stage.setTitle("Clock Animation");
        stage.show();
    }
}
