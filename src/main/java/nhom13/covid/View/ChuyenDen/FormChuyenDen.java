package nhom13.covid.View.ChuyenDen;


import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import nhom13.covid.Model.ChuyenDen;
import org.controlsfx.validation.Severity;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import java.io.IOException;
import java.sql.Date;


public class FormChuyenDen extends GridPane {
    @FXML
    private TextField maPhieuTextField;

    @FXML
    private TextField maNhanKhauTextField;

    @FXML
    private TextField noiChuyenDiTextField;

    @FXML
    private TextField lyDoTextField;

    @FXML
    private DatePicker ngayChuyenDenDatePicker;

    private ValidationSupport validationSupport;


    public void clear() {
        maPhieuTextField.clear();
        maNhanKhauTextField.clear();
        noiChuyenDiTextField.clear();
        lyDoTextField.clear();
        ngayChuyenDenDatePicker.setValue(null);
    }

    public FormChuyenDen(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FormChuyenDen.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException e) {
            //e.printStackTrace();
        }

        validationSupport = new ValidationSupport();

        validationSupport.registerValidator(maPhieuTextField, Validator.createRegexValidator("Mã Phiếu phải là số nguyên", "\\d+", Severity.ERROR));
        validationSupport.registerValidator(maNhanKhauTextField, Validator.createRegexValidator("Mã nhân khẩu phải là số nguyên", "\\d+", Severity.ERROR));
        validationSupport.registerValidator(noiChuyenDiTextField, Validator.createEmptyValidator("Không được bỏ trống"));
        validationSupport.registerValidator(lyDoTextField, Validator.createEmptyValidator("Không được bỏ trống"));
        validationSupport.registerValidator(ngayChuyenDenDatePicker, Validator.createEmptyValidator("Phải chọn ngày"));


    }

    public FormChuyenDen(ChuyenDen chuyenDen) {
        this();
        setMaPhieu(chuyenDen.getMaChuyenDen());
        setMaNhanKhau(chuyenDen.getMaNhanKhau());
        setNoiChuyenDi(chuyenDen.getNoiChuyenDi());
        setLyDo(chuyenDen.getLyDo());
        setNgayChuyenDen(chuyenDen.getNgayChuyen());
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

    private StringProperty noiChuyenDiProperty(){
        return noiChuyenDiTextField.textProperty();
    }

    public String getNoiChuyenDi() {
        return noiChuyenDiProperty().get();
    }

    public void setNoiChuyenDi(String noiChuyenDi) {
        noiChuyenDiProperty().setValue(noiChuyenDi);
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

    public Date getNgayChuyenDen() {
        return Date.valueOf(ngayChuyenDenDatePicker.getValue());
    }

    public void setNgayChuyenDen(Date ngayChuyenDen) {
        ngayChuyenDenDatePicker.setValue(ngayChuyenDen.toLocalDate());
    }
}

