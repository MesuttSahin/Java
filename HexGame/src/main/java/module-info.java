module sample.introluhexgame {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;
    requires java.desktop;
    requires javafx.media;
    requires javafx.mediaEmpty;

    opens edu.erciyes.hexgame to javafx.fxml;
    exports edu.erciyes.hexgame;
}