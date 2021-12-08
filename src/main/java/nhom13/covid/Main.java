/** Mạnh Thắng **/
package nhom13.covid;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FormKhaiBaoYTe.fxml"));
        primaryStage.setTitle("Khai báo Y Tế");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    public static void main(String[] args)  {
        launch(args);
    }

}