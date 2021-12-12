package nhom13.covid.View.TestCovid;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import nhom13.covid.Dao.TestCovidDao;
import nhom13.covid.Model.TestCovid;

import java.net.URL;
import java.time.YearMonth;
import java.util.*;

/**
 * @author trdat
 */
public class ThongkeTestCovid implements Initializable {
    @FXML
    private BarChart<String, Integer> testCovidBar;

    @FXML
    private PieChart testCovidPie;

    TestCovidDao testCovidDao;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        testCovidDao = new TestCovidDao();
        List<TestCovid> duongTinhList = new ArrayList<>(testCovidDao.getByKetqua(true));

        Map<YearMonth, Integer> noDtMonth = new TreeMap<>();
        for (TestCovid testcovd: duongTinhList) {
            YearMonth key = YearMonth.from(testcovd.getNgayTest().toLocalDate());
            if(noDtMonth.get(key) != null)
                noDtMonth.put(key, noDtMonth.get(key) + 1);
            else
                noDtMonth.put(key, 0);
        }

        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        noDtMonth.forEach((yearMonth, integer) -> {
            series.getData().add(new XYChart.Data<>(yearMonth.toString(), integer));
        });

        testCovidBar.getData().add(series);

        Integer noDuongtinh = testCovidDao.countByKetqua(true);
        Integer noAmtinh = testCovidDao.countByKetqua(false);

        PieChart.Data duongTinhSlice = new PieChart.Data("Dương tính", noDuongtinh);
        PieChart.Data amTinhSlice = new PieChart.Data("Âm tính", noAmtinh);
        PieChart.Data chuaTestSlice = new PieChart.Data("Chưa test", 500 - noAmtinh - noDuongtinh);

        testCovidPie.getData().addAll(duongTinhSlice, amTinhSlice, chuaTestSlice);
    }
}
