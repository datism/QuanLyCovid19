package nhom13.covid.View.NhanKhau;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import nhom13.covid.Dao.NhanKhauDao;
import nhom13.covid.Dao.SoHoKhauDao;
import nhom13.covid.Model.NhanKhau;
import org.controlsfx.control.Notifications;
import org.controlsfx.validation.ValidationSupport;

import java.net.URL;
import java.util.ResourceBundle;

public class SuaNhanKhau implements Initializable {

    @FXML
    private AnchorPane apNhanKhau;

    @FXML
    void Sua(ActionEvent event) {
        ValidationSupport validate = formNhanKhau.getValidate();

        if (validate.isInvalid()) {
            Notifications.create()
                    .title("Lỗi!")
                    .text("Điền lại thông tin.")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
            return;
        }

        NhanKhau nhanKhau = formNhanKhau.getNhanKhau();
        if (nhanKhau.getMaNhanKhau() != null)
            if(hoKhauDao.getByMaHoKhau(nhanKhau.getMaHoKhau()) == null) {
                Notifications.create()
                        .title("Lỗi!")
                        .text("Mã hộ khẩu không tồn tại.")
                        .position(Pos.TOP_RIGHT)
                        .hideAfter(Duration.seconds(5))
                        .showError();
                return;
            }

        Notifications.create()
                .title("Thành công")
                .text("Thêm nhân khẩu thành công")
                .position(Pos.TOP_RIGHT)
                .hideAfter(Duration.seconds(5))
                .showConfirm();

        ((Stage) apNhanKhau.getScene().getWindow()).close();
    }

    private FormNhanKhau formNhanKhau;
    private NhanKhauDao nhanKhauDao;
    private SoHoKhauDao hoKhauDao;

    SuaNhanKhau(NhanKhau iNhanKhau) {
        nhanKhauDao = new NhanKhauDao();
        hoKhauDao = new SoHoKhauDao();
        formNhanKhau = new FormNhanKhau();
        formNhanKhau.setNhanKhau(iNhanKhau);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        apNhanKhau.getChildren().setAll(formNhanKhau);
    }
}
