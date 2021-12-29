package nhom13.covid.View.TestCovid;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import nhom13.covid.Dao.TestCovidDao;
import nhom13.covid.Model.TestCovid;

import java.net.URL;
import java.sql.Date;
import java.time.Period;
import java.time.YearMonth;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

/**
 * @author trdat
 */
public class ThongkeTestCovid implements Initializable {
    @FXML
    private BarChart<String, Integer> testCovidBar;

    TestCovidDao testCovidDao;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        testCovidDao = new TestCovidDao();
        creatTestCovidBar();
    }

    private void creatTestCovidBar() {
        List<TestCovid> testCovids = testCovidDao.getAll();
        Map<YearMonth, Integer> duongTinhMap = new TreeMap<>();
        Map<YearMonth, Integer> amTinhMap = new TreeMap<>();

        for (TestCovid testCovid: testCovids) {
            YearMonth month = YearMonth.from(testCovid.getNgayTest().toLocalDate());
            if (!duongTinhMap.containsKey(month)) {
                duongTinhMap.put(month, 0);
                amTinhMap.put(month, 0);
            }

            if (testCovid.getKetQua())
                duongTinhMap.put(month, duongTinhMap.get(month) + 1);
            else
                amTinhMap.put(month, amTinhMap.get(month) + 1);

        }

        XYChart.Series<String, Integer> duongTinhSeries = new XYChart.Series<>();
        XYChart.Series<String, Integer> amTinhSeries = new XYChart.Series<>();

        duongTinhSeries.setName("Dương Tính");
        amTinhSeries.setName("Âm Tính");

        duongTinhMap.forEach((key, value) -> {
            duongTinhSeries.getData().add(new XYChart.Data<>(key.toString(), value));
        });

        amTinhMap.forEach((key, value) -> {
            amTinhSeries.getData().add(new XYChart.Data<>(key.toString(), value));
        });

        testCovidBar.getData().setAll(duongTinhSeries, amTinhSeries);
    }

}
