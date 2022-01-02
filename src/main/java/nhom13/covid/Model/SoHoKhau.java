package nhom13.covid.Model;

import java.sql.Date;

public class SoHoKhau {
    Integer maHoKhau;
    String soNha;
    Integer duongID;
    Integer chuHo;
    Date ngayCap;

    public SoHoKhau(Integer maHoKhau, String soNha, Integer duongID, Integer chuHo, Date ngayCap) {
        this.maHoKhau = maHoKhau;
        this.soNha = soNha;
        this.duongID = duongID;
        this.chuHo = chuHo;
        this.ngayCap = ngayCap;
    }

    public SoHoKhau() {
    }

    public Integer getMaHoKhau() {
        return maHoKhau;
    }

    public void setMaHoKhau(Integer maHoKhau) {
        this.maHoKhau = maHoKhau;
    }

    public String getSoNha() {
        return soNha;
    }

    public void setSoNha(String soNha) {
        this.soNha = soNha;
    }

    public Integer getDuongID() {
        return duongID;
    }

    public void setDuongID(Integer duongID) {
        this.duongID = duongID;
    }

    public Integer getChuHo() {
        return chuHo;
    }

    public void setChuHo(Integer chuHo) {
        this.chuHo = chuHo;
    }

    public Date getNgayCap() {
        return ngayCap;
    }

    public void setNgayCap(Date ngayCap) {
        this.ngayCap = ngayCap;
    }
}
