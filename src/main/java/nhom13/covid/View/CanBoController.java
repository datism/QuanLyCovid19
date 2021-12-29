package nhom13.covid.View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


public class CanBoController {
    @FXML
    protected AnchorPane anchorPane;

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

    @FXML
    void thongKeKhaiBaoYTe(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("KhaiBaoYTe/ThongKeKhaiBaoYTe.fxml"));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void xemKhaiBaoYTe(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("KhaiBaoYTe/XemKhaiBaoYTe.fxml"));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void thongKeCachLyDiaPhuongClicked(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("CachLy/ThongKeCachLy.fxml"));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void xemCachLyDiaPhuongClicked(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("CachLy/XemCachLy.fxml"));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
