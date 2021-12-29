package nhom13.covid.Model;

import java.sql.Date;

public class ThayDoiChuHo {
    Integer maThayDoiChuHo;
    Integer maChuHoCu;
    Integer maChuHoMoi;
    Date ngayThayDoi;
    String lyDo;

    public ThayDoiChuHo(Integer maThayDoiChuHo, Integer maChuHoCu, Integer maChuHoMoi, Date ngayThayDoi, String lyDo) {
        this.maThayDoiChuHo = maThayDoiChuHo;
        this.maChuHoCu = maChuHoCu;
        this.maChuHoMoi = maChuHoMoi;
        this.ngayThayDoi = ngayThayDoi;
        this.lyDo = lyDo;
    }

    public ThayDoiChuHo() {
    }

    public Integer getMaThayDoiChuHo() {
        return maThayDoiChuHo;
    }

    public void setMaThayDoiChuHo(Integer maThayDoiChuHo) {
        this.maThayDoiChuHo = maThayDoiChuHo;
    }

    public Integer getMaChuHoCu() {
        return maChuHoCu;
    }

    public void setMaChuHoCu(Integer maChuHoCu) {
        this.maChuHoCu = maChuHoCu;
    }

    public Integer getMaChuHoMoi() {
        return maChuHoMoi;
    }

    public void setMaChuHoMoi(Integer maChuHoMoi) {
        this.maChuHoMoi = maChuHoMoi;
    }

    public Date getNgayThayDoi() {
        return ngayThayDoi;
    }

    public void setNgayThayDoi(Date ngayThayDoi) {
        this.ngayThayDoi = ngayThayDoi;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }
}
