package nhom13.covid.View.NhanKhau;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import nhom13.covid.Dao.NhanKhauDao;
import nhom13.covid.Dao.SoHoKhauDao;
import nhom13.covid.Model.NhanKhau;
import org.controlsfx.control.Notifications;
import org.controlsfx.validation.ValidationSupport;

import java.net.URL;
import java.util.ResourceBundle;



public class ThemNhanKhau implements Initializable {

    @FXML
    private AnchorPane apNhanKhau;

    @FXML
    void Themnhankhau(ActionEvent event) {
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
            if(soHoKhauDao.getByMaHoKhau(nhanKhau.getMaHoKhau()) == null) {
                    Notifications.create()
                            .title("Lỗi!")
                            .text("Mã hộ khẩu không tồn tại.")
                            .position(Pos.TOP_RIGHT)
                            .hideAfter(Duration.seconds(5))
                            .showError();
                    return;
            }

        if (nhanKhauDao.insert(nhanKhau) == null)
            Notifications.create()
                    .title("Lỗi!")
                    .text("Lỗi hệ thông")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
        else
            Notifications.create()
                    .title("Thành công")
                    .text("Thêm nhân khẩu thành công")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showConfirm();
        formNhanKhau = new FormNhanKhau();
    }

    private NhanKhauDao nhanKhauDao;
    private SoHoKhauDao soHoKhauDao;
    private FormNhanKhau formNhanKhau;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        nhanKhauDao = new NhanKhauDao();
        soHoKhauDao = new SoHoKhauDao();
        formNhanKhau = new FormNhanKhau();
        apNhanKhau.getChildren().setAll(formNhanKhau);
    }
}






