package nhom13.covid.Model;

import java.sql.Date;

public class ChuyenDen {
    Integer maChuyenDen;
    Integer maNhanKhau;
    String noiChuyenDi;
    Date ngayChuyen;
    String lyDo;

    public ChuyenDen(Integer maChuyenDen, Integer maNhanKhau, String noiChuyenDi, Date ngayChuyen, String lyDo) {
        this.maChuyenDen = maChuyenDen;
        this.maNhanKhau = maNhanKhau;
        this.noiChuyenDi = noiChuyenDi;
        this.ngayChuyen = ngayChuyen;
        this.lyDo = lyDo;
    }

    public ChuyenDen() {
    }

    public Integer getMaChuyenDen() {
        return maChuyenDen;
    }

    public void setMaChuyenDen(Integer maChuyenDen) {
        this.maChuyenDen = maChuyenDen;
    }

    public Integer getMaNhanKhau() {
        return maNhanKhau;
    }

    public void setMaNhanKhau(Integer maNhanKhau) {
        this.maNhanKhau = maNhanKhau;
    }

    public String getNoiChuyenDi() {
        return noiChuyenDi;
    }

    public void setNoiChuyenDi(String noiChuyenDi) {
        this.noiChuyenDi = noiChuyenDi;
    }

    public Date getNgayChuyen() {
        return ngayChuyen;
    }

    public void setNgayChuyen(Date ngayChuyen) {
        this.ngayChuyen = ngayChuyen;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }
}
