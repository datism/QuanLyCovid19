package nhom13.covid.Model;

/**
 * @author ddat
 */
public class TestCovid {
    String hoVaTen;
    String cccd;
    int maNhanKhau;
    String soDt;
    int soLanTest;
    String hinhThucTest;
    String ketQua;
    int mucDo;
    boolean cachLy;

    public TestCovid(String hoVaTen, String cccd, int maNhanKhau, String soDt, int soLanTest, String hinhThucTest, String ketQua, int mucDo, boolean cachLy) {
        this.hoVaTen = hoVaTen;
        this.cccd = cccd;
        this.maNhanKhau = maNhanKhau;
        this.soDt = soDt;
        this.soLanTest = soLanTest;
        this.hinhThucTest = hinhThucTest;
        this.ketQua = ketQua;
        this.mucDo = mucDo;
        this.cachLy = cachLy;
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

    public int getSoLanTest() {
        return soLanTest;
    }

    public void setSoLanTest(int soLanTest) {
        this.soLanTest = soLanTest;
    }

    public String getHinhThucTest() {
        return hinhThucTest;
    }

    public void setHinhThucTest(String hinhThucTest) {
        this.hinhThucTest = hinhThucTest;
    }

    public String getKetQua() {
        return ketQua;
    }

    public void setKetQua(String ketQua) {
        this.ketQua = ketQua;
    }

    public int getMucDo() {
        return mucDo;
    }

    public void setMucDo(int mucDo) {
        this.mucDo = mucDo;
    }

    public boolean isCachLy() {
        return cachLy;
    }

    public void setCachLy(boolean cachLy) {
        this.cachLy = cachLy;
    }
}
