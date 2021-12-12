package nhom13.covid.View.TestCovid;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import nhom13.covid.Model.TestCovid;
import org.controlsfx.validation.Severity;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import java.io.IOException;
import java.sql.Date;

/**
 * @author trdat
 */
public class FormTestCovid extends GridPane {
    @FXML
    private TextField hoVaTenTextField;

    @FXML
    private TextField canCuocCongDanTextField;

    @FXML
    private TextField maNhanKhauTextField;

    @FXML
    private TextField soDienThoaiTextField;

    @FXML
    private TextField soLanTestTextField;

    @FXML
    private TextField hinhThucTestTextField;

    @FXML
    private ChoiceBox<String> ketQuaChoiceBox;

    @FXML
    private DatePicker ngayTestDatePicker;

    private ValidationSupport validationSupport;

    private final String[] ketQuaArr = {"Duơng tính", "Âm tính"};

    public void clear() {
        hoVaTenTextField.clear();
        canCuocCongDanTextField.clear();
        maNhanKhauTextField.clear();
        soDienThoaiTextField.clear();
        soLanTestTextField.clear();
        hinhThucTestTextField.clear();
        ketQuaChoiceBox.setValue(null);
        ngayTestDatePicker.setValue(null);
    }

    public FormTestCovid(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FormTestCovid.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ketQuaChoiceBox.getItems().setAll(ketQuaArr);

        validationSupport = new ValidationSupport();

        validationSupport.registerValidator(hoVaTenTextField, Validator.createEmptyValidator("Không được bỏ trống"));
        validationSupport.registerValidator(canCuocCongDanTextField, Validator.createRegexValidator("Căn cước công dân chứa 12 chữ số", "\\d{12}", Severity.ERROR));
        validationSupport.registerValidator(maNhanKhauTextField, Validator.createRegexValidator("Mã nhân khẩu phải là số nguyên", "\\d+", Severity.ERROR));
        validationSupport.registerValidator(soDienThoaiTextField, Validator.createRegexValidator("Số điện thoại chứa phải có 11 chữ số", "\\d{11}", Severity.ERROR));
        validationSupport.registerValidator(soLanTestTextField, Validator.createRegexValidator("Số lần test phải là số nguyên", "\\d+", Severity.ERROR));
        validationSupport.registerValidator(hinhThucTestTextField, Validator.createEmptyValidator("Không được bỏ trống"));
        validationSupport.registerValidator(ketQuaChoiceBox, Validator.createEmptyValidator("Phải chọn kết quả"));
        validationSupport.registerValidator(ngayTestDatePicker, Validator.createEmptyValidator("Phải chọn ngày"));


    }

    public FormTestCovid(TestCovid testCovid) {
        this();
        setHoVaTen(testCovid.getHoVaTen());
        setCanCuocCongDan(testCovid.getCccd());
        setMaNhanKhau(testCovid.getMaNhanKhau());
        setSoDienThoai(testCovid.getSoDt());
        setSoLanTest(testCovid.getSoLanTest());
        setHinhThucTest(testCovid.getHinhThucTest());
        setKetQua(testCovid.getKetQua());
        setNgayTest(testCovid.getNgayTest());

        maNhanKhauTextField.setEditable(false);
    }

    public ValidationSupport getValidationSupport() {
        return validationSupport;
    }

    private StringProperty hoVaTenProperty(){
        return hoVaTenTextField.textProperty();
    }

    public String getHoVaTen() {
        return hoVaTenProperty().get();
    }

    public void setHoVaTen(String hoVaTen) {
        hoVaTenProperty().setValue(hoVaTen);
    }

    private StringProperty canCuocCongDanProperty() {
        return canCuocCongDanTextField.textProperty();
    }

    public String getCanCuocCongDan() {
        return canCuocCongDanProperty().get();
    }

    public void setCanCuocCongDan(String canCuocCongDan) {
        canCuocCongDanProperty().setValue(canCuocCongDan);
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

    private StringProperty soDienThoaiProperty() {
        return soDienThoaiTextField.textProperty();
    }

    public String getSoDienThoai() {
        return soDienThoaiProperty().get();
    }

    public void setSoDienThoai(String soDienThoai) {
        soDienThoaiProperty().setValue(soDienThoai);
    }

    private StringProperty soLanTestProperty() {
        return soLanTestTextField.textProperty();
    }

    public Integer getSoLanTest() {
        return Integer.valueOf(soLanTestProperty().get());
    }

    public void setSoLanTest(Integer soLantest) {
        soLanTestProperty().setValue(soLantest.toString());
    }

    private StringProperty hinhThucProperty() {
        return hinhThucTestTextField.textProperty();
    }

    public String getHinhThucTest() {
        return  hinhThucProperty().get();
    }

    public void setHinhThucTest(String hinhThucTest) {
        hinhThucProperty().setValue(hinhThucTest);
    }

    private ObjectProperty<String> ketQuaProperty() {
        return ketQuaChoiceBox.valueProperty();
    }

    public Boolean getKetQua() {
        return ketQuaProperty().get().equals(ketQuaArr[0]);
    }

    public void setKetQua(Boolean ketQua) {
        ketQuaProperty().setValue(ketQua ? ketQuaArr[0] : ketQuaArr[1]);
    }

    public Date getNgayTest() {
        return Date.valueOf(ngayTestDatePicker.getValue());
    }

    public void setNgayTest(Date ngayTest) {
        ngayTestDatePicker.setValue(ngayTest.toLocalDate());
    }
}
