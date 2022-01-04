package nhom13.covid.View.SoHoKhau;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.controlsfx.validation.Severity;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

public class ThemHoKhau extends AnchorPane {
    @FXML
    private TextField maChuHo;

    @FXML
    private TextField soDuong;

    @FXML
    private TextField soNha;

    @FXML
    private DatePicker ngayCap;

   private ValidationSupport validation;


    public ThemHoKhau() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ThemHoKhau.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        validation = new ValidationSupport();

        validation.registerValidator(maChuHo, Validator.createRegexValidator("Mã chủ hộ phải là số nguyên dương", "\\d*", Severity.ERROR));
        validation.registerValidator(soDuong, Validator.createRegexValidator("Số đường là số nguyên dương", "\\d*", Severity.ERROR));
        validation.registerValidator(soNha, Validator.createEmptyValidator("Số nhà không được để trống"));
        validation.registerValidator(ngayCap, Validator.createEmptyValidator("Ngày cấp không được để trống"));
    }

    public ValidationSupport getValidation() {
        return validation;
    }

    StringProperty maChuHoProperty() {
        return maChuHo.textProperty();
    }

    StringProperty soNhaProperty() {
        return soNha.textProperty();
    }

    StringProperty soDuongProperty() {
        return soDuong.textProperty();
    }

    ObjectProperty<LocalDate> ngayCapProperty() {
        return ngayCap.valueProperty();
    }

    public Integer getMaChuHo() {
        try {
            return Integer.valueOf(maChuHoProperty().get());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public String getSoNha() {
        return soNhaProperty().get();
    }

    public Integer getSoDuong() {
        try {
            return Integer.valueOf(soDuongProperty().get());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public Date getNgayCap() {
        return Date.valueOf(ngayCapProperty().get());
    }


}
