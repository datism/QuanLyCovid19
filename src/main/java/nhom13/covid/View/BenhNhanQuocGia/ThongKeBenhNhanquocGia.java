package nhom13.covid.View.BenhNhanQuocGia;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import nhom13.covid.Dao.BenhNhanQuocGiaDao;
import nhom13.covid.Model.BenhNhanQuocGia;

import java.net.URL;
import java.time.YearMonth;
import java.util.*;

public class ThongKeBenhNhanquocGia implements Initializable {
    @FXML
    private BarChart<Integer, String> thangBarChart;

    @FXML
    private BarChart<String, Integer> tuoiBarChart;

    private BenhNhanQuocGiaDao  benhNhanQuocGiaDao = new BenhNhanQuocGiaDao();

    private List<BenhNhanQuocGia> list;

    public void createCharttuoi() {
        int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0, g = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTuoi() < 10) {
                a++;
            } else if (list.get(i).getTuoi() >= 10 && list.get(i).getTuoi() < 20) {
                b++;
            } else if (list.get(i).getTuoi() >= 20 && list.get(i).getTuoi() < 30) {
                c++;
            } else if (list.get(i).getTuoi() >= 30 && list.get(i).getTuoi() < 40) {
                d++;
            } else if (list.get(i).getTuoi() >= 40 && list.get(i).getTuoi() < 50) {
                e++;
            } else if (list.get(i).getTuoi() >= 50 && list.get(i).getTuoi() < 60) {
                f++;
            } else {
                g++;
            }
        }

        XYChart.Series<String, Integer> dataSeries = new XYChart.Series<>();

        dataSeries.setName("Số lượng");
        dataSeries.getData().add(new XYChart.Data<>("Dưới 10", a));
        dataSeries.getData().add(new XYChart.Data<>("10 - 20", b));
        dataSeries.getData().add(new XYChart.Data<>("20 - 30", c));
        dataSeries.getData().add(new XYChart.Data<>("30 - 40", d));
        dataSeries.getData().add(new XYChart.Data<>("40 - 50", e));
        dataSeries.getData().add(new XYChart.Data<>("50 - 60", f));
        dataSeries.getData().add(new XYChart.Data<>("Trên 60 tuổi", g));

        tuoiBarChart.getXAxis().setLabel("Độ tuổi");

        tuoiBarChart.getData().add(dataSeries);
    }

    public void creatChartCaNhiem() {
        Map<YearMonth, Integer> map = new TreeMap<>();
        for (BenhNhanQuocGia benhNhan: list) {
            YearMonth yearMonth = YearMonth.from(benhNhan.getTdNhiem().toLocalDate());
            if (map.containsKey(yearMonth))
                map.put(yearMonth, map.get(yearMonth) + 1);
            else map.put(yearMonth, 1);
        }

        XYChart.Series<Integer, String> series = new XYChart.Series<>();

        map.forEach((key, value) -> {
            series.getData().add(new XYChart.Data<>(value, key.toString()));
        });

        thangBarChart.getData().add(series);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        list = benhNhanQuocGiaDao.getAll();
        creatChartCaNhiem();
        createCharttuoi();
    }
}
