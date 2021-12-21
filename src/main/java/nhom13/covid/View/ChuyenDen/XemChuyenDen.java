package nhom13.covid.View.ChuyenDen;

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
import nhom13.covid.Model.ChuyenDen;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;
import org.controlsfx.validation.ValidationSupport;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Stream;

public class XemChuyenDen implements Initializable {
    private ChuyenDenDao chuyenDenDao;

    @FXML
    private TableView<ChuyenDen> chuyenDenTable;

    @FXML
    private TableColumn<ChuyenDen, Integer> maPhieuCol;

    @FXML
    private TableColumn<ChuyenDen, Integer> maNhanKhauCol;

    @FXML
    private TableColumn<ChuyenDen, String> noiChuyenDiCol;

    @FXML
    private TableColumn<ChuyenDen, String> lyDoCol;

    @FXML
    private VBox chiTietVbox;

    @FXML
    private GridPane formChuyenDen;

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

        Stream<ChuyenDen> stream = chuyenDenDao.getAll().stream();

        //Truy vấn db lấy kết quả
        switch (timKiemTheo) {
            case "Mã Phiếu" -> stream = stream.filter(chuyenDen -> Integer.valueOf(timKiem).equals(chuyenDen.getMaChuyenDen()));
            case "Mã nhân khẩu" -> stream = stream.filter(chuyenDen -> Integer.valueOf(timKiem).equals(chuyenDen.getMaNhanKhau()));

        }

        //Hiển thị kết quả
        chuyenDenList.setAll(stream.toList());
        chuyenDenTable.setItems(chuyenDenList);
    }

    @FXML
    void suaButtonClicked(ActionEvent event) {
        //Form test covid
        FormChuyenDen form = (FormChuyenDen) formChuyenDen.getChildren().get(0);

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
        ChuyenDen chuyenDen = new ChuyenDen();
        chuyenDen.setMaChuyenDen(form.getMaPhieu());
        chuyenDen.setMaNhanKhau(form.getMaNhanKhau());
        chuyenDen.setNoiChuyenDi(form.getNoiChuyenDi());
        chuyenDen.setNgayChuyen(form.getNgayChuyenDen());
        chuyenDen.setLyDo(form.getLyDo());

        //Cập nhật db
        chuyenDenDao.update(chuyenDen);

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
        FormChuyenDen form = (FormChuyenDen) formChuyenDen.getChildren().get(0);
        //Xóa trên db
        chuyenDenDao.delete(form.getMaPhieu());
        //Reset
        taiLaiClicked(null);
    }

    @FXML
    void taiLaiClicked(ActionEvent event) {
        chuyenDenList = FXCollections.observableArrayList(chuyenDenDao.getAll());
        chuyenDenTable.setItems(chuyenDenList);

        timKiemChoiceBox.setValue(null);
        timKiemTextField.setText(null);
        chiTietVbox.setVisible(false);
    }

    //Danh sách test covid được hiển thị
    private ObservableList<ChuyenDen> chuyenDenList;
    //Gợi ý cho thanh tìm kiếm
    private AutoCompletionBinding<String> goiY;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chuyenDenDao = new ChuyenDenDao();
        chuyenDenList = FXCollections.observableArrayList(chuyenDenDao.getAll());
        chuyenDenTable.setItems(chuyenDenList);

        maPhieuCol.setCellValueFactory(new PropertyValueFactory<>("maChuyenDen"));
        maNhanKhauCol.setCellValueFactory(new PropertyValueFactory<>("maNhanKhau"));
        noiChuyenDiCol.setCellValueFactory(new PropertyValueFactory<>("noiChuyenDi"));
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
                        chuyenDenList.stream().map(chuyenDen -> chuyenDen.getMaNhanKhau().toString()).toList());


                case "Mã nhân khẩu" -> goiY = TextFields.bindAutoCompletion(timKiemTextField,
                        chuyenDenList.stream().map(chuyenDen -> chuyenDen.getMaNhanKhau().toString()).toList());


            }

            timKiemTextField.clear();
        });

        chuyenDenTable.setOnMouseClicked(event -> {
            ChuyenDen chuyenDen = chuyenDenTable.getSelectionModel().getSelectedItem();
            if (chuyenDen == null)
                return;
            formChuyenDen.getChildren().setAll(new FormChuyenDen(chuyenDen));
            chiTietVbox.setVisible(true);
        });
    }

}

