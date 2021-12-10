package nhom13.covid.View.TestCovid;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import nhom13.covid.Dao.TestCovidDao;
import nhom13.covid.Model.TestCovid;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.stream.Stream;

/**
 * @author dd
 */
public class XemTestCovid implements Initializable {
    private TestCovidDao testCovidDao;

    @FXML
    private TableView<TestCovid> testCovidTable;

    @FXML
    private TableColumn<TestCovid, String> hoVaTenCol;

    @FXML
    private TableColumn<TestCovid, String> canCuocCongDanCol;

    @FXML
    private TableColumn<TestCovid, Integer> maNhanKhauCol;

    @FXML
    private TableColumn<TestCovid, String> soDienThoaiCol;

    @FXML
    private VBox chiTietVbox;

    @FXML
    private GridPane formTestCovid;

    @FXML
    private TextField timKiemTextField;

    @FXML
    private ChoiceBox<String> timKiemChoiceBox;

    @FXML
    private DatePicker tuNgayDatePicker;

    @FXML
    private DatePicker denNgayDatePicker;

    @FXML
    private ChoiceBox<String> ketQuaChoiceBox;

    @FXML
    public void timKiemButtonCLicked(ActionEvent actionEvent) {
        //Lấy kết quả cần tìm kiếm
        String timKiem = timKiemTextField.getText();
        //Lấy thuộc tính cần tìm kiếm theo
        String timKiemTheo = timKiemChoiceBox.getValue();
        if (timKiemTheo == null)
            return;

        Stream<TestCovid> stream = testCovidDao.getAll().stream();

        //Truy vấn db lấy kết quả
        switch (timKiemTheo) {
            case "Họ và tên" -> stream = testCovidList.stream()
                    .filter(testCovid -> timKiem.equals(testCovid.getHoVaTen()));
            case "Căn cước công dân" -> stream = testCovidList.stream()
                    .filter(testCovid -> timKiem.equals(testCovid.getCccd()));
            case "Mã nhân khẩu" -> stream = testCovidList.stream()
                    .filter(testCovid -> Integer.valueOf(timKiem).equals(testCovid.getMaNhanKhau()));
            case "Số điện thoại" -> stream = testCovidList.stream()
                    .filter(testCovid -> timKiem.equals(testCovid.getSoDt()));
        }

        //Hiển thị kết quả
        testCovidList.setAll(stream.toList());
        testCovidTable.setItems(testCovidList);
    }

    @FXML
    void locButtonClicked(ActionEvent event) {
        Stream<TestCovid> stream = testCovidDao.getAll().stream();

        //Lọc theo cận dưới của ngày
        if (tuNgayDatePicker.getValue() != null) {
            Date tuNgay = Date.valueOf(tuNgayDatePicker.getValue());
            stream = stream.filter(testCovid -> testCovid.getNgayTest().after(tuNgay));
        }

        //Lọc theo cận trên ngày
        if (denNgayDatePicker.getValue() != null) {
            Date denNgay = Date.valueOf(denNgayDatePicker.getValue());
            stream = stream.filter(testCovid -> testCovid.getNgayTest().before(denNgay));
        }

        //Lọc theo kết quả xét nghiệm
        if (ketQuaChoiceBox.getValue() != null)
            switch (ketQuaChoiceBox.getValue()) {
                case "Dương Tính" -> stream = stream.filter(TestCovid::isKetQua);
                case "Âm Tính" -> stream = stream.filter(testCovid -> !testCovid.isKetQua());
            }

        //reset lại các thành phần giao diện
        timKiemChoiceBox.setValue(null);
        timKiemTextField.setText(null);
        chiTietVbox.setVisible(false);

        //Hiển thị kết quả
        testCovidList.setAll(stream.toList());
        testCovidTable.setItems(testCovidList);
    }

    @FXML
    void suaButtonClicked(ActionEvent event) {
        //Form test covid
        FormTestCovid form = (FormTestCovid) formTestCovid.getChildren().get(0);

        //Lấy đối tượng được thay đổi
        TestCovid testCovid = new TestCovid();
        testCovid.setHoVaTen(form.getHoVaTen());
        testCovid.setCccd(form.getCanCuocCongDan());
        testCovid.setMaNhanKhau(form.getMaNhanKhau());
        testCovid.setSoDt(form.getSoDienThoai());
        testCovid.setSoLanTest(form.getSoLanTest());
        testCovid.setHinhThucTest(form.getHinhThucTest());
        testCovid.setKetQua(form.getKetQua());
        testCovid.setNgayTest(form.getNgayTest());

        //Cập nhật db
        testCovidDao.update(testCovid);

        //reset
        taiLaiClicked(null);
    }

    @FXML
    void xoaButonClicked(ActionEvent event) {
        //Lấy đối tượng
        FormTestCovid form = (FormTestCovid) formTestCovid.getChildren().get(0);
        //Xóa trên db
        testCovidDao.delete(form.getMaNhanKhau());
        //Reset
        taiLaiClicked(null);
    }

    @FXML
    void taiLaiClicked(ActionEvent event) {
       testCovidList = FXCollections.observableArrayList(testCovidDao.getAll());
        testCovidTable.setItems(testCovidList);

        timKiemChoiceBox.setValue(null);
        timKiemTextField.setText(null);

        tuNgayDatePicker.setValue(null);
        denNgayDatePicker.setValue(null);
        ketQuaChoiceBox.setValue(null);

        chiTietVbox.setVisible(false);
    }

    //Danh sách test covid được hiển thị
    private ObservableList<TestCovid> testCovidList;
    //Gợi ý cho thanh tìm kiếm
    private AutoCompletionBinding<String> goiY;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        testCovidDao = new TestCovidDao();
        testCovidList = FXCollections.observableArrayList(testCovidDao.getAll());
        testCovidTable.setItems(testCovidList);

        hoVaTenCol.setCellValueFactory(new PropertyValueFactory("hoVaTen"));
        canCuocCongDanCol.setCellValueFactory(new PropertyValueFactory("cccd"));
        maNhanKhauCol.setCellValueFactory(new PropertyValueFactory("maNhanKhau"));
        soDienThoaiCol.setCellValueFactory(new PropertyValueFactory("soDt"));

        chiTietVbox.setVisible(false);

        timKiemChoiceBox.getItems().setAll("Họ và tên", "Căn cước công dân", "Mã nhân khẩu", "Số điện thoại");
        timKiemChoiceBox.getSelectionModel().selectedItemProperty().addListener((observableValue, oV, nV) -> {
            //Xóa hết gợi ý
            if (goiY != null)
                goiY.dispose();

            if (nV == null)
                return;

            //Thiết lập gợi ý
            switch (nV) {
                case "Họ và tên" -> goiY = TextFields.bindAutoCompletion(timKiemTextField,
                        testCovidList.stream().map(TestCovid::getHoVaTen).toList());

                case "Căn cước công dân" -> goiY = TextFields.bindAutoCompletion(timKiemTextField,
                        testCovidList.stream().map(TestCovid::getCccd).toList());

                case "Mã nhân khẩu" -> goiY = TextFields.bindAutoCompletion(timKiemTextField,
                        testCovidList.stream().map(testCovid -> testCovid.getMaNhanKhau().toString()).toList());

                case "Số điện thoại" -> goiY = TextFields.bindAutoCompletion(timKiemTextField,
                        testCovidList.stream().map(TestCovid::getSoDt).toList());
            }

            timKiemTextField.clear();
        });

        ketQuaChoiceBox.getItems().setAll("Dương Tính", "Âm Tính");

        testCovidTable.setOnMouseClicked(event -> {
            TestCovid testCovid = testCovidTable.getSelectionModel().getSelectedItem();
            if (testCovid == null)
                return;
            formTestCovid.getChildren().setAll(new FormTestCovid(testCovid));
            chiTietVbox.setVisible(true);
        });
    }

}
