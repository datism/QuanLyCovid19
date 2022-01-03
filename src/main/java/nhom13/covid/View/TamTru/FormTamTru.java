package nhom13.covid.View.TamTru;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import nhom13.covid.Model.TamTru;
import org.controlsfx.validation.Severity;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import java.io.IOException;
import java.sql.Date;

public class FormTamTru extends GridPane{
	
	@FXML
	private TextField maNhanKhauTextField; 
	
	@FXML
	private TextField maHoKhauTextField;
	
	@FXML
	private TextField diaChiThuongTruTextField;
	
	@FXML
	private DatePicker ngayBatDauTamTruDatePicker;
	
	@FXML
	private DatePicker ngayHetTamTruDatePicker;
	
	private ValidationSupport validationSupport;
	
	public void clear() {
		maNhanKhauTextField.clear();
		maHoKhauTextField.clear();
		diaChiThuongTruTextField.clear();
		ngayBatDauTamTruDatePicker.setValue(null);
		ngayHetTamTruDatePicker.setValue(null);
	}
	
	public FormTamTru() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("FormTamTru.fxml"));
			loader.setController(this);
            loader.setRoot(this);
            loader.load();		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		validationSupport = new ValidationSupport();
		validationSupport.registerValidator(maNhanKhauTextField, Validator.createRegexValidator("Mã nhân khẩu phải là số nguyên", "\\d+", Severity.ERROR));
		validationSupport.registerValidator(maHoKhauTextField, Validator.createRegexValidator("Mã hộ khẩu phải là số nguyên", "\\d+", Severity.ERROR));
		validationSupport.registerValidator(diaChiThuongTruTextField, Validator.createEmptyValidator("Không được bỏ trống"));
		validationSupport.registerValidator(ngayBatDauTamTruDatePicker, Validator.createEmptyValidator("Phải chọn ngày bắt đầu tạm trú"));
		validationSupport.registerValidator(ngayHetTamTruDatePicker, Validator.createEmptyValidator("Phải chọn ngày hết hạn tạm trú"));
	}
		
	public FormTamTru(TamTru tamTru) {
		this();
		setMaNhanKhau(tamTru.getMaNhanKhau());
		setMaHoKhau(tamTru.getMaHoKhau());
		setDiaChiThuongTru(tamTru.getDcThuongTru());
		setNgayBatDauTamTru(tamTru.getNgayThuongTru());
		setNgayHetTamTru(tamTru.getThoiHan());
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
    
    private StringProperty maHoKhauProperty() {
        return maHoKhauTextField.textProperty();
    }

    public Integer getMaHoKhau() {
        return Integer.valueOf(maHoKhauProperty().get());
    }

    public void setMaHoKhau(Integer maHoKhau) {
        maHoKhauProperty().setValue(maHoKhau.toString());
    }
    
    private StringProperty diaChiThuongTruProperty(){
        return diaChiThuongTruTextField.textProperty();
    }

    public String getDiaChiThuongTru() {
        return diaChiThuongTruProperty().get();
    }

    public void setDiaChiThuongTru(String diaChiThuongTru) {
    	diaChiThuongTruProperty().setValue(diaChiThuongTru);
    }
    
    public Date getNgayBatDauTamTru() {
        return Date.valueOf(ngayBatDauTamTruDatePicker.getValue());
    }

    public void setNgayBatDauTamTru(Date ngayBatDauTamTru) {
    	ngayBatDauTamTruDatePicker.setValue(ngayBatDauTamTru.toLocalDate());
    }
    
    public Date getNgayHetTamTru() {
        return Date.valueOf(ngayHetTamTruDatePicker.getValue());
    }

    public void setNgayHetTamTru(Date ngayHetTamTru) {
		if (ngayHetTamTru == null)
			return;
    	ngayHetTamTruDatePicker.setValue(ngayHetTamTru.toLocalDate());
    }
}






























