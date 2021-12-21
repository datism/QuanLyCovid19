package nhom13.covid.View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


public class ToTruongController {
    @FXML
    protected AnchorPane anchorPane;

    @FXML
    void themChuyenDen(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("ChuyenDen/ThemChuyenDen.fxml"));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void themChuyenDi(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("ChuyenDi/ThemChuyenDi.fxml"));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void xemNguoiChuyenDenClicked(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("ChuyenDen/XemChuyenDen.fxml"));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void xemNguoiChuyenDiClicked(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("ChuyenDi/XemChuyenDi.fxml"));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}