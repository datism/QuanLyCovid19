package nhom13.covid.View;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import nhom13.covid.Dao.*;

import java.net.URL;
import java.util.ResourceBundle;

public class YTeTongQuan implements Initializable {


    @FXML
    private Label cachLy;

    @FXML
    private Label khaiBaoYTe;

    @FXML
    private Label numQuocGia;

    @FXML
    private Label testCovid;

    private TestCovidDao testCovidDao;
    private KhaiBaoYTeDao khaiBaoYTeDao;
    private CachLyDao cachLyDao;
    private BenhNhanQuocGiaDao benhNhanQuocGiaDao;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cachLyDao = new CachLyDao();
        khaiBaoYTeDao = new KhaiBaoYTeDao();
        testCovidDao = new TestCovidDao();
        benhNhanQuocGiaDao = new BenhNhanQuocGiaDao();

        cachLy.setText(cachLyDao.countAll().toString());
        khaiBaoYTe.setText(khaiBaoYTeDao.countAll().toString());
        testCovid.setText(testCovidDao.countAll().toString());
        numQuocGia.setText(benhNhanQuocGiaDao.countAll().toString());
    }
}
