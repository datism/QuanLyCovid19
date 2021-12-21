package nhom13.covid.View.ChuyenDi;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import nhom13.covid.Dao.ChuyenDenDao;
import nhom13.covid.Dao.ChuyenDiDao;
import nhom13.covid.Model.ChuyenDen;
import nhom13.covid.Model.ChuyenDi;
import nhom13.covid.View.ChuyenDen.FormChuyenDen;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;
import org.controlsfx.validation.ValidationSupport;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Stream;

public class XemChuyenDi implements Initializable {
    private ChuyenDiDao chuyenDiDao;

    @FXML
    private TableView<ChuyenDi> chuyenDiTable;

    @FXML
    private TableColumn<ChuyenDi, Integer> maPhieuCol;

    @FXML
    private TableColumn<ChuyenDi, Integer> maNhanKhauCol;

    @FXML
    private TableColumn<ChuyenDi, String> noiChuyenDenCol;

    @FXML
    private TableColumn<ChuyenDi, String> lyDoCol;

    @FXML
    private VBox chiTietVbox;

    @FXML
    private GridPane formChuyenDi;

    @FXML
    private TextField timKiemTextField;

    @FXML
    private ChoiceBox<String> timKiemChoiceBox;


    @FXML
    public void timKiemButtonCLicked(ActionEvent actionEvent) {
        //Lấy kết quả cần tìm kiếm
        String timKiem = timKiemTextField.getText();
        //Lấy thuộc tính cần tìm kiếm theo
        String timKiemTheo = timKiemChoiceBox.getValue();
        if (timKiemTheo == null)
            return;

        Stream<ChuyenDi> stream = chuyenDiDao.getAll().stream();

        //Truy vấn db lấy kết quả
        switch (timKiemTheo) {
            case "Mã Phiếu" -> stream = stream.filter(chuyenDi -> Integer.valueOf(timKiem).equals(chuyenDi.getMaChuyenDi()));
            case "Mã nhân khẩu" -> stream = stream.filter(chuyenDi -> Integer.valueOf(timKiem).equals(chuyenDi.getMaNhanKhau()));

        }

        //Hiển thị kết quả
        chuyenDiList.setAll(stream.toList());
        chuyenDiTable.setItems(chuyenDiList);
    }

    @FXML
    void suaButtonClicked(ActionEvent event) {
        //Form test covid
        FormChuyenDi form = (FormChuyenDi) formChuyenDi.getChildren().get(0);

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


        //Lấy đối tượng được thay đổi
        ChuyenDi chuyenDi = new ChuyenDi();
        chuyenDi.setMaChuyenDi(form.getMaPhieu());
        chuyenDi.setMaNhanKhau(form.getMaNhanKhau());
        chuyenDi.setNoiChuyenDen(form.getNoiChuyenDen());
        chuyenDi.setNgayChuyen(form.getNgayChuyenDi());
        chuyenDi.setLyDo(form.getLyDo());

        //Cập nhật db
        chuyenDiDao.update(chuyenDi);

        Notifications.create()
                .title("Thành công")
                .text("Sửa thông tin xét nghiệm covid thành công")
                .position(Pos.TOP_RIGHT)
                .hideAfter(Duration.seconds(5))
                .showConfirm();

        //reset
        taiLaiClicked(null);
    }

    @FXML
    void xoaButonClicked(ActionEvent event) {
        //Lấy đối tượng
        FormChuyenDi form = (FormChuyenDi) formChuyenDi.getChildren().get(0);
        //Xóa trên db
        chuyenDiDao.delete(form.getMaPhieu());
        //Reset
        taiLaiClicked(null);
    }

    @FXML
    void taiLaiClicked(ActionEvent event) {
        chuyenDiList = FXCollections.observableArrayList(chuyenDiDao.getAll());
        chuyenDiTable.setItems(chuyenDiList);

        timKiemChoiceBox.setValue(null);
        timKiemTextField.setText(null);
        chiTietVbox.setVisible(false);
    }

    //Danh sách test covid được hiển thị
    private ObservableList<ChuyenDi> chuyenDiList;
    //Gợi ý cho thanh tìm kiếm
    private AutoCompletionBinding<String> goiY;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chuyenDiDao = new ChuyenDiDao();
        chuyenDiList = FXCollections.observableArrayList(chuyenDiDao.getAll());
        chuyenDiTable.setItems(chuyenDiList);

        maPhieuCol.setCellValueFactory(new PropertyValueFactory<>("maChuyenDi"));
        maNhanKhauCol.setCellValueFactory(new PropertyValueFactory<>("maNhanKhau"));
        noiChuyenDenCol.setCellValueFactory(new PropertyValueFactory<>("noiChuyenDen"));
        lyDoCol.setCellValueFactory(new PropertyValueFactory<>("lyDo"));

        chiTietVbox.setVisible(false);

        timKiemChoiceBox.getItems().setAll("Mã Phiếu", "Mã Nhân Khẩu");
        timKiemChoiceBox.getSelectionModel().selectedItemProperty().addListener((observableValue, oV, nV) -> {
            //Xóa hết gợi ý
            if (goiY != null)
                goiY.dispose();

            if (nV == null)
                return;

            //Thiết lập gợi ý
            switch (nV) {
                case "Mã Phiếu" -> goiY = TextFields.bindAutoCompletion(timKiemTextField,
                        chuyenDiList.stream().map(chuyenDi -> chuyenDi.getMaNhanKhau().toString()).toList());


                case "Mã nhân khẩu" -> goiY = TextFields.bindAutoCompletion(timKiemTextField,
                        chuyenDiList.stream().map(chuyenDi -> chuyenDi.getMaNhanKhau().toString()).toList());


            }

            timKiemTextField.clear();
        });

        chuyenDiTable.setOnMouseClicked(event -> {
            ChuyenDi chuyenDi = chuyenDiTable.getSelectionModel().getSelectedItem();
            if (chuyenDi == null)
                return;
            formChuyenDi.getChildren().setAll(new FormChuyenDi(chuyenDi));
            chiTietVbox.setVisible(true);
        });
    }

}


