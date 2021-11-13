package nhom13.covid.Model;

import java.util.Date;

/**
 * @author  ddat
 */
public class KhaiBaoYTe {
    String hoVaTen;
    String cccd;
    int maNhanKhau;
    String soDt;
    String Email;
    String noiDiChuyen;
    String trieuChung;
    Date tdKhaiBao;
    String tienSu;

    public KhaiBaoYTe(String hoVaTen, String cccd, int maNhanKhau, String soDt, String email, String noiDiChuyen, String trieuChung, Date tdKhaiBao, String tienSu) {
        this.hoVaTen = hoVaTen;
        this.cccd = cccd;
        this.maNhanKhau = maNhanKhau;
        this.soDt = soDt;
        Email = email;
        this.noiDiChuyen = noiDiChuyen;
        this.trieuChung = trieuChung;
        this.tdKhaiBao = tdKhaiBao;
        this.tienSu = tienSu;
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

    public int getMaNhanKhau() {
        return maNhanKhau;
    }

    public void setMaNhanKhau(int maNhanKhau) {
        this.maNhanKhau = maNhanKhau;
    }

    public String getSoDt() {
        return soDt;
    }

    public void setSoDt(String soDt) {
        this.soDt = soDt;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getNoiDiChuyen() {
        return noiDiChuyen;
    }

    public void setNoiDiChuyen(String noiDiChuyen) {
        this.noiDiChuyen = noiDiChuyen;
    }

    public String getTrieuChung() {
        return trieuChung;
    }

    public void setTrieuChung(String trieuChung) {
        this.trieuChung = trieuChung;
    }

    public Date getTdKhaiBao() {
        return tdKhaiBao;
    }

    public void setTdKhaiBao(Date tdKhaiBao) {
        this.tdKhaiBao = tdKhaiBao;
    }

    public String getTienSu() {
        return tienSu;
    }

    public void setTienSu(String tienSu) {
        this.tienSu = tienSu;
    }
}
