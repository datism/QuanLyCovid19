package nhom13.covid.View.CachLy;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import nhom13.covid.Dao.CachLyDao;
import nhom13.covid.Model.CachLy;
import org.controlsfx.control.PopOver;

import java.net.URL;
import java.util.ResourceBundle;

public class ThongKeCachLy implements Initializable {

    @FXML
    private PieChart cachLyPie;

    private CachLyDao cachLyDao;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cachLyDao = new CachLyDao();
        Integer f0Count = cachLyDao.countByMucDo(0);
        Integer f1Count = cachLyDao.countByMucDo(1);
        Integer f2Count = cachLyDao.countByMucDo(2);
        Integer f3Count = cachLyDao.countByMucDo(3);

        PieChart.Data f0 = new PieChart.Data("F0", f0Count);
        PieChart.Data f1 = new PieChart.Data("F1", f1Count);
        PieChart.Data f2 = new PieChart.Data("F2", f2Count);
        PieChart.Data f3 = new PieChart.Data("F3", f3Count);

        cachLyPie.getData().addAll(f0, f1, f2, f3);

        for(PieChart.Data data: cachLyPie.getData()){
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                Label label = new Label(data.getName() + ": " + (int) data.getPieValue() + " người");
                PopOver popOver = new PopOver(label);
                popOver.show(data.getNode());
            });
        }
    }
}
