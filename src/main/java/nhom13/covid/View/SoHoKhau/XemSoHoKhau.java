package nhom13.covid.View.SoHoKhau;

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
import nhom13.covid.Dao.SoHoKhauDao;
import nhom13.covid.Model.SoHoKhau;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Stream;

public class XemSoHoKhau implements Initializable {
    private SoHoKhauDao soHoKhauDao;
    private ObservableList<SoHoKhau> soHoKhauList;

    @FXML
    private TableView<SoHoKhau> soHoKhauTableView;

    @FXML
    private TableColumn<SoHoKhau, String> maHoKhauCol;

    @FXML
    private TableColumn<SoHoKhau, String> soNhaCol;

    @FXML
    private TableColumn<SoHoKhau, String> duongCol;

    @FXML
    private TableColumn<SoHoKhau, String> tenChuHoCol;

    @FXML
    private TableColumn<SoHoKhau, String> ngayCapCol;

    @FXML
    private ChoiceBox<String> timKiemBox;

    @FXML
    private TextField timKiemTextField;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        soHoKhauDao = new SoHoKhauDao();
        soHoKhauList = FXCollections.observableArrayList(soHoKhauDao.getAll());
        soHoKhauTableView.setItems(soHoKhauList);

        maHoKhauCol.setCellValueFactory(new PropertyValueFactory<>("maHoKhau"));
        soNhaCol.setCellValueFactory(new PropertyValueFactory<>("soNha"));
        tenChuHoCol.setCellValueFactory(new PropertyValueFactory<>("chuHo"));
        ngayCapCol.setCellValueFactory(new PropertyValueFactory<>("ngayCap"));

        timKiemBox.getItems().setAll("Mã hộ khẩu", "Số nhà", "Đường", "Tên chủ hộ");
    }

    @FXML
    public void timKiemClicked (ActionEvent event) {
//        Lấy thông tin cần tìm kiếm
        String timKiem = timKiemTextField.getText();
//        Lấy thuộc tính tìm kiếm
        String timKiemTheo = timKiemBox.getValue();

        if (timKiemTheo == null) {
            return;
        }
        Stream<SoHoKhau> soHoKhauStream = soHoKhauDao.getAll().stream();

//        Truy vấn db
        switch (timKiemTheo) {
            case "Tên chủ hộ" -> soHoKhauStream.filter(soHoKhau -> timKiem.equals(soHoKhau.getChuHo()));
            case "Số nhà" -> soHoKhauStream.filter(soHoKhau -> timKiem.equals(soHoKhau.getSoNha()));
            case "Đường" -> soHoKhauStream.filter(soHoKhau -> timKiem.equals(soHoKhau.getDuongID()));
            case "Mã hộ khẩu" -> soHoKhauStream.filter(soHoKhau -> timKiem.equals(soHoKhau.getMaHoKhau()));
        }

//        Hiển thị kết quả
        soHoKhauList.setAll(soHoKhauStream.toList());
        soHoKhauTableView.setItems(soHoKhauList);
    }

}
