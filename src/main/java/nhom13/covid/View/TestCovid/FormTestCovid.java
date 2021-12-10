package nhom13.covid.View.TestCovid;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import nhom13.covid.Model.TestCovid;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

/**
 * @author trdat
 * @// TODO: 12/10/2021 control input 
 */
public class FormTestCovid extends GridPane implements Initializable{
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

    private final String[] ketQuaArr = {"Duơng tính", "Âm tính"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ketQuaChoiceBox.getItems().setAll(ketQuaArr);
    }

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
    }

    public FormTestCovid(TestCovid testCovid) {
        this();
        setHoVaTen(testCovid.getHoVaTen());
        setCanCuocCongDan(testCovid.getCccd());
        setMaNhanKhau(testCovid.getMaNhanKhau());
        setSoDienThoai(testCovid.getSoDt());
        setSoLanTest(testCovid.getSoLanTest());
        setHinhThucTest(testCovid.getHinhThucTest());
        setKetQua(testCovid.isKetQua());
        setNgayTest(testCovid.getNgayTest());

        maNhanKhauTextField.setEditable(false);
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
