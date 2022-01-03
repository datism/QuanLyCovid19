package nhom13.covid.View.NhanKhau;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nhom13.covid.Dao.NhanKhauDao;
import nhom13.covid.Model.NhanKhau;
import org.junit.jupiter.api.Test;

import java.io.IOException;
class FormNhanKhauTest {

    FormNhanKhau formNhanKhau;

    @Test
    void sua() {
        NhanKhauDao nhanKhauDao = new NhanKhauDao();
        NhanKhau nhanKhau = nhanKhauDao.getByMaNhanKhau(987400);

        try {
            FXMLLoader loader = FXMLLoader.load(getClass().getResource("FormNhanKhau.fxml"));
            formNhanKhau = new FormNhanKhau();
            loader.setController(formNhanKhau);

            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void them() {
    }

    @Test
    void xoa() {
    }
}