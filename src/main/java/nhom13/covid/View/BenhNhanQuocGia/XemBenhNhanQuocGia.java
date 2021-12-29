package nhom13.covid.View.BenhNhanQuocGia;

import java.net.URL;
import java.util.ArrayList;
import java.util.*;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import nhom13.covid.Dao.BenhNhanQuocGiaDao;
import nhom13.covid.Model.BenhNhanQuocGia;
import org.controlsfx.control.Notifications;

public class XemBenhNhanQuocGia implements Initializable {
    @FXML
    private TableColumn<BenhNhanQuocGia, String> hoVaTenColumn;

    @FXML
    private TableColumn<BenhNhanQuocGia, String> cccdColumn;

    @FXML
    private TableColumn<BenhNhanQuocGia, Integer> tuoiColumn;

    @FXML
    private TableColumn<BenhNhanQuocGia, String> gioiTinhColumn;

    @FXML
    private TableColumn<BenhNhanQuocGia, String> noiNhiemColumn;

    @FXML
    private TableColumn<BenhNhanQuocGia, Date> tdNhiemColumn;

    @FXML
    private TableColumn<BenhNhanQuocGia, Integer> maBenhNhanColumn;

    @FXML
    private TableView<BenhNhanQuocGia> table;

    @FXML
    private TextField searchText;

    private final BenhNhanQuocGiaDao benhNhanQuocGiaDao = new BenhNhanQuocGiaDao();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<BenhNhanQuocGia> list1 = FXCollections.observableArrayList(benhNhanQuocGiaDao.getAll());
        table.setItems(list1);

        hoVaTenColumn.setCellValueFactory(new PropertyValueFactory<>("hoVaTen"));
        cccdColumn.setCellValueFactory(new PropertyValueFactory<>("cccd"));

        gioiTinhColumn.setCellValueFactory(data -> {
            BenhNhanQuocGia benhNhanQuocGia = data.getValue();
            SimpleStringProperty gioiTinh = new SimpleStringProperty();
            if (benhNhanQuocGia.getGioiTinh())
                gioiTinh.setValue("Nam");
            else
                gioiTinh.setValue("Nữ");
            return gioiTinh;
        });

        tuoiColumn.setCellValueFactory(new PropertyValueFactory<>("tuoi"));
        noiNhiemColumn.setCellValueFactory(new PropertyValueFactory<>("noiNhiem"));
        tdNhiemColumn.setCellValueFactory(new PropertyValueFactory<>("tdNhiem"));
        maBenhNhanColumn.setCellValueFactory(new PropertyValueFactory<>("maBenhNhan"));
    }

    public void search(ActionEvent event) {
        List<BenhNhanQuocGia> list = benhNhanQuocGiaDao.getAll();
        BenhNhanQuocGia benhnhan = null;
        List<BenhNhanQuocGia> listsearch = new ArrayList<>();

        if (searchText.getText().equals("")){
            Notifications.create()
                    .title("Lỗi input")
                    .text("Không có bệnh nhân trên, mời nhập lại")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
        }
        String str = searchText.getText().toLowerCase();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getHoVaTen().toLowerCase().contains(str)) {
                listsearch.add(list.get(i));
            }
        }

        if (!listsearch.isEmpty()) {
            ObservableList<BenhNhanQuocGia> list2 = FXCollections.observableArrayList(listsearch);
            table.setItems(list2);
            list.clear();
        } else {
            if (!isStringInteger(searchText.getText())) {
                Notifications.create()
                        .title("Lỗi input")
                        .text("Không có bệnh nhân trên, mời nhập lại")
                        .position(Pos.TOP_RIGHT)
                        .hideAfter(Duration.seconds(5))
                        .showError();
            } else {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getMaBenhNhan() == Integer.parseInt(searchText.getText())) {
                        benhnhan = list.get(i);
                    }

                }
                if (benhnhan == null) {
                    Notifications.create()
                            .title("Lỗi input")
                            .text("Không có bệnh nhân trên, mời nhập lại")
                            .position(Pos.TOP_RIGHT)
                            .hideAfter(Duration.seconds(5))
                            .showError();
                } else {
                    ObservableList<BenhNhanQuocGia> list2
                            = FXCollections.observableArrayList(benhnhan);
                    table.setItems(list2);
                }
            }
        }
        searchText.clear();
    }

    public void back(ActionEvent event) {
        BenhNhanQuocGiaDao dao = new BenhNhanQuocGiaDao();
        ObservableList<BenhNhanQuocGia> list2
                = FXCollections.observableArrayList(dao.getAll());
        table.setItems(list2);
    }

    public static boolean isStringInteger(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }
}
