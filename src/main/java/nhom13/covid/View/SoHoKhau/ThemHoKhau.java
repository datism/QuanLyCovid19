package nhom13.covid.View.SoHoKhau;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import nhom13.covid.Dao.NhanKhauDao;
import nhom13.covid.Dao.SoHoKhauDao;
import nhom13.covid.Model.NhanKhau;
import nhom13.covid.Model.SoHoKhau;
import org.controlsfx.control.Notifications;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class ThemHoKhau implements Initializable {

//    Thông tin hộ khẩu
    @FXML
    private TextField maNhanKhau;

    @FXML
    private TextField hoVaTen;

    @FXML
    private TextField soNha;

    @FXML
    private TextField soDuong;


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


    private NhanKhauDao nhanKhauDao;
    private SoHoKhauDao soHoKhauDao;
    private ObservableList<NhanKhau> nhanKhauList1, nhanKhauList2;

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
    public void themButtunClicked (ActionEvent event) {
        if (maNhanKhau.getText() == null ) {
            Notifications.create()
                    .title("Lỗi!!")
                    .text("Vui lòng kiểm tra lại thông tin")
                    .position(Pos.CENTER)
                    .showError();
            return;
        }
        String maChuHo = String.valueOf(nhanKhauDao.getByMaNhanKhau(Integer.parseInt(maNhanKhau.getText())));
        if (maChuHo == null) {
            Notifications.create()
                    .title("Lỗi!!")
                    .text("Mã nhân khẩu không hợp lệ")
                    .position(Pos.CENTER)
                    .showError();
            return;
        }
        else {
            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            nhanKhauDao.updateQuanHe(Integer.parseInt(maChuHo), "Chủ hộ");
            SoHoKhau soHoKhau = new SoHoKhau();
            soHoKhau.setSoNha(soNha.getText());
            soHoKhau.setDuongID(Integer.valueOf(soDuong.getText()));
            soHoKhau.setChuHo(hoVaTen.getText());
            soHoKhau.setNgayCap(Date.valueOf(localDateTime.format(dateTimeFormatter)));

            soHoKhauDao.insert(soHoKhau);

            for (int i=0; i< nhanKhauList2.size(); i++) {
                nhanKhauDao.updateHoKhau(nhanKhauList2.get(i).getMaNhanKhau(), nhanKhauList2.get(i).getMaHoKhau());
            }
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nhanKhauDao = new NhanKhauDao();
        nhanKhauList1 = FXCollections.observableArrayList(nhanKhauDao.getAll());
        nhanKhauList2 = FXCollections.observableArrayList();
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
        maNhanKhau1.setCellValueFactory(new PropertyValueFactory<>("maHoKhau"));

        maNhanKhau2.setCellValueFactory(new PropertyValueFactory<>("maNhanKhau"));
        hovaten2.setCellValueFactory(new PropertyValueFactory<>("hoVaTen"));
        cccd2.setCellValueFactory(new PropertyValueFactory<>("cccd"));
        ngaySinh2.setCellValueFactory(new PropertyValueFactory<>("ngaySinh"));
        noiSinh2.setCellValueFactory(new PropertyValueFactory<>("noiSinh"));
        tonGiao2.setCellValueFactory(new PropertyValueFactory<>("tonGiao"));
        gioiTinh2.setCellValueFactory(new PropertyValueFactory<>("gioiTinh"));
        danToc2.setCellValueFactory(new PropertyValueFactory<>("danToc"));
        noiDKThuongTru2.setCellValueFactory(new PropertyValueFactory<>("ngayDKThuongTru"));
        maNhanKhau2.setCellValueFactory(new PropertyValueFactory<>("maHoKhau"));

        nhanKhauTableView1.refresh();
        nhanKhauTableView2.refresh();
        clear();
    }
}
