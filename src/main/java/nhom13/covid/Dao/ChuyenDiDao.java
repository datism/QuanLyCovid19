package nhom13.covid.Dao;
import nhom13.covid.Dao.mapper.ChuyenDiMapper;
import nhom13.covid.Model.ChuyenDen;
import nhom13.covid.Model.ChuyenDi;

import java.util.List;

public class ChuyenDiDao extends AbstractDao<ChuyenDi> {
    public List<ChuyenDi> getAll() {
        String query = "Select * FROM PhieuChuyenDi";
        return super.query(query, new ChuyenDiMapper());
    }
    public void update(ChuyenDi chuyenDi) {
        String query = "UPDATE PhieuChuyenDi SET Mahankhau = ?, Noichuyenden = ?, Ngaychuyendi = ?, Lydochuyendi = ?," +
                "WHERE Maphieuchuyendi = ?";
        super.update(query, chuyenDi.getMaNhanKhau(), chuyenDi.getNoiChuyenDen(), chuyenDi.getNgayChuyen()
                , chuyenDi.getLyDo(), chuyenDi.getMaChuyenDi());
    }


    public void insert(ChuyenDi chuyenDi) {
        String query = "INSERT INTO PhieuChuyenDi(Noichuyenden, Ngaychuyendi, Lydochuyendi, Mahankhau) VALUES (?, ?, ?, ?)";
        super.update(query, chuyenDi.getNoiChuyenDen(), chuyenDi.getNgayChuyen(), chuyenDi.getLyDo(), chuyenDi.getMaNhanKhau());
    }

    public void delete(int maPhieuChuyenDi) {
        String query = "DELETE FROM PhieuChuyenDi WHERE Maphieuchuyendi = ?";
        super.update(query, maPhieuChuyenDi);
    }
}
