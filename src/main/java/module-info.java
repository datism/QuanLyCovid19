module nhom13.covid {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens nhom13.covid to javafx.fxml;
    exports nhom13.covid;
}