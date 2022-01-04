package nhom13.covid.View;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import nhom13.covid.Dao.*;

import java.net.URL;
import java.util.ResourceBundle;

public class ToTruongTongQuan implements Initializable {

    @FXML
    private Label cachLy;

    @FXML
    private Label chuyenDen;

    @FXML
    private Label chuyenDi;

    @FXML
    private Label hoKhau;

    @FXML
    private Label khaiBaoYTe;

    @FXML
    private Label nhanKhau;

    @FXML
    private Label tamTru;

    @FXML
    private Label tamVang;

    @FXML
    private Label testCovid;

    private CachLyDao cachLyDao;
    private ChuyenDenDao chuyenDenDao;
    private ChuyenDiDao chuyenDiDao;
    private KhaiBaoYTeDao khaiBaoYTeDao;
    private NhanKhauDao nhanKhauDao;
    private SoHoKhauDao soHoKhauDao;
    private TamTruDao tamTruDao;
    private TamVangDao tamVangDao;
    private TestCovidDao testCovidDao;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cachLyDao = new CachLyDao();
        chuyenDenDao = new ChuyenDenDao();
        chuyenDiDao = new ChuyenDiDao();
        khaiBaoYTeDao = new KhaiBaoYTeDao();
        nhanKhauDao = new NhanKhauDao();
        soHoKhauDao = new SoHoKhauDao();
        tamTruDao = new TamTruDao();
        tamVangDao = new TamVangDao();
        testCovidDao = new TestCovidDao();

        cachLy.setText(cachLyDao.countAll().toString());
        chuyenDen.setText(chuyenDenDao.countAll().toString());
        chuyenDi.setText(chuyenDiDao.countAll().toString());
        khaiBaoYTe.setText(khaiBaoYTeDao.countAll().toString());
        nhanKhau.setText(nhanKhauDao.countAll().toString());
        hoKhau.setText(soHoKhauDao.countAll().toString());
        tamTru.setText(tamTruDao.countAll().toString());
        tamVang.setText(tamVangDao.countAll().toString());
        testCovid.setText(testCovidDao.countAll().toString());
    }
}
