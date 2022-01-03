package nhom13.covid.View.TamTru;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import nhom13.covid.Dao.NhanKhauDao;
import nhom13.covid.Dao.TamTruDao;
import nhom13.covid.Model.TamTru;
import org.controlsfx.control.Notifications;
import org.controlsfx.validation.ValidationSupport;

import java.net.URL;
import java.util.ResourceBundle;

public class ThemTamTru implements Initializable {
	
	@FXML
	public GridPane formTamTru;
	
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
		
		TamTru tamTru = new TamTru();
		tamTru.setMaNhanKhau(form.getMaNhanKhau());
		tamTru.setMaHoKhau(form.getMaHoKhau());
		tamTru.setDcThuongTru(form.getDiaChiThuongTru());
		tamTru.setNgayThuongTru(form.getNgayBatDauTamTru());
		tamTru.setThoiHan(form.getNgayHetTamTru());
		
		if(nhanKhauDao.getByMaNhanKhau(tamTru.getMaNhanKhau()) == null) {
            Notifications.create()
                    .title("Lỗi input")
                    .text("Mã nhân khẩu không tồn tại")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
            return;
        }
		tamTruDao.insert(tamTru);
		
		form.clear();
		
		Notifications.create()
        .title("Thành công")
        .text("Thêm thông tin tạm trú thành công")
        .position(Pos.TOP_RIGHT)
        .hideAfter(Duration.seconds(5))
        .showConfirm();
	}
	
	private TamTruDao tamTruDao;
	private NhanKhauDao nhanKhauDao;
	private FormTamTru form;
	
	@Override
	public void initialize(URL location, ResourceBundle resourcesBundle) {
		// TODO Auto-generated method stub
		tamTruDao = new TamTruDao();
		nhanKhauDao = new NhanKhauDao();
		form = new FormTamTru();
		formTamTru.getChildren().setAll(form);
	}
	
	
}



























