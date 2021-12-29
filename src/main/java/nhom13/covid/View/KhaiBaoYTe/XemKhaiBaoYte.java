package nhom13.covid.View.KhaiBaoYTe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import nhom13.covid.Dao.KhaiBaoYTeDao;
import nhom13.covid.Model.KhaiBaoYTe;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class XemKhaiBaoYte implements Initializable {
    @FXML
    private TextField filterField;

    @FXML
    private TableView<KhaiBaoYTe> khaiBaoYTeTableView;


    @FXML
    private TableColumn<KhaiBaoYTe, String> hoTenColumn;

    @FXML
    private TableColumn<KhaiBaoYTe, String> cmtColumn;

    @FXML
    private TableColumn<KhaiBaoYTe, Integer> maNhanKhauColumn;

    @FXML
    private TableColumn<KhaiBaoYTe, String> soDTColumn;

    @FXML
    private TableColumn<KhaiBaoYTe, String> emailColumn;

    @FXML
    private TableColumn<KhaiBaoYTe, String> noiDichuyenColumn;

    @FXML
    private TableColumn<KhaiBaoYTe, String> trieuChungColumn;

    @FXML
    private TableColumn<KhaiBaoYTe, Date> thoiDiemColumn;

    @FXML
    private TableColumn<KhaiBaoYTe, String> tienSuColumn;
    private ObservableList<KhaiBaoYTe> khaiBaoYTeObservableList;
    private KhaiBaoYTeDao khaiBaoYTeDao;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        khaiBaoYTeDao = new KhaiBaoYTeDao();

        khaiBaoYTeObservableList = FXCollections.observableArrayList();
        hoTenColumn.setCellValueFactory(new PropertyValueFactory<KhaiBaoYTe, String>("HoVaTen"));
        cmtColumn.setCellValueFactory(new PropertyValueFactory<KhaiBaoYTe, String>("Cccd"));
        maNhanKhauColumn.setCellValueFactory(new PropertyValueFactory<KhaiBaoYTe, Integer>("MaNhanKhau"));
        soDTColumn.setCellValueFactory(new PropertyValueFactory<KhaiBaoYTe, String>("SoDt"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<KhaiBaoYTe, String>("Email"));
        noiDichuyenColumn.setCellValueFactory(new PropertyValueFactory<KhaiBaoYTe, String>("NoiDiChuyen"));
        trieuChungColumn.setCellValueFactory(new PropertyValueFactory<KhaiBaoYTe, String>("TrieuChung"));
        thoiDiemColumn.setCellValueFactory(new PropertyValueFactory<KhaiBaoYTe, Date>("TdKhaiBao"));
        tienSuColumn.setCellValueFactory(new PropertyValueFactory<KhaiBaoYTe, String>("TienSu"));

        khaiBaoYTeObservableList.setAll(khaiBaoYTeDao.getAll());
        khaiBaoYTeTableView.setItems(khaiBaoYTeObservableList);

        FilteredList<KhaiBaoYTe> filteredData = new FilteredList<>(khaiBaoYTeObservableList, b -> true);
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(khaiBaoYTe -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (khaiBaoYTe.getHoVaTen().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (String.valueOf(khaiBaoYTe.getMaNhanKhau()).contains(lowerCaseFilter)) {
                    return true;
                } else if (khaiBaoYTe.getCccd().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (khaiBaoYTe.getEmail() != null && khaiBaoYTe.getEmail().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (khaiBaoYTe.getNoiDiChuyen() != null && khaiBaoYTe.getNoiDiChuyen().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (khaiBaoYTe.getTrieuChung() != null && khaiBaoYTe.getTrieuChung().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (String.valueOf(khaiBaoYTe.getTdKhaiBao()).contains(lowerCaseFilter))
                    return true;
                else
                    return false;
            });
        });

        SortedList<KhaiBaoYTe> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(khaiBaoYTeTableView.comparatorProperty());
        khaiBaoYTeTableView.setItems(sortedData);
    }
}