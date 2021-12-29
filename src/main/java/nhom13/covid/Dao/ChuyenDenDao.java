package nhom13.covid.Dao;

import nhom13.covid.Dao.mapper.ChuyenDenMapper;
import nhom13.covid.Model.ChuyenDen;
import nhom13.covid.Model.SoHoKhau;

import java.util.List;

public class ChuyenDenDao extends AbstractDao<ChuyenDen> {
    public List<ChuyenDen> getAll() {
        String query = "Select * FROM PhieuChuyenDen";
        return super.query(query, new ChuyenDenMapper());
    }

    public void insert(ChuyenDen chuyenDen) {
        String query = "INSERT INTO PhieuChuyenDen(Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (?, ?, ?, ?)";
        super.update(query, chuyenDen.getMaNhanKhau(), chuyenDen.getNoiChuyenDi(), chuyenDen.getNgayChuyen(), chuyenDen.getLyDo());
    }
}
