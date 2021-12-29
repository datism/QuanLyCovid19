package nhom13.covid.View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class NguoiDungController extends CanBoController{
    @FXML
    void themKhaiBaoYTeClicked(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("KhaiBaoYTe/FormKhaiBaoYTe.fxml"));
            super.anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
