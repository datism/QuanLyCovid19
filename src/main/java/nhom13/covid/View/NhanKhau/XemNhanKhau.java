package nhom13.covid.View.NhanKhau;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Duration;
import nhom13.covid.Dao.NhanKhauDao;
import nhom13.covid.Model.NhanKhau;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class XemNhanKhau implements Initializable {
    @FXML
    private TableColumn<NhanKhau, String> Manhankhau;
    @FXML
    private TableColumn<NhanKhau, String> Hovaten;
    @FXML
    private TableColumn<NhanKhau, String> CCCD;
    @FXML
    private TableColumn<NhanKhau, Date> Ngaysinh;
    @FXML
    private TableColumn<NhanKhau, String> Noisinh;
    @FXML
    private TableColumn<NhanKhau, String> Dantoc;
    @FXML
    private TableColumn<NhanKhau, String> Tongiao;
    @FXML
    private TableColumn<NhanKhau, String> Gioitinh;
    @FXML
    private TableColumn<NhanKhau, String> Trinhdovanhoa;
    @FXML
    private TableColumn<NhanKhau, Date> Ngaydangkithuongtru;
    @FXML
    private TableColumn<NhanKhau, String> Nghenghiep;
    @FXML
    private TableColumn<NhanKhau, String> Noilamviec;
    @FXML
    private TableColumn<NhanKhau, Integer> Mahokhau;
    @FXML
    private TableColumn<NhanKhau, String> Quanhevoichuho;
    @FXML
    private TableColumn<NhanKhau, String> Ghichu;
    @FXML
    private TextField searchText;
    @FXML
    private TableView<NhanKhau> table;


    private final NhanKhauDao nhankhauDao = new NhanKhauDao();
    private  ObservableList<NhanKhau> list1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        list1 = FXCollections.observableArrayList(nhankhauDao.getAll());
        table.setItems(list1);

        Manhankhau.setCellValueFactory(new PropertyValueFactory<>("maNhanKhau"));
        Hovaten.setCellValueFactory(new PropertyValueFactory<>("hoVaTen"));
        CCCD.setCellValueFactory(new PropertyValueFactory<>("cccd"));
        Ngaysinh.setCellValueFactory(new PropertyValueFactory<>("ngaySinh"));
        Noisinh.setCellValueFactory(new PropertyValueFactory<>("noiSinh"));
        Dantoc.setCellValueFactory(new PropertyValueFactory<>("danToc"));
        Tongiao.setCellValueFactory(new PropertyValueFactory<>("tonGiao"));


        Gioitinh.setCellValueFactory(data -> {
            NhanKhau nhankhau = data.getValue();
            SimpleStringProperty Gioitinh = new SimpleStringProperty();
            if (nhankhau.getGioiTinh())
                Gioitinh.setValue("Nam");
            else
                Gioitinh.setValue("Nữ");
            return Gioitinh;
        });

        Nghenghiep.setCellValueFactory(new PropertyValueFactory<>("ngheNghiep"));
        Noilamviec.setCellValueFactory(new PropertyValueFactory<>("noiLamViec"));
        Trinhdovanhoa.setCellValueFactory(new PropertyValueFactory<>("trinhDoVH"));
        Ngaydangkithuongtru.setCellValueFactory(new PropertyValueFactory<>("ngayDKThuongTru"));
        Mahokhau.setCellValueFactory(new PropertyValueFactory<>("maHoKhau"));
        Quanhevoichuho.setCellValueFactory(new PropertyValueFactory<>("qhChuHo"));
        Ghichu.setCellValueFactory(new PropertyValueFactory<>("ghiChu"));
    }

    public void search(ActionEvent event) {
        List<NhanKhau> list = nhankhauDao.getAll();
        NhanKhau nhankhau = null;
        List<NhanKhau> listsearch = new ArrayList<>();

        if (searchText.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Error ");
            alert.setHeaderText("Không có nhân khẩu trên");
            alert.setContentText("Vui lòng nhập thông tin!");
            alert.showAndWait();
        }
        String str = searchText.getText().toLowerCase();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getHoVaTen().toLowerCase().contains(str)) {
                listsearch.add(list.get(i));
            }
        }
        if (!listsearch.isEmpty()) {
            ObservableList<NhanKhau> list2 = FXCollections.observableArrayList(listsearch);
            table.setItems(list2);
            list.clear();
        } else {
            if (isStringInteger(searchText.getText())) {
                Alert alert = new Alert(Alert.AlertType.ERROR);

                alert.setTitle("Error ");
                alert.setHeaderText("Không có nhân khẩu trên");
                alert.setContentText("Vui lòng kiểm tra laị thông tin!");
                alert.showAndWait();
            } else {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getMaNhanKhau() == Integer.parseInt(searchText.getText())) {
                        nhankhau = list.get(i);
                    }
                }
                if (nhankhau == null) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);

                    alert.setTitle("Error ");
                    alert.setHeaderText("Không có nhân khẩu trên");
                    alert.setContentText("Kiểm tra lại mã nhân khẩu!");
                    alert.showAndWait();
                } else {
                    ObservableList<NhanKhau> list2
                            = FXCollections.observableArrayList(nhankhau);
                    table.setItems(list2);
                }
            }
        }
        searchText.clear();
    }

    public void back(ActionEvent event) {
        NhanKhauDao dao = new NhanKhauDao();
        ObservableList<NhanKhau> list2
                = FXCollections.observableArrayList(dao.getAll());
        table.setItems(list2);
    }

    public static boolean isStringInteger(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    public void Suanhankhau(ActionEvent event)throws Exception{
        NhanKhau nhanKhau = table.getSelectionModel().getSelectedItem();

        if (nhanKhau == null) {
            Notifications.create()
                    .title("Lỗi!")
                    .text("Chọn nhân khẩu cần sửa")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
            return;
        }

        try {
            Stage stage = new Stage();

            FXMLLoader loader = new  FXMLLoader(getClass().getResource("SuaNhanKhau.fxml"));
            SuaNhanKhau suaNhanKhau = new SuaNhanKhau(nhanKhau);
            loader.setController(suaNhanKhau);

            Parent root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            stage.setOnCloseRequest(windowEvent -> {
                this.list1.setAll(nhankhauDao.getAll());
                table.refresh();
            });
        } catch (IOException e) {
            Notifications.create()
                    .title("Lỗi!")
                    .text("Lỗi hệ thống")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
        }
    }
}








