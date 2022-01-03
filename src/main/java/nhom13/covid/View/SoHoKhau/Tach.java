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

public class Tach implements Initializable {

    @FXML
    private BreadCrumbBar<String> breadBar;

    @FXML
    private AnchorPane servicePane;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    private NhanKhauDao nhanKhauDao;
    private SoHoKhauDao hoKhauDao;

    private TachHoKhau tachHokhau;
    private ThemNkVaoHk themNkVaoHk;

    private TreeItem<String> item1;
    private TreeItem<String> item2;

    private NhanKhau chuHoMoi;
    private NhanKhau chuHoCu;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nhanKhauDao = new NhanKhauDao();
        hoKhauDao = new SoHoKhauDao();
        tachHokhau = new TachHoKhau();
        initBreadBar();
        startThongTinHoKhau();
    }

    void initBreadBar() {
        item1 = new TreeItem<>("Thông tin hộ khẩu");
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
        ValidationSupport validation = tachHokhau.getValidation();

        if (validation.isInvalid()) {
            Notifications.create()
                    .title("Lỗi!")
                    .text("Điền lại thông tin.")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
            return false;
        }

        chuHoMoi = nhanKhauDao.getByMaNhanKhau(tachHokhau.getMaChuHoMoi());
        chuHoCu = nhanKhauDao.getByMaNhanKhau(tachHokhau.getMaChuHoCu());
        Integer maHoKhauCu = tachHokhau.getMaHoKhauCu();

        if (chuHoMoi == null || chuHoCu == null) {
            Notifications.create()
                    .title("Lỗi!")
                    .text("Chủ hộ không tồn tại")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
            return false;
        }

        if (!chuHoMoi.getMaHoKhau().equals(maHoKhauCu) || !chuHoCu.getMaHoKhau().equals(maHoKhauCu)) {
            Notifications.create()
                    .title("Lỗi!")
                    .text("Chủ hộ không thuộc hộ khẩu đã chọn")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
            return false;
        }

        return true;
    }

    void startThongTinHoKhau() {
        servicePane.getChildren().setAll(tachHokhau);
        breadBar.setSelectedCrumb(item1);

        button1.setVisible(false);
        button2.setVisible(true);
        button2.setText("Tiếp tục");
        button2.setOnAction(event -> {
            if (!checkHokhau()) {
                chuHoCu = null;
                chuHoMoi = null;
                return;
            }

            startThemNhanKhau();
        });
    }

    void startThemNhanKhau() {
        breadBar.setSelectedCrumb(item2);

        List<NhanKhau> nhanKhauList = tachHokhau.getNhanKhauList();
        nhanKhauList.remove(chuHoCu);
        nhanKhauList.remove(chuHoMoi);

        themNkVaoHk = new ThemNkVaoHk(nhanKhauList);
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
            soHoKhau.setSoNha(tachHokhau.getSoNha());
            soHoKhau.setDuongID(tachHokhau.getSoDuong());
            soHoKhau.setChuHo(tachHokhau.getMaChuHoMoi());
            soHoKhau.setNgayCap(tachHokhau.getNgayCap());

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

            chuHoCu.setQhChuHo(null);
            chuHoMoi.setQhChuHo(null);
            chuHoMoi.setMaHoKhau(soHoKhau.getMaHoKhau());

            nhanKhauDao.update(chuHoCu);
            nhanKhauDao.update(chuHoMoi);

            tachHokhau = new TachHoKhau();
            startThongTinHoKhau();
        });
    }
}
