package nhom13.covid;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("KhaiBaoYte.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("KhaiBaoYte.css").toExternalForm());
        primaryStage.setTitle("Khai báo Y Tế");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args)  {
        launch(args);
    }

}