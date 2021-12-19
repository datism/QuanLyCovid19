package nhom13.covid.Model;

import java.sql.Date;

public class TamTru {
    Integer maTamTru;
    Integer maHoKhau;
    Integer maNhanKhau;
    String dcThuongTru;
    Date ngayThuongTru;
    Date thoiHan;

    public TamTru(Integer maTamTru, Integer maHoKhau, Integer maNhanKhau, String dcThuongTru, Date ngayThuongTru, Date thoiHan) {
        this.maTamTru = maTamTru;
        this.maHoKhau = maHoKhau;
        this.maNhanKhau = maNhanKhau;
        this.dcThuongTru = dcThuongTru;
        this.ngayThuongTru = ngayThuongTru;
        this.thoiHan = thoiHan;
    }

    public TamTru() {
    }

    public Integer getMaTamTru() {
        return maTamTru;
    }

    public void setMaTamTru(Integer maTamTru) {
        this.maTamTru = maTamTru;
    }

    public Integer getMaHoKhau() {
        return maHoKhau;
    }

    public void setMaHoKhau(Integer maHoKhau) {
        this.maHoKhau = maHoKhau;
    }

    public Integer getMaNhanKhau() {
        return maNhanKhau;
    }

    public void setMaNhanKhau(Integer maNhanKhau) {
        this.maNhanKhau = maNhanKhau;
    }

    public String getDcThuongTru() {
        return dcThuongTru;
    }

    public void setDcThuongTru(String dcThuongTru) {
        this.dcThuongTru = dcThuongTru;
    }

    public Date getNgayThuongTru() {
        return ngayThuongTru;
    }

    public void setNgayThuongTru(Date ngayThuongTru) {
        this.ngayThuongTru = ngayThuongTru;
    }

    public Date getThoiHan() {
        return thoiHan;
    }

    public void setThoiHan(Date thoiHan) {
        this.thoiHan = thoiHan;
    }
}
