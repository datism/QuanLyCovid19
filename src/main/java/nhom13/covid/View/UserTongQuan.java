package nhom13.covid.View;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import nhom13.covid.Dao.BenhNhanQuocGiaDao;
import nhom13.covid.Dao.CachLyDao;
import nhom13.covid.Dao.NhanKhauDao;
import nhom13.covid.Model.Account;
import nhom13.covid.Model.NhanKhau;
import nhom13.covid.Model.UserHolder;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class UserTongQuan implements Initializable {

    @FXML
    private TableColumn<NhanKhau, String> cccdCol;

    @FXML
    private TableColumn<NhanKhau, String> gioiTinhCol;

    @FXML
    private TableColumn<NhanKhau, String> hoVaTenCol;

    @FXML
    private Label maHoKhau;

    @FXML
    private TableColumn<NhanKhau, Integer> maNhanKhauCol;

    @FXML
    private TableColumn<NhanKhau, Date> ngaySInhCol;

    @FXML
    private TableView<NhanKhau> nhanhKhauTable;

    @FXML
    private TableColumn<NhanKhau, String> noiSinhCol;

    @FXML
    private Label numCachLy;

    @FXML
    private Label numQuocGia;

    private Account account;
    private NhanKhauDao nhanKhauDao;
    private CachLyDao cachLyDao;
    private BenhNhanQuocGiaDao benhNhanQuocGiaDao;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        account = UserHolder.getInstance().getUser();
        nhanKhauDao = new NhanKhauDao();
        cachLyDao = new CachLyDao();
        benhNhanQuocGiaDao = new BenhNhanQuocGiaDao();

        NhanKhau nhanKhau = nhanKhauDao.getByMaNhanKhau(account.getUserName());

        maHoKhau.setText(nhanKhau.getMaHoKhau().toString());
        numCachLy.setText(cachLyDao.countAll().toString());
        numQuocGia.setText(benhNhanQuocGiaDao.countAll().toString());

        ObservableList<NhanKhau> nhanKhaus = FXCollections.observableList(nhanKhauDao.getByMaHoKhau(nhanKhau.getMaHoKhau()));

        maNhanKhauCol.setCellValueFactory(new PropertyValueFactory<>("maNhanKhau"));
        hoVaTenCol.setCellValueFactory(new PropertyValueFactory<>("hoVaTen"));
        cccdCol.setCellValueFactory(new PropertyValueFactory<>("cccd"));
        ngaySInhCol.setCellValueFactory(new PropertyValueFactory<>("ngaySinh"));
        noiSinhCol.setCellValueFactory(new PropertyValueFactory<>("noiSinh"));

        gioiTinhCol.setCellValueFactory(data -> {
            NhanKhau nhankhau = data.getValue();
            SimpleStringProperty Gioitinh = new SimpleStringProperty();
            if (nhankhau.getGioiTinh())
                Gioitinh.setValue("Nam");
            else
                Gioitinh.setValue("Nữ");
            return Gioitinh;
        });

        nhanhKhauTable.setItems(nhanKhaus);
    }

    void initTable() {

    }
}
