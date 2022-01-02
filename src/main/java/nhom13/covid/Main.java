package nhom13.covid;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("View/SoHoKhau/ThemHoKhau.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

//        NhanKhauDao nhanKhauDao = new NhanKhauDao();
//        NhanKhau nhanKhau = nhanKhauDao.getByMaNhanKhau(987400);

//        try {
//            FXMLLoader loader = new  FXMLLoader(getClass().getResource("View/NhanKhau/FormNhanKhau.fxml"));
//            FormNhanKhau formNhanKhau = new FormNhanKhau();
//            loader.setController(formNhanKhau);
//
//            Parent root = loader.load();
//            formNhanKhau.setNhanKhau(nhanKhau);
//
//            Scene scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

}