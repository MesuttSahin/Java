package com.example.analogsaat;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Clock extends Application
{
    @Override
    public void start(Stage stage) throws Exception {
        ClockPane clockPane=new ClockPane();

        BorderPane root = new BorderPane();
        root.setCenter(clockPane);
        stage.setScene(new Scene(root,300,300));
        stage.setTitle("Analog Saat");
        stage.show();
    }
}
