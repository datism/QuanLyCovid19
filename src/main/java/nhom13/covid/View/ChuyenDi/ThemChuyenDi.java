package nhom13.covid.View.ChuyenDi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import nhom13.covid.Dao.ChuyenDiDao;
import nhom13.covid.Dao.NhanKhauDao;
import nhom13.covid.Model.ChuyenDi;
import org.controlsfx.control.Notifications;
import org.controlsfx.validation.ValidationSupport;
import java.net.URL;
import java.util.ResourceBundle;

public class ThemChuyenDi implements Initializable {

    @FXML
    public GridPane formChuyenDi;

    @FXML
    void themButtonClicked(ActionEvent event) {
        ValidationSupport vs = form.getValidationSupport();
        if (vs.isInvalid()) {
            Notifications.create()
                    .title("Lỗi input")
                    .text("Mời nhập lại")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
            return;
        }

        ChuyenDi chuyenDi = new ChuyenDi();
        chuyenDi.setMaChuyenDi(form.getMaPhieu());
        chuyenDi.setMaNhanKhau(form.getMaNhanKhau());
        chuyenDi.setNoiChuyenDen(form.getNoiChuyenDen());
        chuyenDi.setLyDo(form.getLyDo());
        chuyenDi.setNgayChuyen(form.getNgayChuyenDi());

        if(nhanKhauDao.getByMaNhanKhau(chuyenDi.getMaNhanKhau()) == null) {
            Notifications.create()
                    .title("Lỗi input")
                    .text("Mã nhân khẩu không tồn tại")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
            return;
        }

        chuyenDiDao.insert(chuyenDi);

        form.clear();

        Notifications.create()
                .title("Thành công")
                .text("Thêm thông tin chuyển đến thành công")
                .position(Pos.TOP_RIGHT)
                .hideAfter(Duration.seconds(5))
                .showConfirm();
    }

    private ChuyenDiDao chuyenDiDao;
    private NhanKhauDao nhanKhauDao;
    private FormChuyenDi form;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chuyenDiDao = new ChuyenDiDao();
        nhanKhauDao = new NhanKhauDao();
        form = new FormChuyenDi();
        formChuyenDi.getChildren().setAll(form);
    }
}


