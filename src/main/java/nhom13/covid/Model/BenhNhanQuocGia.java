package nhom13.covid.Model;

import java.sql.Date;

public class BenhNhanQuocGia {

    String hoVaTen;
    String cccd;
    Integer tuoi;
    Boolean gioiTinh;
    String noiNhiem;
    Date tdNhiem;
    Integer maBenhNhan;

    public BenhNhanQuocGia(String hoVaTen, String cccd, Integer tuoi, Boolean gioiTinh, String noiNhiem, Date tdNhiem, Integer maBenhNhan) {
        this.hoVaTen = hoVaTen;
        this.cccd = cccd;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
        this.noiNhiem = noiNhiem;
        this.tdNhiem = tdNhiem;
        this.maBenhNhan = maBenhNhan;
    }

    public BenhNhanQuocGia() {
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

    public Integer getTuoi() {
        return tuoi;
    }

    public void setTuoi(Integer tuoi) {
        this.tuoi = tuoi;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNoiNhiem() {
        return noiNhiem;
    }

    public void setNoiNhiem(String noiNhiem) {
        this.noiNhiem = noiNhiem;
    }

    public Date getTdNhiem() {
        return tdNhiem;
    }

    public void setTdNhiem(Date tdNhiem) {
        this.tdNhiem = tdNhiem;
    }

    public Integer getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(Integer maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }
}
