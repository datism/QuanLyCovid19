package nhom13.covid.View.nhankhau;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import org.controlsfx.validation.ValidationSupport;

import java.util.Date;

public class themnhankhauform {
    @FXML
    private TextField Hovaten;
    @FXML
    private TextField CCCD;
    @FXML
    private TextField Manhankhau;
    @FXML
    private TextField Ngaysinh;
    @FXML
    private TextField Noisinh;
    @FXML
    private TextField Tongiao;
    @FXML
    private TextField Dantoc;
    @FXML
    private CheckBox Nam;
    @FXML
    private CheckBox Nu;
    @FXML
    private CheckBox Khac;
    @FXML
    private TextField Trinhdovanhoa;
    @FXML
    private TextField Ngaydangkithuongtru;
    @FXML
    private TextField Quanhevoichuho;
    @FXML
    private TextField Ghichu;


    @FXML
    void Themnhankhau(ActionEvent event){
        if(validationSuport.isInvalid()){
            Notifications.create()
                    .title("Lỗi")
                    .text("Nhập lại ")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
            return;
        }
        Date date = new Date(System.currentTimeMillis());
        StringBuilder Gioitinh = new StringBuilder();
        if(Nam.isSelected()) Gioitinh.append("Nam");
        if(Nu.isSelected())Gioitinh.append("Nữ");
        if(Khac.isSelected())Gioitinh.append("Khác")
        Gioitinh.append(Gioitinh)
    }
}



