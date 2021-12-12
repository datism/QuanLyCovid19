package nhom13.covid.View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CanBoController implements Initializable {
    @FXML
    private AnchorPane anchorPane;

    @FXML
    void themTestCovid(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("TestCovid/ThemTestCovid.fxml"));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void thongKeTestCovid(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("TestCovid/ThongKeTestCovid.fxml"));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void xemTestCovid(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("TestCovid/XemTestCovid.fxml"));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void thongKeCovidQuocGiaCLicked(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("BenhNhanQuocGia/ThongKeBenhNhanquocGia.fxml"));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void xemCovidQuocGiaClicked(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("BenhNhanQuocGia/XemBenhNhanQuocGia.fxml"));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

}
