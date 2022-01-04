package nhom13.covid.View.SoHoKhau;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import nhom13.covid.Dao.NhanKhauDao;
import nhom13.covid.Dao.SoHoKhauDao;
import nhom13.covid.Model.NhanKhau;
import nhom13.covid.Model.SoHoKhau;
import org.controlsfx.control.BreadCrumbBar;
import org.controlsfx.control.Notifications;
import org.controlsfx.validation.ValidationSupport;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Them implements Initializable {

    @FXML
    protected BreadCrumbBar<String> breadBar;

    @FXML
    protected AnchorPane servicePane;

    @FXML
    protected Button button1;

    @FXML
    protected Button button2;

    protected NhanKhauDao nhanKhauDao;
    protected SoHoKhauDao hoKhauDao;

    private ThemHoKhau themHoKhau;
    protected ThemNkVaoHk themNkVaoHk;

    protected TreeItem<String> item1;
    protected TreeItem<String> item2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nhanKhauDao = new NhanKhauDao();
        hoKhauDao = new SoHoKhauDao();
        themHoKhau = new ThemHoKhau();

        themNkVaoHk = new ThemNkVaoHk();
        themNkVaoHk.setSourceLabel("Nhân khẩu chưa có hộ khẩu");
        themNkVaoHk.removeQhChuCu();


        initBreadBar();
        startThongTinHoKhau();
    }

    void initBreadBar() {
        item1 = new TreeItem<>("Thông tin hộ khẩu mới");
        item2 = new TreeItem<>("Thêm nhân khẩu");
        item1.getChildren().add(item2);

        breadBar.setOnCrumbAction(event -> {
            TreeItem<String> item = event.getSelectedCrumb();
            if (item.equals(item1))
                startThongTinHoKhau();
            else if (item.equals(item2))
                startThemNhanKhau();
        });
    }

    boolean checkHokhau() {
        ValidationSupport validation = themHoKhau.getValidation();

        if (validation.isInvalid()) {
            Notifications.create()
                    .title("Lỗi!")
                    .text("Điền lại thông tin.")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
            return false;
        }

        NhanKhau chuHo = nhanKhauDao.getByMaNhanKhau(themHoKhau.getMaChuHo());
        if (chuHo == null) {
            Notifications.create()
                    .title("Lỗi!")
                    .text("Chủ hộ không tồn tại")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
            return false;
        }
        if (chuHo.getMaHoKhau() != null) {
            Notifications.create()
                    .title("Lỗi!")
                    .text("Chủ hộ đã có hộ khẩu")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
            return false;
        }

        return true;
    }

    void startThongTinHoKhau() {
        servicePane.getChildren().setAll(themHoKhau);
        breadBar.setSelectedCrumb(item1);

        button1.setVisible(false);
        button2.setVisible(true);
        button2.setText("Tiếp tục");
        button2.setOnAction(event -> {
            if (!checkHokhau())
                return;
            startThemNhanKhau();
        });
    }

    void startThemNhanKhau() {
        List<NhanKhau> nhanKhauList = nhanKhauDao.getByMaHoKhau(null);
        breadBar.setSelectedCrumb(item2);

        Integer maChuHo = themHoKhau.getMaChuHo();
        for (NhanKhau nhakhau : nhanKhauList) {
            if (nhakhau.getMaNhanKhau().equals(maChuHo)) {
                nhanKhauList.remove(nhakhau);
                break;
            }
        }

        themNkVaoHk.setSourceList(nhanKhauList);

        servicePane.getChildren().setAll(themNkVaoHk);

        button1.setVisible(true);
        button1.setText("Quay lại");
        button1.setOnAction(event -> {
            startThongTinHoKhau();
        });

        button2.setVisible(true);
        button2.setText("Hoàn thành");
        button2.setOnAction(event -> {
            SoHoKhau soHoKhau = new SoHoKhau();
            soHoKhau.setChuHo(themHoKhau.getMaChuHo());
            soHoKhau.setSoNha(themHoKhau.getSoNha());
            soHoKhau.setDuongID(themHoKhau.getSoDuong());
            soHoKhau.setNgayCap(themHoKhau.getNgayCap());

            Integer maHoKhau = hoKhauDao.insert(soHoKhau);

            if (maHoKhau == null) {
                Notifications.create()
                        .title("Lỗi!")
                        .text("Lỗi hệ thống")
                        .position(Pos.TOP_RIGHT)
                        .hideAfter(Duration.seconds(5))
                        .showError();
                return;
            }

            List<NhanKhau> nNhanKhau = themNkVaoHk.getListNhanKhauMoiThem();

            for (NhanKhau nhanKhau: nNhanKhau) {
                nhanKhau.setMaHoKhau(maHoKhau);
                nhanKhauDao.update(nhanKhau);
            }

            nhanKhauDao.updateHoKhau(maHoKhau, maChuHo);

            themHoKhau = new ThemHoKhau();
            startThongTinHoKhau();
        });
    }
}
