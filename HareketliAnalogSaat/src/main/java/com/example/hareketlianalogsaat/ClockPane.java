package com.example.hareketlianalogsaat;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import java.time.LocalDateTime;


public class ClockPane extends Pane
{
    private int hour;
    private int min;
    private int sec;

    public ClockPane()
    {
        setCurrentTime();
    }

    void setCurrentTime()
    {
        LocalDateTime now=LocalDateTime.now();
        hour = now.getHour();
        min = now.getMinute();
        sec = now.getSecond();
        paintClock();
    }

    public void paintClock()
    {
        double centerX = getWidth() * 0.5;
        double centerY = getHeight() * 0.5;
        double radius = Math.min(getHeight(),getWidth() * 0.8 * 0.5);

        Circle circle=new Circle(centerX,centerY,radius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        double secLength = radius * 0.9;
        double secX = centerX + secLength * Math.sin(sec * 2.0 * Math.PI / 60.0);
        double secY = centerY - secLength * Math.cos(sec * 2.0 * Math.PI / 60.0);
        Line secLine = new Line(centerX,centerY,secX,secY);
        secLine.setStroke(Color.YELLOW);

        double minLength = radius * 0.75;
        double minX = centerX + minLength * Math.sin(min * 2.0 * Math.PI / 60.0);
        double minY = centerY - minLength * Math.cos(min * 2.0 * Math.PI / 60.0);
        Line minLine = new Line(centerX,centerY,minX,minY);
        minLine.setStroke(Color.BLUE);

        double hourLength = radius * 0.6;
        double hourX = centerX + hourLength * Math.sin((hour % 12 + min / 60.0) * 2 * Math.PI / 12.0);
        double hourY = centerY - hourLength * Math.cos((hour % 12 + min / 60.0) * 2 * Math.PI / 12.0);
        Line hourLine = new Line(centerX,centerY,hourX,hourY);
        hourLine.setStroke(Color.RED);

        Text text = new Text("12");
        Text text1 = new Text("3");
        Text text2 = new Text("9");
        Text text3 = new Text("6");
        text.setX(140);
        text.setY(50);
        text1.setX(250);
        text1.setY(150);
        text3.setY(260);
        text3.setX(150);
        text2.setX(40);
        text2.setY(150);
        getChildren().clear();
        getChildren().addAll(circle,secLine,minLine,hourLine,text,text1,text2,text3);

    }

    @Override
    protected void setWidth(double v) {
        super.setWidth(v);
        setCurrentTime();
    }

    @Override
    protected void setHeight(double v) {
        super.setHeight(v);
        setCurrentTime();
    }
}
