package nhom13.covid.View.TamVang;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import nhom13.covid.Dao.TamVangDao;
import nhom13.covid.Model.TamVang;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Stream;

public class XemTamVang implements Initializable {
	
	private TamVangDao tamVangDao;
	
	@FXML
	private TableView<TamVang> tamVangTable;
	
	@FXML
	private TableColumn<TamVang, Integer> maPhieuCol;
	
	@FXML
	private TableColumn<TamVang, Integer> maNhanKhauCol;
	
	@FXML
	private TableColumn<TamVang, String> noiDiCol;
	
	@FXML
	private VBox chiTietVbox;
	
	@FXML
	private GridPane formTamVang;
	
	@FXML
	private TextField timKiemTextField;
	
	@FXML
	private ChoiceBox<String> timKiemChoiceBox;
	
	@FXML
	public void timKiemButtonClicked(ActionEvent actionEvent) {
		//Lấy kết quả cần tìm
		String timKiem = timKiemTextField.getText();
		//Lấy thuộc tính cần tìm tiếp theo
		String timKiemTheo = timKiemChoiceBox.getValue();
		if (timKiemTheo == null) 
			return;
		
		Stream<TamVang> stream = tamVangDao.getAll().stream();
		
		//Truy vấn db lấy kết quả
		switch (timKiemTheo) {
			case "Mã Phiếu" -> stream = stream .filter(TamVang -> Integer.valueOf(timKiem).equals(TamVang.getMaTamVang()));
			case "Mã Nhân Khẩu" -> stream = stream .filter(TamVang -> Integer.valueOf(timKiem).equals(TamVang.getMaNhanKhau()));
		}
		
		//Hiển thị kết quả
		tamVangList.setAll(stream.toList());
		tamVangTable.setItems(tamVangList);
	}
	
	@FXML
	void taiLaiClicked(ActionEvent event) {
		tamVangList = FXCollections.observableArrayList(tamVangDao.getAll());
		tamVangTable.setItems(tamVangList);
		
		timKiemChoiceBox.setValue(null);
		timKiemTextField.setText(null);
		chiTietVbox.setVisible(false);
	}
	//Danh sách được hiển thị
	private ObservableList<TamVang> tamVangList;
	// Gợi ý thanh tìm kiếm
	private AutoCompletionBinding<String> goiY;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tamVangDao = new TamVangDao();
		tamVangList = FXCollections.observableArrayList(tamVangDao.getAll());
		tamVangTable.setItems(tamVangList);
		
		maPhieuCol.setCellValueFactory(new PropertyValueFactory<>("maTamVang"));
		maNhanKhauCol.setCellValueFactory(new PropertyValueFactory<>("maNhanKhau"));
		noiDiCol.setCellValueFactory(new PropertyValueFactory<>("noiDi"));
		
		chiTietVbox.setVisible(false);
		
		timKiemChoiceBox.getItems().setAll("Mã Phiếu", "Mã Nhân Khẩu");
		timKiemChoiceBox.getSelectionModel().selectedItemProperty().addListener((observableValue, oV, nV) -> {
            if (goiY != null)
            	goiY.dispose();
            if (nV == null)
            	return;
            switch (nV) {
            case "Mã Phiếu" -> goiY = TextFields.bindAutoCompletion(timKiemTextField,
                    tamVangList.stream().map(tamVang -> tamVang.getMaTamVang().toString()).toList());
            
            case "Mã Nhân Khẩu" -> goiY = TextFields.bindAutoCompletion(timKiemTextField,
            		tamVangList.stream().map(tamVang -> tamVang.getMaNhanKhau().toString()).toList());
            }
            
            timKiemTextField.clear();
        });
		
		
		tamVangTable.setOnMouseClicked(EventHandler ->{
			TamVang tamVang = tamVangTable.getSelectionModel().getSelectedItem();
			if (tamVang == null)
				return;
			formTamVang.getChildren().setAll(new FormTamVang(tamVang));
			chiTietVbox.setVisible(true);
		});
	}

}





















