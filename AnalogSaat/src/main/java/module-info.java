module com.example.analogsaat {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.analogsaat to javafx.fxml;
    exports com.example.analogsaat;
}