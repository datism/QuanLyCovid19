package nhom13.covid.View.TamTru;

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
import nhom13.covid.Dao.TamTruDao;
import nhom13.covid.Model.TamTru;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Stream;

public class XemTamTru implements Initializable {
	
	private TamTruDao tamTruDao;
	
	@FXML
	private TableView<TamTru> tamTruTable;
	
	@FXML
	private TableColumn<TamTru, Integer> maPhieuCol;
	
	@FXML
	private TableColumn<TamTru, Integer> maNhanKhauCol;
	
	@FXML
	private TableColumn<TamTru, Integer> maHoKhauCol;
	
	@FXML
	private VBox chiTietVbox;
	
	@FXML
	private GridPane formTamTru;
	
	@FXML
	private TextField timKiemTextField;
	
	@FXML
	private ChoiceBox<String> timKiemChoiceBox;
	
	@FXML
	public void timKiemButtonClicked(ActionEvent event) {
		String timKiem = timKiemTextField.getText();
		String timKiemTheo = timKiemChoiceBox.getValue();
		if (timKiemTheo == null)
			return;
		
		Stream<TamTru> stream =tamTruDao.getAll().stream();
		
		switch (timKiemTheo) {
		case "Mã Phiếu" -> stream = stream.filter(tamTru -> Integer.valueOf(timKiem).equals(tamTru.getMaTamTru()));
        case "Mã Nhân Khẩu" -> stream = stream.filter(tamTru -> Integer.valueOf(timKiem).equals(tamTru.getMaNhanKhau()));
        case "Mã Hộ Khẩu" -> stream = stream.filter(tamTru -> Integer.valueOf(timKiem).equals(tamTru.getMaHoKhau()));
		}
		
		tamTruList.setAll(stream.toList());
		tamTruTable.setItems(tamTruList);
	}
	
	@FXML
	void taiLaiClicked(ActionEvent event) {
		tamTruList = FXCollections.observableArrayList(tamTruDao.getAll());
		tamTruTable.setItems(tamTruList);
		
		timKiemChoiceBox.setValue(null);
		timKiemTextField.setText(null);
		chiTietVbox.setVisible(false);
	}
	
	private ObservableList<TamTru> tamTruList;
	private AutoCompletionBinding<String> goiY;
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tamTruDao = new TamTruDao();
		tamTruList = FXCollections.observableArrayList(tamTruDao.getAll());
		tamTruTable.setItems(tamTruList);
		
		maPhieuCol.setCellValueFactory(new PropertyValueFactory<>("maTamTru"));
		maNhanKhauCol.setCellValueFactory(new PropertyValueFactory<>("maNhanKhau"));
		maHoKhauCol.setCellValueFactory(new PropertyValueFactory<>("maHoKhau"));
		
		chiTietVbox.setVisible(false);
		
		timKiemChoiceBox.getItems().setAll("Mã Phiếu", "Mã Nhân Khẩu", "Mã Hộ Khẩu");
		timKiemChoiceBox.getSelectionModel().selectedItemProperty().addListener((observableValue, oV, nV) -> {
            //Xóa hết gợi ý
            if (goiY != null)
                goiY.dispose();

            if (nV == null)
                return;

            //Thiết lập gợi ý
            switch (nV) {
            case "Mã Phiếu" -> goiY = TextFields.bindAutoCompletion(timKiemTextField,
                    tamTruList.stream().map(tamTru -> tamTru.getMaTamTru().toString()).toList());
            
            case "Mã Nhân Khẩu" -> goiY = TextFields.bindAutoCompletion(timKiemTextField,
            		tamTruList.stream().map(tamTru -> tamTru.getMaNhanKhau().toString()).toList());
            
            case "Mã Hộ Khẩu" -> goiY = TextFields.bindAutoCompletion(timKiemTextField, 
            		tamTruList.stream().map(tamTru -> tamTru.getMaHoKhau().toString()).toList());
            }
            
            timKiemTextField.clear();
          
        });
		
		tamTruTable.setOnMouseClicked(event -> {
			TamTru tamTru = tamTruTable.getSelectionModel().getSelectedItem();
			if (tamTru == null)
				return;
			formTamTru.getChildren().setAll(new FormTamTru(tamTru));
			chiTietVbox.setVisible(true);
		});
	}

}





























