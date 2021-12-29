package nhom13.covid.Model;

import java.util.Date;

public class NhanKhau {
    Integer maNhanKhau;
    String hoVaTen;
    String cccd;
    Date ngaySinh;
    String noiSinh;
    String danToc;
    String tonGiao;
    Boolean gioiTinh;
    String trinhDoVH;
    String ngheNghiep;
    String noiLamViec;
    Date ngayDKThuongTru;
    String qhChuHo;
    Integer maHoKhau;
    String ghiChu;

    public NhanKhau(Integer maNhanKhau, String hoVaTen, String cccd, Date ngaySinh, String noiSinh, String danToc, String tonGiao, Boolean gioiTinh, String trinhDoVH, String ngheNghiep, String noiLamViec, Date ngayDKThuongTru, String qhChuHo, Integer maHoKhau, String ghiChu) {
        this.maNhanKhau = maNhanKhau;
        this.hoVaTen = hoVaTen;
        this.cccd = cccd;
        this.ngaySinh = ngaySinh;
        this.noiSinh = noiSinh;
        this.danToc = danToc;
        this.tonGiao = tonGiao;
        this.gioiTinh = gioiTinh;
        this.trinhDoVH = trinhDoVH;
        this.ngheNghiep = ngheNghiep;
        this.noiLamViec = noiLamViec;
        this.ngayDKThuongTru = ngayDKThuongTru;
        this.qhChuHo = qhChuHo;
        this.maHoKhau = maHoKhau;
        this.ghiChu = ghiChu;
    }

    public NhanKhau() {
    }

    public Integer getMaNhanKhau() {
        return maNhanKhau;
    }

    public void setMaNhanKhau(Integer maNhanKhau) {
        this.maNhanKhau = maNhanKhau;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getNoiSinh() {
        return noiSinh;
    }

    public void setNoiSinh(String noiSinh) {
        this.noiSinh = noiSinh;
    }

    public String getDanToc() {
        return danToc;
    }

    public void setDanToc(String danToc) {
        this.danToc = danToc;
    }

    public String getTonGiao() {
        return tonGiao;
    }

    public void setTonGiao(String tonGiao) {
        this.tonGiao = tonGiao;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getTrinhDoVH() {
        return trinhDoVH;
    }

    public void setTrinhDoVH(String trinhDoVH) {
        this.trinhDoVH = trinhDoVH;
    }

    public String getNgheNghiep() {
        return ngheNghiep;
    }

    public void setNgheNghiep(String ngheNghiep) {
        this.ngheNghiep = ngheNghiep;
    }

    public String getNoiLamViec() {
        return noiLamViec;
    }

    public void setNoiLamViec(String noiLamViec) {
        this.noiLamViec = noiLamViec;
    }

    public Date getNgayDKThuongTru() {
        return ngayDKThuongTru;
    }

    public void setNgayDKThuongTru(Date ngayDKThuongTru) {
        this.ngayDKThuongTru = ngayDKThuongTru;
    }

    public String getQhChuHo() {
        return qhChuHo;
    }

    public void setQhChuHo(String qhChuHo) {
        this.qhChuHo = qhChuHo;
    }

    public Integer getMaHoKhau() {
        return maHoKhau;
    }

    public void setMaHoKhau(Integer maHoKhau) {
        this.maHoKhau = maHoKhau;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
