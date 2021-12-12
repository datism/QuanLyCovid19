package nhom13.covid.View.TestCovid;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import nhom13.covid.Dao.NhanKhauDao;
import nhom13.covid.Dao.TestCovidDao;
import nhom13.covid.Model.TestCovid;
import org.controlsfx.control.Notifications;
import org.controlsfx.validation.ValidationSupport;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author trdat
 */
public class ThemTestCovid implements Initializable {

    @FXML
    private GridPane formTestCovid;

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

        TestCovid testCovid = new TestCovid();

        testCovid.setHoVaTen(form.getHoVaTen());
        testCovid.setCccd(form.getCanCuocCongDan());
        testCovid.setMaNhanKhau(form.getMaNhanKhau());
        testCovid.setSoDt(form.getSoDienThoai());
        testCovid.setSoLanTest(form.getSoLanTest());
        testCovid.setHinhThucTest(form.getHinhThucTest());
        testCovid.setKetQua(form.getKetQua());
        testCovid.setNgayTest(form.getNgayTest());

        if(nhanKhauDao.getByMaNhanKhau(testCovid.getMaNhanKhau()) == null) {
            Notifications.create()
                    .title("Lỗi input")
                    .text("Mã nhân khẩu không tồn tại")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
            return;
        }

        testCovidDao.insert(testCovid);

        form.clear();

        Notifications.create()
                .title("Thành công")
                .text("Thêm thông tin xét nghiệm covid thành công")
                .position(Pos.TOP_RIGHT)
                .hideAfter(Duration.seconds(5))
                .showConfirm();
    }

    private TestCovidDao testCovidDao;
    private NhanKhauDao nhanKhauDao;
    private FormTestCovid form;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        testCovidDao = new TestCovidDao();
        nhanKhauDao = new NhanKhauDao();

        form = new FormTestCovid();

        formTestCovid.getChildren().setAll(form);
    }
}
