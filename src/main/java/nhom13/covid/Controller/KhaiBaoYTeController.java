package nhom13.covid.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import nhom13.covid.Dao.KhaiBaoYTeDao;
import nhom13.covid.Model.KhaiBaoYTe;
import java.sql.Date;

public class KhaiBaoYTeController {
    @FXML
    private TextField hoVaTen;
    @FXML
    private TextField cccd;
    @FXML
    private TextField maNhanKhau;
    @FXML
    private TextField soDt;
    @FXML
    private TextField Email;
    @FXML
    private TextField noiDiChuyen;
    @FXML
    private TextField trieuChung;
    @FXML
    private TextField tienSu;
    @FXML
    private Label Error;
    @FXML
    private CheckBox sot;
    @FXML
    private CheckBox ho;
    @FXML
    private CheckBox khoTho;
    @FXML
    private CheckBox dauHong;

    private boolean check() {
        int c=0;
        if(hoVaTen.getText()==null || hoVaTen.getText()==""){
            hoVaTen.getStyleClass().add("error");
            c=c+1;
        }
        if(maNhanKhau.getText()==null || maNhanKhau.getText()==""){
            maNhanKhau.getStyleClass().add("error");
            c=c+1;
        }
        if(soDt.getText()==null || soDt.getText()==""){
            soDt.getStyleClass().add("error");
            c=c+1;
        }
        if(c != 0) {
            Error.setText("Nhập thêm thông tin còn thiếu");
            return false;
        }
        KhaiBaoYTeDao kb = new KhaiBaoYTeDao();
        if(kb.check_Manhankhau(Integer.parseInt(maNhanKhau.getText()))==false) {
            Error.setText("Nhập sai mã nhân khẩu");
        }
        return true;
    }

    public void ten(javafx.scene.input.MouseEvent mouseEvent) {
        Error.setText(null);
        hoVaTen.getStyleClass().remove("error");
    }

    public void ma(javafx.scene.input.MouseEvent mouseEvent) {
        Error.setText(null);
        maNhanKhau.getStyleClass().remove("error");
    }

    public void sdt(javafx.scene.input.MouseEvent mouseEvent) {
        Error.setText(null);
        soDt.getStyleClass().remove("error");
    }

    public void khaiBao(ActionEvent actionEvent) {
        try {
            Error.setText(null);
            if(check()==false) return;

            Date date= new Date(System.currentTimeMillis());
            String TrieuChung = new String();
            if(ho.isSelected()) TrieuChung += "ho;";
            if(sot.isSelected()) TrieuChung += "sốt;";
            if(khoTho.isSelected()) TrieuChung += "khó thở;";
            if(dauHong.isSelected()) TrieuChung += "đau họng;";
            TrieuChung += trieuChung.getText();
            KhaiBaoYTeDao kb = new KhaiBaoYTeDao();
            kb.update(new KhaiBaoYTe(
                    hoVaTen.getText(), cccd.getText(),
                    Integer.parseInt(maNhanKhau.getText()), soDt.getText(),
                    Email.getText(), noiDiChuyen.getText(),
                    TrieuChung, date, tienSu.getText()
            ));

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setHeaderText(null);
            alert.setContentText("Khai báo y tế thành công!");
            alert.showAndWait();
        }
        catch (Exception e) {
            System.out.println("Lỗi khai báo y tế");
        }
    }
}