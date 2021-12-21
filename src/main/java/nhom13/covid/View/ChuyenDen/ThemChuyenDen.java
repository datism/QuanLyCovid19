package nhom13.covid.View.ChuyenDen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import nhom13.covid.Dao.ChuyenDenDao;
import nhom13.covid.Dao.NhanKhauDao;
import nhom13.covid.Model.ChuyenDen;
import org.controlsfx.control.Notifications;
import org.controlsfx.validation.ValidationSupport;

import java.net.URL;
import java.util.ResourceBundle;

public class ThemChuyenDen implements Initializable {

    @FXML
    public GridPane formChuyenDen;

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

        ChuyenDen chuyenDen = new ChuyenDen();
        chuyenDen.setMaChuyenDen(form.getMaPhieu());
        chuyenDen.setMaNhanKhau(form.getMaNhanKhau());
        chuyenDen.setNoiChuyenDi(form.getNoiChuyenDi());
        chuyenDen.setLyDo(form.getLyDo());
        chuyenDen.setNgayChuyen(form.getNgayChuyenDen());

        if(nhanKhauDao.getByMaNhanKhau(chuyenDen.getMaNhanKhau()) == null) {
            Notifications.create()
                    .title("Lỗi input")
                    .text("Mã nhân khẩu không tồn tại")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
            return;
        }

        chuyenDenDao.insert(chuyenDen);

        form.clear();

        Notifications.create()
                .title("Thành công")
                .text("Thêm thông tin chuyển đến thành công")
                .position(Pos.TOP_RIGHT)
                .hideAfter(Duration.seconds(5))
                .showConfirm();
    }

    private ChuyenDenDao chuyenDenDao;
    private NhanKhauDao nhanKhauDao;
    private FormChuyenDen form;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chuyenDenDao = new ChuyenDenDao();
        nhanKhauDao = new NhanKhauDao();
        form = new FormChuyenDen();
        formChuyenDen.getChildren().setAll(form);
    }
}


