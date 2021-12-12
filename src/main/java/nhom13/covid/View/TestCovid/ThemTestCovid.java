package nhom13.covid.View.TestCovid;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import nhom13.covid.Dao.TestCovidDao;
import nhom13.covid.Model.TestCovid;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author trdat
 */
public class ThemTestCovid implements Initializable {

    @FXML
    private GridPane formTestCovid;

    @FXML
    void themButtonClicked(ActionEvent event) {
        FormTestCovid form = (FormTestCovid) formTestCovid.getChildren().get(0);

        TestCovid testCovid = new TestCovid();
        testCovid.setHoVaTen(form.getHoVaTen());
        testCovid.setCccd(form.getCanCuocCongDan());
        testCovid.setMaNhanKhau(form.getMaNhanKhau());
        testCovid.setSoDt(form.getSoDienThoai());
        testCovid.setSoLanTest(form.getSoLanTest());
        testCovid.setHinhThucTest(form.getHinhThucTest());
        testCovid.setKetQua(form.getKetQua());
        testCovid.setNgayTest(form.getNgayTest());

        testCovidDao.insert(testCovid);
    }

    TestCovidDao testCovidDao;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        testCovidDao = new TestCovidDao();
        formTestCovid.getChildren().setAll(new FormTestCovid());
    }
}
