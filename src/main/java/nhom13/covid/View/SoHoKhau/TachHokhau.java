package nhom13.covid.View.SoHoKhau;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import nhom13.covid.Dao.NhanKhauDao;
import nhom13.covid.Dao.SoHoKhauDao;
import nhom13.covid.Model.NhanKhau;
import org.controlsfx.control.Notifications;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Stream;

public class TachHokhau implements Initializable {


    @FXML
    private TextField maNhanKhau;

    @FXML
    private TextField hoVaTen;

    @FXML
    private TextField soNha;

    @FXML
    private TextField soDuong;

    @FXML
    private TextField maHoKhau;


    //    Thông tin nhân khẩu
    @FXML
    private TableView<NhanKhau> nhanKhauTableView1;

    @FXML
    private TableColumn<NhanKhau, String> maNhanKhau1;

    @FXML
    private TableColumn<NhanKhau, String> hovaten1;

    @FXML
    private TableColumn<NhanKhau, String> cccd1;

    @FXML
    private TableColumn<NhanKhau, String> ngaySinh1;

    @FXML
    private TableColumn<NhanKhau, String> noiSinh1;

    @FXML
    private TableColumn<NhanKhau, String> tonGiao1;

    @FXML
    private TableColumn<NhanKhau, String> gioiTinh1;

    @FXML
    private TableColumn<NhanKhau, String> danToc1;

    @FXML
    private TableColumn<NhanKhau, String> noiDKThuongTru1;

    @FXML
    private TableColumn<NhanKhau, String> maHoKhau1;

    @FXML
    private TableView<NhanKhau> nhanKhauTableView11;

    @FXML
    private TableColumn<NhanKhau, String> maNhanKhau11;

    @FXML
    private TableColumn<NhanKhau, String> hovaten11;

    @FXML
    private TableColumn<NhanKhau, String> cccd11;

    @FXML
    private TableColumn<NhanKhau, String> ngaySinh11;

    @FXML
    private TableColumn<NhanKhau, String> noiSinh11;

    @FXML
    private TableColumn<NhanKhau, String> tonGiao11;

    @FXML
    private TableColumn<NhanKhau, String> gioiTinh11;

    @FXML
    private TableColumn<NhanKhau, String> danToc11;

    @FXML
    private TableColumn<NhanKhau, String> noiDKThuongTru11;

    @FXML
    private TableColumn<NhanKhau, String> maHoKhau11;

    @FXML
    private TableView<NhanKhau> nhanKhauTableView2;

    @FXML
    private TableColumn<NhanKhau, String> maNhanKhau2;

    @FXML
    private TableColumn<NhanKhau, String> hovaten2;

    @FXML
    private TableColumn<NhanKhau, String> cccd2;

    @FXML
    private TableColumn<NhanKhau, String> ngaySinh2;

    @FXML
    private TableColumn<NhanKhau, String> noiSinh2;

    @FXML
    private TableColumn<NhanKhau, String> tonGiao2;

    @FXML
    private TableColumn<NhanKhau, String> gioiTinh2;

    @FXML
    private TableColumn<NhanKhau, String> danToc2;

    @FXML
    private TableColumn<NhanKhau, String> noiDKThuongTru2;

    @FXML
    private TableColumn<NhanKhau, String> maHoKhau2;

    private NhanKhauDao nhanKhauDao;
    private SoHoKhauDao soHoKhauDao;
    private ObservableList<NhanKhau> nhanKhauList11, nhanKhauList1, nhanKhauList2;

    public void clear() {
        maNhanKhau.clear();
    }

    @FXML
    private void themNhanKhau (ActionEvent event) {
        nhanKhauList2.add(nhanKhauTableView1.getSelectionModel().getSelectedItem());
        nhanKhauList1.remove(nhanKhauTableView1.getSelectionModel().getSelectedItem());
        nhanKhauTableView1.refresh();
        nhanKhauTableView2.refresh();
    }

    @FXML
    private void xoaNhanKhau (ActionEvent event) {
        nhanKhauList2.remove(nhanKhauTableView2.getSelectionModel().getSelectedItem());
        nhanKhauList1.add(nhanKhauTableView2.getSelectionModel().getSelectedItem());
        nhanKhauTableView1.refresh();
        nhanKhauTableView2.refresh();
    }

    @FXML
    private void tachButtonClicked(ActionEvent event) {
        Stream<NhanKhau> stream = nhanKhauDao.getByMaHoKhau(Integer.parseInt(maHoKhau.getText())).stream();

        nhanKhauList1.setAll(stream.toList());
        nhanKhauTableView1.setItems(nhanKhauList1);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nhanKhauDao = new NhanKhauDao();
        nhanKhauList11 = FXCollections.observableArrayList(nhanKhauDao.getAll());
        nhanKhauList2 = FXCollections.observableArrayList();
        nhanKhauList1 = FXCollections.observableArrayList();
        nhanKhauTableView1.setItems(nhanKhauList1);

        maNhanKhau1.setCellValueFactory(new PropertyValueFactory<>("maNhanKhau"));
        hovaten1.setCellValueFactory(new PropertyValueFactory<>("hoVaTen"));
        cccd1.setCellValueFactory(new PropertyValueFactory<>("cccd"));
        ngaySinh1.setCellValueFactory(new PropertyValueFactory<>("ngaySinh"));
        noiSinh1.setCellValueFactory(new PropertyValueFactory<>("noiSinh"));
        tonGiao1.setCellValueFactory(new PropertyValueFactory<>("tonGiao"));
        gioiTinh1.setCellValueFactory(new PropertyValueFactory<>("gioiTinh"));
        danToc1.setCellValueFactory(new PropertyValueFactory<>("danToc"));
        noiDKThuongTru1.setCellValueFactory(new PropertyValueFactory<>("ngayDKThuongTru"));
        maHoKhau1.setCellValueFactory(new PropertyValueFactory<>("maHoKhau"));

        maNhanKhau2.setCellValueFactory(new PropertyValueFactory<>("maNhanKhau"));
        hovaten2.setCellValueFactory(new PropertyValueFactory<>("hoVaTen"));
        cccd2.setCellValueFactory(new PropertyValueFactory<>("cccd"));
        ngaySinh2.setCellValueFactory(new PropertyValueFactory<>("ngaySinh"));
        noiSinh2.setCellValueFactory(new PropertyValueFactory<>("noiSinh"));
        tonGiao2.setCellValueFactory(new PropertyValueFactory<>("tonGiao"));
        gioiTinh2.setCellValueFactory(new PropertyValueFactory<>("gioiTinh"));
        danToc2.setCellValueFactory(new PropertyValueFactory<>("danToc"));
        noiDKThuongTru2.setCellValueFactory(new PropertyValueFactory<>("ngayDKThuongTru"));
        maHoKhau2.setCellValueFactory(new PropertyValueFactory<>("maHoKhau"));

        nhanKhauTableView1.refresh();
        nhanKhauTableView2.refresh();
        clear();
    }
}
