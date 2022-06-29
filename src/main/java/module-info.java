module com.example.projek {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;


    opens com.example.projek to javafx.fxml, javafx.base;
    exports com.example.projek;

}