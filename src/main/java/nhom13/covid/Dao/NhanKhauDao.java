package nhom13.covid.Dao;

import nhom13.covid.Dao.mapper.NhanKhauMapper;
import nhom13.covid.Model.NhanKhau;

import java.util.List;

public class NhanKhauDao extends AbstractDao<NhanKhau> {
    public List<NhanKhau> getAll() {
        String query = "Select * FROM NhanKhau";
        return super.query(query, new NhanKhauMapper());
    }

    public NhanKhau getByMaNhanKhau(int maNhanKhau) {
        String query = "Select * FROM NhanKhau WHERE Manhankhau = ?";
        List<NhanKhau> nhanKhauList = super.query(query, new NhanKhauMapper(), maNhanKhau, maNhanKhau);
        if (nhanKhauList == null || nhanKhauList.isEmpty())
            return null;
        else
            return nhanKhauList.get(0);
    }
}
