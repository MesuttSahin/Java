module com.example.hareketlianalogsaat {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.hareketlianalogsaat to javafx.fxml;
    exports com.example.hareketlianalogsaat;
}