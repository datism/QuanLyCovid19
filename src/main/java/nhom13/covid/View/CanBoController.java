package nhom13.covid.Controller;

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
    void thongKeTestCovid(ActionEvent event) {

    }

    @FXML
    void xemTestCovid(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("XemTestCovidView.fxml"));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

}
