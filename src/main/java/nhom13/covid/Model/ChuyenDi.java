package nhom13.covid.Model;

import java.sql.Date;

public class ChuyenDi {
    Integer maChuyenDi;
    Integer maNhanKhau;
    String noiChuyenDen;
    Date ngayChuyen;
    String lyDo;

    public ChuyenDi(Integer maPhieu, Integer maNhanKhau, String noiChuyenDen, Date ngayChuyen, String lyDo) {
        this.maChuyenDi = maPhieu;
        this.maNhanKhau = maNhanKhau;
        this.noiChuyenDen = noiChuyenDen;
        this.ngayChuyen = ngayChuyen;
        this.lyDo = lyDo;
    }

    public ChuyenDi() {
    }

    public Integer getMaChuyenDi() {
        return maChuyenDi;
    }

    public void setMaChuyenDi(Integer maChuyenDi) {
        this.maChuyenDi = maChuyenDi;
    }

    public Integer getMaNhanKhau() {
        return maNhanKhau;
    }

    public void setMaNhanKhau(Integer maNhanKhau) {
        this.maNhanKhau = maNhanKhau;
    }

    public String getNoiChuyenDen() {
        return noiChuyenDen;
    }

    public void setNoiChuyenDen(String noiChuyenDen) {
        this.noiChuyenDen = noiChuyenDen;
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
