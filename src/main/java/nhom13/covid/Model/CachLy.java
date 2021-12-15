package nhom13.covid.Model;

import java.sql.Date;

/**
 * @author trdat
 */
public class CachLy {
    String hoVaTen;
    Integer maNhanKhau;
    Integer mucDo;
    Integer benhNhanTx;
    Date tdCachLy;
    String kvCachLy;

    public CachLy(String hoVaTen, Integer maNhanKhau, Integer mucDo, Integer benhNhanTx, Date tdCachLy, String kvCachLy) {
        this.hoVaTen = hoVaTen;
        this.maNhanKhau = maNhanKhau;
        this.mucDo = mucDo;
        this.benhNhanTx = benhNhanTx;
        this.tdCachLy = tdCachLy;
        this.kvCachLy = kvCachLy;
    }

    public CachLy() {
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public Integer getMaNhanKhau() {
        return maNhanKhau;
    }

    public void setMaNhanKhau(Integer maNhanKhau) {
        this.maNhanKhau = maNhanKhau;
    }

    public Integer getMucDo() {
        return mucDo;
    }

    public void setMucDo(Integer mucDo) {
        this.mucDo = mucDo;
    }

    public Integer getBenhNhanTx() {
        return benhNhanTx;
    }

    public void setBenhNhanTx(Integer benhNhanTx) {
        this.benhNhanTx = benhNhanTx;
    }

    public Date getTdCachLy() {
        return tdCachLy;
    }

    public void setTdCachLy(Date tdCachLy) {
        this.tdCachLy = tdCachLy;
    }

    public String getKvCachLy() {
        return kvCachLy;
    }

    public void setKvCachLy(String kvCachLy) {
        this.kvCachLy = kvCachLy;
    }
}
