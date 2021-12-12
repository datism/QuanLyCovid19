package nhom13.covid.View.KhaiBaoYTe;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import nhom13.covid.Dao.KhaiBaoYTeDao;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ThongKeKhaiBaoYTe implements Initializable {
    @FXML
    private PieChart pieChart;

    private final KhaiBaoYTeDao khaiBaoYTeDao = new KhaiBaoYTeDao();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int sotCount = khaiBaoYTeDao.countByTrieuChung("sốt");
        int hoCount = khaiBaoYTeDao.countByTrieuChung("ho");
        int khoThoCount = khaiBaoYTeDao.countByTrieuChung("khó thở");
        int trieuChungkhacCount = khaiBaoYTeDao.countByTrieuChung("Khác");
        int khongBieuhienCount = khaiBaoYTeDao.countByTrieuChung(null);

        PieChart.Data sot = new PieChart.Data("Sốt", sotCount);
        PieChart.Data ho = new PieChart.Data("Ho", hoCount);
        PieChart.Data khoTho = new PieChart.Data("Khó thở", khoThoCount);
        PieChart.Data trieuChungKhac = new PieChart.Data("Triệu chứng khác", trieuChungkhacCount);
        PieChart.Data khongBieuhien = new PieChart.Data("Không có biểu hiện", khongBieuhienCount);

        pieChart.getData().clear();
        pieChart.getData().addAll(sot, ho, khoTho, trieuChungKhac, khongBieuhien);

        for(PieChart.Data data: pieChart.getData()){
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Triệu chứng");
                alert.setContentText(data.getName() + ": " + (int) data.getPieValue() +" người");
                alert.showAndWait();
            });
        }
    }
}
