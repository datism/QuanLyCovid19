package nhom13.covid.Dao;

import nhom13.covid.Dao.mapper.ChuyenDenMapper;
import nhom13.covid.Model.ChuyenDen;

import java.util.List;

public class ChuyenDenDao extends AbstractDao<ChuyenDen> {
    public List<ChuyenDen> getAll() {
        String query = "Select * FROM PhieuChuyenDen";
        return super.query(query, new ChuyenDenMapper());
    }
    public void update(ChuyenDen chuyenDen) {
        String query = "UPDATE PhieuChuyenDen SET Manhankhau = ?, Noichuyendi = ?, Ngaychuyenden = ?, Lydochuyenden = ? WHERE Maphieuchuyenden = ?";
        super.update(query, chuyenDen.getMaNhanKhau(), chuyenDen.getNoiChuyenDi(), chuyenDen.getNgayChuyen()
        , chuyenDen.getLyDo(), chuyenDen.getMaChuyenDen());
    }

    public void insert(ChuyenDen chuyenDen) {
        String query = "INSERT INTO PhieuChuyenDen(Manhankhau, Noichuyendi, Ngaychuyenden, Lydochuyenden) VALUES (?, ?, ?, ?)";
        super.update(query, chuyenDen.getMaNhanKhau(), chuyenDen.getNoiChuyenDi(), chuyenDen.getNgayChuyen(), chuyenDen.getLyDo());
    }
    public void delete(int maPhieuChuyenDen) {
        String query = "DELETE FROM PhieuChuyenDen WHERE Maphieuchuyenden = ?";
        super.update(query, maPhieuChuyenDen);
    }
}
