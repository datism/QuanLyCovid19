package nhom13.covid.Model;

import java.sql.Date;

public class TamVang {
    Integer maTamVang;
    Integer maNhanKhau;
    Date ngayTamVang;
    String noiDi;

    public TamVang(Integer maTamVang, Integer maNhanKhau, Date ngayTamVang, String noiDi) {
        this.maTamVang = maTamVang;
        this.maNhanKhau = maNhanKhau;
        this.ngayTamVang = ngayTamVang;
        this.noiDi = noiDi;
    }

    public TamVang() {
    }

    public Integer getMaTamVang() {
        return maTamVang;
    }

    public void setMaTamVang(Integer maTamVang) {
        this.maTamVang = maTamVang;
    }

    public Integer getMaNhanKhau() {
        return maNhanKhau;
    }

    public void setMaNhanKhau(Integer maNhanKhau) {
        this.maNhanKhau = maNhanKhau;
    }

    public Date getNgayTamVang() {
        return ngayTamVang;
    }

    public void setNgayTamVang(Date ngayTamVang) {
        this.ngayTamVang = ngayTamVang;
    }

    public String getNoiDi() {
        return noiDi;
    }

    public void setNoiDi(String noiDi) {
        this.noiDi = noiDi;
    }
}
