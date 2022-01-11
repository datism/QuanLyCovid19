package nhom13.covid.View.SoHoKhau;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import nhom13.covid.Model.NhanKhau;
import org.controlsfx.validation.ValidationSupport;

import java.io.IOException;
import java.util.List;

public class ThemNkVaoHk extends AnchorPane {
    //Thông tin nhân khẩu
    @FXML
    private TableView<NhanKhau> nhanKhauTableView1;

    @FXML
    private TableColumn<NhanKhau, String> maNhanKhau1;

    @FXML
    private TableColumn<NhanKhau, String> hovaten1;

    @FXML
    private TableColumn<NhanKhau, String> cccd1;

    @FXML
    private TableColumn<NhanKhau, String> ngaySinh1;

    @FXML
    private TableView<NhanKhau> nhanKhauTableView2;

    @FXML
    private TableColumn<NhanKhau, String> maNhanKhau2;

    @FXML
    private TableColumn<NhanKhau, String> hovaten2;

    @FXML
    private TableColumn<NhanKhau, String> cccd2;

    @FXML
    private TableColumn<NhanKhau, String> ngaySinh2;

    @FXML
    private TableColumn<NhanKhau, String> qhChuHoMoi;

//    @FXML
//    private TableColumn<NhanKhau, String> qhChuHoCu;

    @FXML
    private Label sourceLabel;


    private ObservableList<NhanKhau> nhanKhauList1, nhanKhauList2;

    @FXML
    private void themNhanKhau (ActionEvent event) {
        NhanKhau nhanKhau = nhanKhauTableView1.getSelectionModel().getSelectedItem();
        if (nhanKhau == null)
            return;
        nhanKhauList2.add(nhanKhau);
        nhanKhauList1.remove(nhanKhau);
        nhanKhauTableView1.refresh();
        nhanKhauTableView2.refresh();
    }

    @FXML
    private void xoaNhanKhau (ActionEvent event) {
        NhanKhau nhanKhau = nhanKhauTableView2.getSelectionModel().getSelectedItem();
        if (nhanKhau == null)
            return;
        nhanKhauList2.remove(nhanKhau);
        nhanKhauList1.add(nhanKhau);
        nhanKhauTableView1.refresh();
        nhanKhauTableView2.refresh();
    }

    private ValidationSupport validation;

    public ThemNkVaoHk() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ThemNkVaoHk.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        nhanKhauList1 = FXCollections.observableArrayList();
        nhanKhauList2 = FXCollections.observableArrayList();
        validation = new ValidationSupport();

        nhanKhauTableView1.setItems(nhanKhauList1);
        nhanKhauTableView2.setItems(nhanKhauList2);

        maNhanKhau1.setCellValueFactory(new PropertyValueFactory<>("maNhanKhau"));
        hovaten1.setCellValueFactory(new PropertyValueFactory<>("hoVaTen"));
        cccd1.setCellValueFactory(new PropertyValueFactory<>("cccd"));
        ngaySinh1.setCellValueFactory(new PropertyValueFactory<>("ngaySinh"));

//        qhChuHoCu.setCellValueFactory(new PropertyValueFactory<>("qhChuHo"));
//        qhChuHoCu.setCellFactory(TextFieldTableCell.forTableColumn());
//        qhChuHoCu.setOnEditCommit(event -> {
//            NhanKhau nhanKhau = event.getTableView().getItems().get(event.getTablePosition().getRow());
//            nhanKhau.setQhChuHo(event.getNewValue());
//        });

        maNhanKhau2.setCellValueFactory(new PropertyValueFactory<>("maNhanKhau"));
        hovaten2.setCellValueFactory(new PropertyValueFactory<>("hoVaTen"));
        cccd2.setCellValueFactory(new PropertyValueFactory<>("cccd"));
        ngaySinh2.setCellValueFactory(new PropertyValueFactory<>("ngaySinh"));

        qhChuHoMoi.setCellValueFactory(new PropertyValueFactory<>("qhChuHo"));
        qhChuHoMoi.setCellFactory(TextFieldTableCell.forTableColumn());
        qhChuHoMoi.setOnEditCommit(event -> {
            NhanKhau nhanKhau = event.getTableView().getItems().get(event.getTablePosition().getRow());
            nhanKhau.setQhChuHo(event.getNewValue());
        });


        nhanKhauTableView1.refresh();
        nhanKhauTableView2.refresh();
    }

    void setSourceList(List<NhanKhau> sourceList) {
        this.nhanKhauList1.setAll(sourceList);
        this.nhanKhauList2.clear();

        this.nhanKhauTableView1.refresh();
        this.nhanKhauTableView2.refresh();
    }

    void setSourceLabel(String text) {
        sourceLabel.setText(text);
    }

    List<NhanKhau> getListNhanKhauMoiThem() {
        return nhanKhauList2.stream().toList();
    }

    List<NhanKhau> getListNhanKhauCu() { return  nhanKhauList1.stream().toList(); }

//    void removeQhChuCu() {
//        this.nhanKhauTableView1.getColumns().remove(qhChuHoCu);
//    }
}
