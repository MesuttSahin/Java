package edu.erciyes.hexgame;

import javafx.animation.FillTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;

public class Hexagon
{


    public void animateColorTransition(Polygon polygon,boolean isRed)
    {
        FillTransition ft = new FillTransition(Duration.seconds(2),polygon);
        ft.setAutoReverse(false);
        ft.setCycleCount(1);

        if (polygon.isDisabled())
        {
            return;
        }

        if (isRed)
        {
            ft.setFromValue(Color.WHITE);
            ft.setToValue(Color.RED);
        }

        else
        {
            ft.setFromValue(Color.WHITE);
            ft.setToValue(Color.BLUE);
        }

        polygon.setDisable(true);
        ft.play();

    }

}