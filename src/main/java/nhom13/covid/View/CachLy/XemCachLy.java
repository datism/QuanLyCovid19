package nhom13.covid.View.CachLy;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.StringConverter;
import javafx.util.converter.FormatStringConverter;
import nhom13.covid.Dao.CachLyDao;
import nhom13.covid.Model.CachLy;
import nhom13.covid.Model.TestCovid;
import nhom13.covid.View.TestCovid.FormTestCovid;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.stream.Stream;

public class XemCachLy implements Initializable {
    @FXML
    private TableView<CachLy> cachLyTable;

    @FXML
    private TableColumn<CachLy, String> hoVaTenCol;

    @FXML
    private TableColumn<CachLy, String> maNhanKhauCol;

    @FXML
    private TableColumn<CachLy, String> mucDoCol;

    @FXML
    private TableColumn<CachLy, Integer> benhNhanTxCol;

    @FXML
    private TableColumn<CachLy, Date> tdCachLyCol;

    @FXML
    private TableColumn<CachLy, String> kvCachLyCol;

    @FXML
    private DatePicker tuNgayDatePicker;

    @FXML
    private DatePicker denNgayDatePicker;

    @FXML
    private ChoiceBox<Integer> mucDoChoiceBox;

    @FXML
    private ChoiceBox<String> timKiemChoiceBox;

    @FXML
    private TextField timKiemTextField;

    @FXML
    void locButtonClicked(ActionEvent event) {
        Stream<CachLy> stream = cachLyDao.getAll().stream();

        //Lọc theo cận dưới của ngày
        if (tuNgayDatePicker.getValue() != null) {
            Date tuNgay = Date.valueOf(tuNgayDatePicker.getValue());
            stream = stream.filter(cachLy -> cachLy.getTdCachLy().after(tuNgay));
        }

        //Lọc theo cận trên ngày
        if (denNgayDatePicker.getValue() != null) {
            Date denNgay = Date.valueOf(denNgayDatePicker.getValue());
            stream = stream.filter(cachLy -> cachLy.getTdCachLy().before(denNgay));
        }

        //Lọc theo kết quả xét nghiệm
        if (mucDoChoiceBox.getValue() != null)
            stream = stream.filter(cachLy -> cachLy.getMucDo().equals(mucDoChoiceBox.getValue()));

        //reset lại các thành phần giao diện
        timKiemChoiceBox.setValue(null);
        timKiemTextField.setText(null);

        //Hiển thị kết quả
        cachLyList.setAll(stream.toList());
        cachLyTable.setItems(cachLyList);
    }

    @FXML
    void taiLaiClicked(ActionEvent event) {
        cachLyList = FXCollections.observableArrayList(cachLyDao.getAll());
        cachLyTable.setItems(cachLyList);

        timKiemChoiceBox.setValue(null);
        timKiemTextField.setText(null);

        tuNgayDatePicker.setValue(null);
        denNgayDatePicker.setValue(null);
        mucDoChoiceBox.setValue(null);
    }

    @FXML
    void timKiemButtonCLicked(ActionEvent event) {
        //Lấy kết quả cần tìm kiếm
        String timKiem = timKiemTextField.getText();
        //Lấy thuộc tính cần tìm kiếm theo
        String timKiemTheo = timKiemChoiceBox.getValue();
        if (timKiemTheo == null)
            return;

        Stream<CachLy> stream = cachLyDao.getAll().stream();

        //Truy vấn db lấy kết quả
        switch (timKiemTheo) {
            case "Họ và tên" -> stream = stream.filter(cachLy -> timKiem.equals(cachLy.getHoVaTen()));
            case "Mã nhân khẩu" -> stream = stream.filter(cachLy -> Integer.valueOf(timKiem).equals(cachLy.getMaNhanKhau()));
            case "Bệnh nhân tiếp xúc" -> stream = stream.filter(cachLy -> Integer.valueOf(timKiem).equals(cachLy.getBenhNhanTx()));
            case "Khu vực cách ly" -> stream = stream.filter(testCovid -> timKiem.equals(testCovid.getKvCachLy()));
        }

        //Hiển thị kết quả
        cachLyList.setAll(stream.toList());
        cachLyTable.setItems(cachLyList);
    }

    private CachLyDao cachLyDao;
    //Danh sách được hiển thị
    private ObservableList<CachLy> cachLyList;
    //Gợi ý cho thanh tìm kiếm
    private AutoCompletionBinding<String> goiY;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cachLyDao = new CachLyDao();
        initTable();
        initSearch();
        iniFilter();
    }

    void initTable() {
        cachLyList = FXCollections.observableArrayList(cachLyDao.getAll());
        cachLyTable.setItems(cachLyList);

        hoVaTenCol.setCellValueFactory(new PropertyValueFactory<>("hoVaTen"));
        maNhanKhauCol.setCellValueFactory(new PropertyValueFactory<>("maNhanKhau"));
        mucDoCol.setCellValueFactory(data -> {
            CachLy cachLy = data.getValue();
            return new SimpleStringProperty("F" + cachLy.getMucDo());
        });
        benhNhanTxCol.setCellValueFactory(new PropertyValueFactory<>("benhNhanTx"));
        tdCachLyCol.setCellValueFactory(new PropertyValueFactory<>("tdCachLy"));
        kvCachLyCol.setCellValueFactory(new PropertyValueFactory<>("kvCachLy"));
    }

    void initSearch() {
        timKiemChoiceBox.getItems().setAll("Họ và tên", "Mã nhân khẩu", "Bệnh nhân tiếp xúc", "Khu vực cách ly");

        timKiemChoiceBox.getSelectionModel().selectedItemProperty().addListener((observableValue, oV, nV) -> {
            //Xóa hết gợi ý
            if (goiY != null)
                goiY.dispose();

            if (nV == null)
                return;

            //Thiết lập gợi ý
            switch (nV) {
                case "Họ và tên" -> goiY = TextFields.bindAutoCompletion(timKiemTextField,
                        cachLyList.stream().map(CachLy::getHoVaTen).toList());

                case "Mã nhân khẩu" -> goiY = TextFields.bindAutoCompletion(timKiemTextField,
                        cachLyList.stream().map(cachLy -> cachLy.getMaNhanKhau().toString()).toList());

                case "Bệnh nhân tiếp xúc" -> goiY = TextFields.bindAutoCompletion(timKiemTextField,
                        cachLyList.stream().map(cachLy -> cachLy.getBenhNhanTx().toString()).toList());

                case "Khu vực cách ly" -> goiY = TextFields.bindAutoCompletion(timKiemTextField,
                        cachLyList.stream().map(CachLy::getKvCachLy).toList());
            }

            timKiemTextField.clear();
        });
    }

    void iniFilter() {
        mucDoChoiceBox.getItems().setAll(0, 1, 2, 3);
        mucDoChoiceBox.setConverter(new StringConverter<Integer>() {
            @Override
            public String toString(Integer integer) {
                if (integer == null)
                    return null;
                return "F" + integer;
            }

            @Override
            public Integer fromString(String s) {
                return Integer.valueOf(s.substring(1));
            }
        });
    }
}
