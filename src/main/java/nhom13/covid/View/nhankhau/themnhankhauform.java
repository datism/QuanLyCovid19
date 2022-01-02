package nhom13.covid.View.nhankhau;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.util.Duration;
import nhom13.covid.Dao.NhanKhauDao;
import nhom13.covid.Model.NhanKhau;
import org.controlsfx.control.Notifications;
import org.controlsfx.validation.Severity;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;



import java.net.URL;
import java.util.ResourceBundle;



public class themnhankhauform implements Initializable {
    @FXML
    private TextField hoVaTen;
    @FXML
    private TextField cccd;
    @FXML
    private TextField maHoKhau;
    @FXML
    private TextField ngaySinh;
    @FXML
    private TextField noiSinh;
    @FXML
    private TextField tonGiao;
    @FXML
    private TextField danToc;
    @FXML
    private CheckBox Nam;
    @FXML
    private CheckBox Nu;
    @FXML
    private TextField trinhDoVH;
    @FXML
    private TextField ngheNghiep;
    @FXML
    private TextField noiLamViec;
    @FXML
    private TextField ngayDKThuongTru;
    @FXML
    private TextField qhChuHo;
    @FXML
    private TextField ghiChu;
    @FXML
    Button Themnhankhau;


    @FXML
    void Themnhankhau(ActionEvent event) {
        if (validationSupport.isInvalid()) {
            Notifications.create()
                    .title("Lỗi")
                    .text("Nhập lại ")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
            return;
        }
        StringBuilder gioitinh = new StringBuilder();
        if(Nam.isSelected()) gioitinh.append("Nam");
        if(Nu.isSelected())gioitinh.append("Nữ");
        NhanKhau Themnhankhau = new NhanKhau(
                hoVaTen.getText(),
                cccd.getText(),
                ngaySinh.getText(),
                noiSinh.getText(),
                tonGiao.getText(),
                gioitinh.toString(),
                danToc.getText(),
                trinhDoVH.getText(),
                ngheNghiep.getText(),
                noiLamViec.getText(),
                ngayDKThuongTru.getText(),
                qhChuHo.getText(),
                Integer.parseInt(maHoKhau.getText()),
                ghiChu.getText()


        );

        nhanKhauDao.insert(Themnhankhau);

        Notifications.create()
                .title("Thanh cong")
                .text("Them nhan khau thanh cong")
                .position(Pos.TOP_RIGHT)
                .hideAfter(Duration.seconds(4))
                .showConfirm();


    }

    private ValidationSupport validationSupport;
    private NhanKhauDao nhanKhauDao;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        nhanKhauDao = new NhanKhauDao();
        validationSupport = new ValidationSupport();
        validationSupport.registerValidator(hoVaTen, Validator.createEmptyValidator("không được bỏ trống"));
        validationSupport.registerValidator(cccd, Validator.createRegexValidator("Căn cước công dân chứa 12 chữ số", "\\d{12}", Severity.ERROR));
        validationSupport.registerValidator(maHoKhau, Validator.createRegexValidator("Mã Hộ Khẩu phải là số nguyên", "\\d+", Severity.ERROR));

    }

}






