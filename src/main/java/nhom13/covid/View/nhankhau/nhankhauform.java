package nhom13.covid.View.nhankhau;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import nhom13.covid.Dao.NhanKhauDao;
import nhom13.covid.Model.NhanKhau;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class nhankhauform implements Initializable {
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
    private TableColumn<NhanKhau, Integer> Mahokhau;
    @FXML
    private TableColumn<NhanKhau, String> Quanhevoichuho;
    @FXML
    private TableColumn<NhanKhau, String> Ghichu;
    @FXML
    private TextField searchText;
    @FXML
    private TableView<NhanKhau> table;
    @FXML
    private Button search;


    private final NhanKhauDao NhankhauDao = new NhanKhauDao();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<NhanKhau> list1 = FXCollections.observableArrayList(NhankhauDao.getAll());
        table.setItems(list1);

        Manhankhau.setCellValueFactory(new PropertyValueFactory<>("Hovaten"));
        Hovaten.setCellValueFactory(new PropertyValueFactory<>("Hovaten"));
        CCCD.setCellValueFactory(new PropertyValueFactory<>("CCCD"));
        Ngaysinh.setCellValueFactory(new PropertyValueFactory<>("Ngaysinh"));
        Noisinh.setCellValueFactory(new PropertyValueFactory<>("Noisinh"));
        Dantoc.setCellValueFactory(new PropertyValueFactory<>("Dantoc"));
        Tongiao.setCellValueFactory(new PropertyValueFactory<>("Tongiao"));


        Gioitinh.setCellValueFactory(data -> {
            NhanKhau nhankhau = data.getValue();
            SimpleStringProperty Gioitinh = new SimpleStringProperty();
            if (nhankhau.getGioiTinh())
                Gioitinh.setValue("Nam");
            else
                Gioitinh.setValue("Nữ");
            return Gioitinh;
        });


        Trinhdovanhoa.setCellValueFactory(new PropertyValueFactory<>("Trinhdovanhoa"));
        Ngaydangkithuongtru.setCellValueFactory(new PropertyValueFactory<>("Ngaydangkithuongtru"));
        Mahokhau.setCellValueFactory(new PropertyValueFactory<>("Mahokhau"));
        Quanhevoichuho.setCellValueFactory(new PropertyValueFactory<>("Quanhevoichuho"));
        Ghichu.setCellValueFactory(new PropertyValueFactory<>("Ghichu"));
    }

    public void search(ActionEvent event) {
        List<NhanKhau> list = NhankhauDao.getAll();
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
    @FXML
    Button btn1;
    @FXML
    Button btn2;


    public void switchtTothemnhankhau() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("nhankhau.fxml"));
        Stage window = (Stage) btn1.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    public void switchTosuanhankhau(ActionEvent event)throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("suanhankhau.fxml"));
        Stage window = (Stage) btn2.getScene().getWindow();
        window.setScene(new Scene(root));
    }
}








