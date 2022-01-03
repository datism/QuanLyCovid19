package nhom13.covid.View.TamVang;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import nhom13.covid.Model.TamVang;
import org.controlsfx.validation.Severity;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import java.io.IOException;
import java.sql.Date;
public class FormTamVang extends GridPane{
	
	@FXML
	private TextField maNhanKhauTextField;
	
	@FXML
	private DatePicker ngayTamVangDatePicker;
	
	@FXML
	private TextField noiDiTextField;
	
	private ValidationSupport validationSupport;
	
	public void clear() {
        maNhanKhauTextField.clear();
        noiDiTextField.clear();
        ngayTamVangDatePicker.setValue(null);
    }
	
	public FormTamVang() {
		try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FormTamVang.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
        validationSupport = new ValidationSupport();

        validationSupport.registerValidator(maNhanKhauTextField, Validator.createRegexValidator("Mã nhân khẩu phải là số nguyên", "\\d+", Severity.ERROR));
        validationSupport.registerValidator(noiDiTextField, Validator.createEmptyValidator("Không được bỏ trống"));
        validationSupport.registerValidator(ngayTamVangDatePicker, Validator.createEmptyValidator("Phải chọn ngày bắt đầu tạm vắng"));

	}
	
	public FormTamVang(TamVang tamVang) {
		this();
		setMaNhanKhau(tamVang.getMaNhanKhau());
		setnoiDi(tamVang.getNoiDi());
		setNgayTamVang(tamVang.getNgayTamVang());
	}
	
	
	public ValidationSupport getValidationSupport() {
        return validationSupport;
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
    
    private StringProperty noiDiProperty(){
        return noiDiTextField.textProperty();
    }

    public String getnoiDi() {
        return noiDiProperty().get();
    }

    public void setnoiDi(String noiDi) {
    	noiDiProperty().setValue(noiDi);
    }
    
    public Date getNgayTamVang() {
        return Date.valueOf(ngayTamVangDatePicker.getValue());
    }

    public void setNgayTamVang(Date ngayTamVang) {
        ngayTamVangDatePicker.setValue(ngayTamVang.toLocalDate());
    }
}






















