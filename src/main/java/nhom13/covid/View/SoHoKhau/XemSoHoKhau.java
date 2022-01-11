package nhom13.covid.View.SoHoKhau;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import nhom13.covid.Dao.SoHoKhauDao;
import nhom13.covid.Model.SoHoKhau;
import org.controlsfx.control.Notifications;

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
        duongCol.setCellValueFactory(new PropertyValueFactory<>("duongID"));
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

        if (timKiem.equals("")) {
            soHoKhauList.setAll(soHoKhauStream.toList());
            soHoKhauTableView.setItems(soHoKhauList);
            return;
        }

        //        Truy vấn db
        switch (timKiemTheo) {
            case "Tên chủ hộ" -> soHoKhauStream = soHoKhauStream.filter(soHoKhau -> Integer.valueOf(timKiem).equals(soHoKhau.getChuHo()));
            case "Số nhà" -> soHoKhauStream = soHoKhauStream.filter(soHoKhau -> timKiem.equals(soHoKhau.getSoNha()));
            case "Đường" -> soHoKhauStream = soHoKhauStream.filter(soHoKhau -> Integer.valueOf(timKiem).equals(soHoKhau.getDuongID()));
            case "Mã hộ khẩu" -> soHoKhauStream = soHoKhauStream.filter(soHoKhau -> Integer.valueOf(timKiem).equals(soHoKhau.getMaHoKhau()));
        }

        try {
            //        Hiển thị kết quả
            soHoKhauList.setAll(soHoKhauStream.toList());
            soHoKhauTableView.setItems(soHoKhauList);
        } catch (NumberFormatException e) {
            Notifications.create()
                    .title("Lỗi input")
                    .text(timKiemTheo + " phải là số nguyên")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
        }
    }

}
