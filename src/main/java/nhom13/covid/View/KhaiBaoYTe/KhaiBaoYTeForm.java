/** Mạnh Thắng **/
package nhom13.covid.View.KhaiBaoYTe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import nhom13.covid.Dao.KhaiBaoYTeDao;
import nhom13.covid.Dao.NhanKhauDao;
import nhom13.covid.Model.KhaiBaoYTe;
import org.controlsfx.control.Notifications;
import org.controlsfx.validation.Severity;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class KhaiBaoYTeForm implements Initializable{
    @FXML
    private TextField hoVaTen;
    @FXML
    private TextField cccd;
    @FXML
    private TextField maNhanKhau;
    @FXML
    private TextField soDt;
    @FXML
    private TextField Email;
    @FXML
    private TextField noiDiChuyen;
    @FXML
    private TextField trieuChung;
    @FXML
    private TextField tienSu;
    @FXML
    private CheckBox sot;
    @FXML
    private CheckBox ho;
    @FXML
    private CheckBox khoTho;
    @FXML
    private CheckBox dauHong;

    //thêm khai báp y tế
    @FXML
    void khaiBao(ActionEvent actionEvent) {
        if (validationSupport.isInvalid()) {
            Notifications.create()
                    .title("Lỗi input")
                    .text("Mời nhập lại")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
            return;
        }

        Date date= new Date(System.currentTimeMillis());
        StringBuilder TrieuChung = new StringBuilder();
        if(ho.isSelected()) TrieuChung.append("ho;");
        if(sot.isSelected()) TrieuChung.append("sốt;");
        if(khoTho.isSelected()) TrieuChung.append("khó thở;");
        if(dauHong.isSelected()) TrieuChung.append("đau họng;");
        TrieuChung.append(trieuChung.getText());
        KhaiBaoYTe khaiBaoYTe = new KhaiBaoYTe(
                hoVaTen.getText(), cccd.getText(),
                Integer.parseInt(maNhanKhau.getText()), soDt.getText(),
                Email.getText(), noiDiChuyen.getText(),
                TrieuChung.toString(), date, tienSu.getText()
        );

        if (nhanKhauDao.getByMaNhanKhau(khaiBaoYTe.getMaNhanKhau()) == null) {
            Notifications.create()
                    .title("Lỗi input")
                    .text("Mã nhân khẩu không tồn tại")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
            return;
        }

        khaiBaoYTeDao.insert(khaiBaoYTe);

        Notifications.create()
                .title("Thành công")
                .text("Thêm thông tin khai báo y tế thành công covid thành công")
                .position(Pos.TOP_RIGHT)
                .hideAfter(Duration.seconds(5))
                .showConfirm();
    }

    private KhaiBaoYTeDao khaiBaoYTeDao;
    private NhanKhauDao nhanKhauDao;
    private ValidationSupport validationSupport;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        khaiBaoYTeDao = new KhaiBaoYTeDao();
        nhanKhauDao = new NhanKhauDao();
        validationSupport = new ValidationSupport();

        validationSupport.registerValidator(hoVaTen, Validator.createEmptyValidator("Không được bỏ trống"));
        validationSupport.registerValidator(cccd, Validator.createRegexValidator("Căn cước công dân chứa 12 chữ số", "\\d{12}", Severity.ERROR));
        validationSupport.registerValidator(maNhanKhau, Validator.createRegexValidator("Mã nhân khẩu phải là số nguyên", "\\d+", Severity.ERROR));
        validationSupport.registerValidator(soDt, Validator.createRegexValidator("Số điện thoại chứa phải có 11 chữ số", "\\d{11}", Severity.ERROR));
    }
}