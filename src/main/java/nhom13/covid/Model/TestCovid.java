package nhom13.covid.Model;

import java.sql.Date;

/**
 * @author trdat
 */
public class TestCovid {
    String hoVaTen;
    String cccd;
    Integer maNhanKhau;
    String soDt;
    Integer soLanTest;
    String hinhThucTest;
    Boolean ketQua;
    Date ngayTest;

    public TestCovid(String hoVaTen, String cccd, Integer maNhanKhau, String soDt, Integer soLanTest, String hinhThucTest, Boolean ketQua, Date ngayTest) {
        this.hoVaTen = hoVaTen;
        this.cccd = cccd;
        this.maNhanKhau = maNhanKhau;
        this.soDt = soDt;
        this.soLanTest = soLanTest;
        this.hinhThucTest = hinhThucTest;
        this.ketQua = ketQua;
        this.ngayTest = ngayTest;
    }

    public TestCovid() {}

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

    public Integer getMaNhanKhau() {
        return maNhanKhau;
    }

    public void setMaNhanKhau(Integer maNhanKhau) {
        this.maNhanKhau = maNhanKhau;
    }

    public String getSoDt() {
        return soDt;
    }

    public void setSoDt(String soDt) {
        this.soDt = soDt;
    }

    public Integer getSoLanTest() {
        return soLanTest;
    }

    public void setSoLanTest(Integer soLanTest) {
        this.soLanTest = soLanTest;
    }

    public String getHinhThucTest() {
        return hinhThucTest;
    }

    public void setHinhThucTest(String hinhThucTest) {
        this.hinhThucTest = hinhThucTest;
    }

    public Boolean getKetQua() {
        return ketQua;
    }

    public void setKetQua(Boolean ketQua) {
        this.ketQua = ketQua;
    }

    public Date getNgayTest() {
        return ngayTest;
    }

    public void setNgayTest(Date ngayTest) {
        this.ngayTest = ngayTest;
    }
}
