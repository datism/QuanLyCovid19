package nhom13.covid.View.TamVang;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import nhom13.covid.Dao.NhanKhauDao;
import nhom13.covid.Dao.TamVangDao;
import nhom13.covid.Model.TamVang;
import org.controlsfx.control.Notifications;
import org.controlsfx.validation.ValidationSupport;

import java.net.URL;
import java.util.ResourceBundle;

public class ThemTamVang implements Initializable{
	
	@FXML
	public GridPane formTamVang;
	
	@FXML
	void themButtonClicked(ActionEvent event) {
		ValidationSupport vs = form.getValidationSupport();
        if (vs.isInvalid()) {
            Notifications.create()
                    .title("Lỗi input")
                    .text("Mời nhập lại")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
            return;
        }
        
        TamVang tamVang = new TamVang();
        tamVang.setMaNhanKhau(form.getMaNhanKhau());
        tamVang.setNoiDi(form.getnoiDi());
        tamVang.setNgayTamVang(form.getNgayTamVang());
        
        if(nhanKhauDao.getByMaNhanKhau(tamVang.getMaNhanKhau()) == null) {
            Notifications.create()
                    .title("Lỗi input")
                    .text("Mã nhân khẩu không tồn tại")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
            return;
        }
        
        tamVangDao.insert(tamVang);
        
        form.clear();
        
        Notifications.create()
        	.title("Thành công")
        	.text("Thêm thông tin tạm vắng thành công")
        	.position(Pos.TOP_RIGHT)
        	.hideAfter(Duration.seconds(5))
        	.showConfirm();
	}
	
	private TamVangDao tamVangDao;
	private NhanKhauDao nhanKhauDao;
	private FormTamVang form;
	
	@Override
	public void initialize(URL location, ResourceBundle resourceBundle) {
		tamVangDao = new TamVangDao();
		nhanKhauDao = new NhanKhauDao();
		form = new FormTamVang();
		formTamVang.getChildren().setAll(form);
	}

}















