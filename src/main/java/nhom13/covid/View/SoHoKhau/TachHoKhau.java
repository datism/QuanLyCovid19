package nhom13.covid.View.SoHoKhau;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import nhom13.covid.Dao.NhanKhauDao;
import nhom13.covid.Dao.SoHoKhauDao;
import nhom13.covid.Model.NhanKhau;
import nhom13.covid.Model.SoHoKhau;
import org.controlsfx.validation.Severity;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class TachHoKhau extends AnchorPane {
    @FXML
    private TableView<SoHoKhau> hoKhauTable;

    @FXML
    private TableColumn<SoHoKhau, Integer> maHoKhauCol;

    @FXML
    private TableColumn<SoHoKhau, Integer> maChuHoCol;

    @FXML
    private TableColumn<SoHoKhau, String> soNhaCol;

    @FXML
    private TableColumn<NhanKhau, Integer> soDuongCol;

    @FXML
    private TableColumn<SoHoKhau, Date> ngayCapCol;



    @FXML
    private TableView<NhanKhau> nhanKhauTable;

    @FXML
    private TableColumn<NhanKhau, Integer> maNhanKhauCol;

    @FXML
    private TableColumn<NhanKhau, String> hoVaTenCol;

    @FXML
    private TableColumn<NhanKhau, String> canCuocCol;

    @FXML
    private TableColumn<NhanKhau, Date> ngaySinhCol;

    @FXML
    private TableColumn<NhanKhau, String> qhChuHoCol;


    @FXML
    private TextField maChuHoCu;

    @FXML
    private TextField maChuHoMoi;

    @FXML
    private TextField soNhaText;

    @FXML
    private TextField soDuongText;

    @FXML
    private DatePicker ngayCapText;

    private SoHoKhauDao hoKhauDao;
    private NhanKhauDao nhanKhauDao;

    private ObservableList<SoHoKhau> hokhauList;
    private ObservableList<NhanKhau> nhanKhauList;

    private ValidationSupport validation;

    //private PopOver popOver;

    public TachHoKhau() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TachHoKhau.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        hoKhauDao = new SoHoKhauDao();
        nhanKhauDao = new NhanKhauDao();

        validation = new ValidationSupport();

        validation.registerValidator(maChuHoCu, Validator.createRegexValidator("Mã chủ hộ phải là số nguyên dương", "\\d+", Severity.ERROR));
        validation.registerValidator(maChuHoMoi, Validator.createRegexValidator("Mã chủ hộ phải là số nguyên dương", "\\d*", Severity.ERROR));
        validation.registerValidator(soDuongText, Validator.createRegexValidator("Số đường là số nguyên dương", "\\d*", Severity.ERROR));
        validation.registerValidator(soNhaText, Validator.createEmptyValidator("Số nhà không được để trống"));
        validation.registerValidator(ngayCapText, Validator.createEmptyValidator("Ngày cấp không được để trống"));

        //initPopOver();
        initHoKhauTable();
        initNhanKhauTable();
    }

    void initHoKhauTable() {
        hokhauList = FXCollections.observableList(hoKhauDao.getAll());

        maHoKhauCol.setCellValueFactory(new PropertyValueFactory<>("maHoKhau"));
        soNhaCol.setCellValueFactory(new PropertyValueFactory<>("soNha"));
        maChuHoCol.setCellValueFactory(new PropertyValueFactory<>("chuHo"));
        ngayCapCol.setCellValueFactory(new PropertyValueFactory<>("ngayCap"));

        hoKhauTable.setItems(hokhauList);

        hoKhauTable.setOnMouseClicked(event -> {
            SoHoKhau hoKhau = hoKhauTable.getSelectionModel().getSelectedItem();

            nhanKhauList.setAll(nhanKhauDao.getByMaHoKhau(hoKhau.getMaHoKhau()));
            nhanKhauTable.refresh();

            maChuHoMoi.clear();
            maChuHoCu.clear();
        });
    }

    void initNhanKhauTable() {
        nhanKhauList = FXCollections.observableArrayList();

        maNhanKhauCol.setCellValueFactory(new PropertyValueFactory<>("maNhanKhau"));
        hoVaTenCol.setCellValueFactory(new PropertyValueFactory<>("hoVaTen"));
        canCuocCol.setCellValueFactory(new PropertyValueFactory<>("cccd"));
        ngaySinhCol.setCellValueFactory(new PropertyValueFactory<>("ngaySinh"));
        qhChuHoCol.setCellValueFactory(new PropertyValueFactory<>("qhChuHo"));

        nhanKhauTable.setItems(nhanKhauList);

//        nhanKhauTable.setOnMouseClicked(event -> {
//            popOver.show(nhanKhauTable);
//        });
    }

//    void initPopOver() {
//        VBox vBox = new VBox();
//        vBox.setFillWidth(true);
//        vBox.paddingProperty().set(new Insets(2.0, 2.0, 2.0, 2.0));
//        vBox.setSpacing(5.0);
//
//        Button chuHoCuButton = new Button("Chủ hộ cũ");
//        chuHoCuButton.setOnAction(event -> {
//            NhanKhau nhanKhau = nhanKhauTable.getSelectionModel().getSelectedItem();
//
//            if (nhanKhau == null)
//                return;
//
//            maChuHoCu.setText(nhanKhau.getMaNhanKhau().toString());
//        });
//
//        Button chuHoMoiButton = new Button("Chủ hộ mới");
//        chuHoMoiButton.setOnAction(event -> {
//            NhanKhau nhanKhau = nhanKhauTable.getSelectionModel().getSelectedItem();
//
//            if (nhanKhau == null)
//                return;
//
//            maChuHoMoi.setText(nhanKhau.getMaNhanKhau().toString());
//        });
//
//        vBox.getChildren().setAll(chuHoCuButton, chuHoMoiButton);
//
//        popOver = new PopOver(vBox);
//    }

    public ValidationSupport getValidation() {
        return validation;
    }

    StringProperty maChuHoCuProperty() {
        return maChuHoCu.textProperty();
    }

    StringProperty maChuHoMoiProperty() {
        return maChuHoMoi.textProperty();
    }

    StringProperty soNhaProperty() {
        return soNhaText.textProperty();
    }

    StringProperty soDuongProperty() {
        return soDuongText.textProperty();
    }

    ObjectProperty<LocalDate> ngayCapProperty() {
        return ngayCapText.valueProperty();
    }

    public Integer getMaChuHoCu() {
        try {
            return Integer.valueOf(maChuHoCuProperty().get());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public Integer getMaChuHoMoi() {
        try {
            return Integer.valueOf(maChuHoMoiProperty().get());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public String getSoNha() {
        return soNhaProperty().get();
    }

    public Integer getSoDuong() {
        try {
            return Integer.valueOf(soDuongProperty().get());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public Date getNgayCap() {
        return Date.valueOf(ngayCapProperty().get());
    }

    public List<NhanKhau> getNhanKhauList() {
        return nhanKhauList.stream().toList();
    }

    public Integer getMaHoKhauCu() {
        if (nhanKhauList.isEmpty())
            return null;
        return nhanKhauList.get(0).getMaHoKhau();
    }
}
