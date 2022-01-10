package nhom13.covid.View.NhanKhau;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.StringConverter;
import nhom13.covid.Model.NhanKhau;
import org.controlsfx.validation.Severity;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

public class FormNhanKhau extends AnchorPane {

    @FXML
    private TextField canCuocCongDan;

    @FXML
    private TextField danToc;

    @FXML
    private TextField ghiChu;

    @FXML
    private ChoiceBox<Boolean> gioiTinh;

    @FXML
    private TextField hoVaTen;

    @FXML
    private TextField maHoKhau;

    @FXML
    private DatePicker ngayDkThuongTru;

    @FXML
    private DatePicker ngaySinh;

    @FXML
    private TextField ngheNghiep;

    @FXML
    private TextField noiLamViec;

    @FXML
    private TextField noiSinh;

    @FXML
    private TextField quanHeChuHo;

    @FXML
    private TextField tonGiao;

    @FXML
    private TextField trinhDoVanHoa;


    private ValidationSupport validate;
    private NhanKhau nhanKhau;

    public FormNhanKhau() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FormNhanKhau.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        initGioiTinh();

        validate = new ValidationSupport();
        validate.registerValidator(hoVaTen, Validator.createEmptyValidator("họ và tên không được bỏ trống"));
        validate.registerValidator(canCuocCongDan, Validator.createRegexValidator("Căn cước công dân chứa 12 chữ số", "\\d{12}", Severity.ERROR));
        validate.registerValidator(ngaySinh, Validator.createEmptyValidator("Phải chọn ngày sinh"));
        validate.registerValidator(ngayDkThuongTru, Validator.createEmptyValidator("Phải chọn ngày đăng ký"));
        validate.registerValidator(gioiTinh, Validator.createEmptyValidator("Phải chọn giới tính"));
        validate.registerValidator(maHoKhau, Validator.createRegexValidator("Mã hộ khẩu phải là số dương (có thể bỏ trống)", "\\d*", Severity.ERROR));
    }

    void initGioiTinh() {
        gioiTinh.getItems().setAll(true, false);
        gioiTinh.setConverter(new StringConverter<Boolean>() {
            @Override
            public String toString(Boolean aBoolean) {
                if(aBoolean == null)
                    return null;
                if(aBoolean)
                    return "Nam";
                else
                 return "Nữ";
            }

            @Override
            public Boolean fromString(String s) {
                if (s.equals("Nam"))
                    return true;
                else if (s.equals("Nữ"))
                    return false;
                return null;
            }
        });
    }

    public NhanKhau getNhanKhau() {
        if (nhanKhau == null)
            nhanKhau = new NhanKhau();

        nhanKhau.setHoVaTen(this.getHoVaTen());
        nhanKhau.setCccd(this.getCanCuocCongDan());
        nhanKhau.setNgaySinh(this.getNgaySinh());
        nhanKhau.setNoiSinh(this.getNoiSinh());
        nhanKhau.setDanToc(this.getDanToc());
        nhanKhau.setTonGiao(this.getTonGiao());
        nhanKhau.setGioiTinh(this.getGioiTinh());
        nhanKhau.setTrinhDoVH(this.getTrinhDoVanHoa());
        nhanKhau.setNgheNghiep(this.getNgheNghiep());
        nhanKhau.setNoiLamViec(this.getNoiLamViec());
        nhanKhau.setNgayDKThuongTru(this.getNgayDkThuongTru());
        nhanKhau.setQhChuHo(this.getQuanHeChuHo());
        nhanKhau.setMaHoKhau(this.getMaHoKhau());
        nhanKhau.setGhiChu(this.getGhiChu());

        return nhanKhau;
    }

    public void setNhanKhau(NhanKhau nhanKhau) {
        this.nhanKhau = nhanKhau;

        this.setHoVaTen(nhanKhau.getHoVaTen());
        this.setCanCuocCongDan(nhanKhau.getCccd());
        this.setNgaySinh(nhanKhau.getNgaySinh());
        this.setNoiSinh(nhanKhau.getNoiSinh());
        this.setDanToc(nhanKhau.getDanToc());
        this.setTonGiao(nhanKhau.getTonGiao());
        this.setGioiTinh(nhanKhau.getGioiTinh());
        this.setTrinhDoVanHoa(nhanKhau.getTrinhDoVH());
        this.setNgheNghiep(nhanKhau.getNgheNghiep());
        this.setNoiLamViec(nhanKhau.getNoiLamViec());
        this.setNgayDkThuongTru(nhanKhau.getNgayDKThuongTru());
        this.setQuanHeChuHo(nhanKhau.getQhChuHo());
        this.setMaHoKhau(nhanKhau.getMaHoKhau());
        this.setGhiChu(nhanKhau.getGhiChu());
    }

    public ValidationSupport getValidate() {
        return validate;
    }

    StringProperty hoVaTenProperty() {
        return hoVaTen.textProperty();
    }

    StringProperty canCuocProperty() {
        return canCuocCongDan.textProperty();
    }

    ObjectProperty<java.time.LocalDate> ngaySinhProperty() {
        return ngaySinh.valueProperty();
    }

    StringProperty noiSinhProperty() {
        return noiSinh.textProperty();
    }

    StringProperty danTocProperty() {
        return danToc.textProperty();
    }

    StringProperty tonGiaoProperty() {
        return tonGiao.textProperty();
    }

    ObjectProperty<Boolean> gioiTinhProperty() {
        return gioiTinh.valueProperty();
    }

    StringProperty trinhDoVHProperty() {
        return trinhDoVanHoa.textProperty();
    }

    StringProperty ngheNghiepProperty() {
        return ngheNghiep.textProperty();
    }

    StringProperty noiLamViecProperty() {
        return noiLamViec.textProperty();
    }

    ObjectProperty<LocalDate> ngayDkThuongTruProperty() {
        return ngayDkThuongTru.valueProperty();
    }

    StringProperty quanHeChuHoProperty() {
        return quanHeChuHo.textProperty();
    }

    StringProperty maHoKhauProperty() {
        return maHoKhau.textProperty();
    }

    StringProperty ghichuProperty() {
        return ghiChu.textProperty();
    }

    public String getCanCuocCongDan() {
        return canCuocProperty().get();
    }

    public void setCanCuocCongDan(String canCuocCongDan) {
        canCuocProperty().setValue(canCuocCongDan);
    }

    public String getDanToc() {
        return danTocProperty().get();
    }

    public void setDanToc(String danToc) {
        danTocProperty().setValue(danToc);
    }

    public String getGhiChu() {
        return ghichuProperty().get();
    }

    public void setGhiChu(String ghiChu) {
        ghichuProperty().setValue(ghiChu);
    }

    public Boolean getGioiTinh() {
        return gioiTinhProperty().get();
    }

    public void setGioiTinh(Boolean gioiTinh) {
        gioiTinhProperty().setValue(gioiTinh);
    }

    public String getHoVaTen() {
        return hoVaTenProperty().get();
    }

    public void setHoVaTen(String hoVaTen) {
        hoVaTenProperty().setValue(hoVaTen);
    }

    public Integer getMaHoKhau() {
        try {
            return Integer.valueOf(maHoKhauProperty().get());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public void setMaHoKhau(Integer maHoKhau) {
        if (maHoKhau != null)
            maHoKhauProperty().setValue(maHoKhau.toString());
        else
            maHoKhauProperty().set(null);
    }

    public Date getNgayDkThuongTru() {
        return Date.valueOf(ngayDkThuongTruProperty().get());
    }

    public void setNgayDkThuongTru(Date ngayDkThuongTru) {
        if (ngayDkThuongTru == null)
            return;
        ngayDkThuongTruProperty().set(ngayDkThuongTru.toLocalDate());
    }

    public Date getNgaySinh() {
        return Date.valueOf(ngaySinhProperty().get());
    }

    public void setNgaySinh(Date ngaySinh) {
        if (ngaySinh == null)
            return;
        ngaySinhProperty().set(ngaySinh.toLocalDate());
    }

    public String getNgheNghiep() {
        return ngheNghiepProperty().get();
    }

    public void setNgheNghiep(String ngheNghiep) {
        ngheNghiepProperty().set(ngheNghiep);
    }

    public String getNoiLamViec() {
        return noiLamViecProperty().get();
    }

    public void setNoiLamViec(String noiLamViec) {
        noiLamViecProperty().set(noiLamViec);
    }

    public String getNoiSinh() {
        return noiSinhProperty().get();
    }

    public void setNoiSinh(String noiSinh) {
        noiSinhProperty().set(noiSinh);
    }

    public String getQuanHeChuHo() {
        return quanHeChuHoProperty().get();
    }

    public void setQuanHeChuHo(String quanHeChuHo) {
        quanHeChuHoProperty().set(quanHeChuHo);
    }

    public String getTonGiao() {
        return tonGiaoProperty().get();
    }

    public void setTonGiao(String tonGiao) {
        tonGiaoProperty().set(tonGiao);
    }

    public String getTrinhDoVanHoa() {
        return trinhDoVHProperty().get();
    }

    public void setTrinhDoVanHoa(String trinhDoVanHoa) {
        trinhDoVHProperty().set(trinhDoVanHoa);
    }
}
