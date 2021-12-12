package nhom13.covid.View.BenhNhanQuocGia;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import nhom13.covid.Dao.BenhNhanQuocGiaDao;
import nhom13.covid.Model.BenhNhanQuocGia;

import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class ThongKeBenhNhanquocGia implements Initializable {
    @FXML
    private BarChart<String, Integer> ngayBarChar;

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

    public void creatChartngay() {
        Date now = new Date();
        int a[] = new int[10];
        LocalDate dateNow = LocalDate.of(now.getYear(), now.getMonth() + 1, now.getDate());
        for (int i = 0; i < list.size(); i++) {
            LocalDate date = LocalDate.of(list.get(i).getTdNhiem().getYear(),
                    list.get(i).getTdNhiem().getMonth() + 1,
                    list.get(i).getTdNhiem().getDate());
            int count = Period.between(date, dateNow).getDays()
                    + Period.between(date, dateNow).getMonths() * 30
                    + Period.between(date, dateNow).getYears() * 365;

            switch (count) {
                case 0 ->
                        a[0]++;
                case 1 ->
                        a[1]++;
                case 2 ->
                        a[2]++;
                case 3 ->
                        a[3]++;
                case 4 ->
                        a[4]++;
                case 5 ->
                        a[5]++;
                case 6 ->
                        a[6]++;
                case 7 ->
                        a[7]++;
                case 8 ->
                        a[8]++;
                case 9 ->
                        a[9]++;
            }

        }

        XYChart.Series<String, Integer> dataSeries = new XYChart.Series<>();
        dataSeries.setName("Số lượng");

        for (int i = 0; i < 10; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, -i);
            dataSeries.getData().add(new XYChart.Data<>(
                    calendar.getTime().getDate() + "-" + (calendar.getTime().getMonth() + 1), a[i]));
        }

        ngayBarChar.getData().add(dataSeries);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        list = benhNhanQuocGiaDao.getAll();
        creatChartngay();
        createCharttuoi();
    }
}
