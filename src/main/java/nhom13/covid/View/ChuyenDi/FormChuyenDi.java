package nhom13.covid.View.ChuyenDi;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import nhom13.covid.Model.ChuyenDi;
import org.controlsfx.validation.Severity;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import java.io.IOException;
import java.sql.Date;


public class FormChuyenDi extends GridPane {
    @FXML
    private TextField maPhieuTextField;

    @FXML
    private TextField maNhanKhauTextField;

    @FXML
    private TextField noiChuyenDenTextField;

    @FXML
    private TextField lyDoTextField;

    @FXML
    private DatePicker ngayChuyenDiDatePicker;

    private ValidationSupport validationSupport;


    public void clear() {
        maPhieuTextField.clear();
        maNhanKhauTextField.clear();
        noiChuyenDenTextField.clear();
        lyDoTextField.clear();
        ngayChuyenDiDatePicker.setValue(null);
    }

    public FormChuyenDi(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FormChuyenDi.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException e) {
            //e.printStackTrace();
        }

        validationSupport = new ValidationSupport();

        validationSupport.registerValidator(maPhieuTextField, Validator.createRegexValidator("Mã Phiếu phải là số nguyên", "\\d+", Severity.ERROR));
        validationSupport.registerValidator(maNhanKhauTextField, Validator.createRegexValidator("Mã nhân khẩu phải là số nguyên", "\\d+", Severity.ERROR));
        validationSupport.registerValidator(noiChuyenDenTextField, Validator.createEmptyValidator("Không được bỏ trống"));
        validationSupport.registerValidator(lyDoTextField, Validator.createEmptyValidator("Không được bỏ trống"));
        validationSupport.registerValidator(ngayChuyenDiDatePicker, Validator.createEmptyValidator("Phải chọn ngày"));


    }

    public FormChuyenDi(ChuyenDi chuyenDi) {
        this();
        setMaPhieu(chuyenDi.getMaChuyenDi());
        setMaNhanKhau(chuyenDi.getMaNhanKhau());
        setNoiChuyenDen(chuyenDi.getNoiChuyenDen());
        setLyDo(chuyenDi.getLyDo());
        setNgayChuyenDi(chuyenDi.getNgayChuyen());
        maPhieuTextField.setEditable(false);
    }

    public ValidationSupport getValidationSupport() {
        return validationSupport;
    }

    private StringProperty maPhieuProperty() {
        return maPhieuTextField.textProperty();
    }

    public Integer getMaPhieu() {
        return Integer.valueOf(maPhieuProperty().get());
    }

    public void setMaPhieu(Integer maPhieu) {
        maPhieuProperty().setValue(maPhieu.toString());
    }

    private StringProperty maNhanKhauProperty() {
        return maNhanKhauTextField.textProperty();
    }

    public Integer getMaNhanKhau() {
        return Integer.valueOf(maNhanKhauProperty().get());
    }

    public void setMaNhanKhau(Integer maNhanKhau) {
        maNhanKhauProperty().setValue(maNhanKhau.toString());
    }

    private StringProperty noiChuyenDenProperty(){
        return noiChuyenDenTextField.textProperty();
    }

    public String getNoiChuyenDen() {
        return noiChuyenDenProperty().get();
    }

    public void setNoiChuyenDen(String noiChuyenDen) {
        noiChuyenDenProperty().setValue(noiChuyenDen);
    }

    private StringProperty lyDoProperty() {
        return lyDoTextField.textProperty();
    }

    public String getLyDo() {
        return lyDoProperty().get();
    }

    public void setLyDo(String lyDo) {
        lyDoProperty().setValue(lyDo);
    }

    public Date getNgayChuyenDi() {
        return Date.valueOf(ngayChuyenDiDatePicker.getValue());
    }

    public void setNgayChuyenDi(Date ngayChuyenDi) {
        ngayChuyenDiDatePicker.setValue(ngayChuyenDi.toLocalDate());
    }
}

