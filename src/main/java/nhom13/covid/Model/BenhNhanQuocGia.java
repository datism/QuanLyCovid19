package nhom13.covid.Model;

import java.sql.Date;

/**
 * @author ddat
 */
public class BenhNhanQuocGia {
    String hoVaTen;
    String cccd;
    int tuoi;
    String noiNhiem;
    Date tdNhiem;
    int maBenhNhan;

    public BenhNhanQuocGia(String hoVaTen, String cccd, int tuoi, String noiNhiem, Date tdNhiem, int maBenhNhan) {
        this.hoVaTen = hoVaTen;
        this.cccd = cccd;
        this.tuoi = tuoi;
        this.noiNhiem = noiNhiem;
        this.tdNhiem = tdNhiem;
        this.maBenhNhan = maBenhNhan;
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

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
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

    public int getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(int maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }
}
