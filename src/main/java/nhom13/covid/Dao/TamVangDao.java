package nhom13.covid.Dao;

import nhom13.covid.Dao.mapper.TamVangMapper;
import nhom13.covid.Model.TamVang;

import java.util.List;

public class TamVangDao extends AbstractDao<TamVang> {
    public List<TamVang> getAll() {
        String query = "Select * FROM Giaytamvang";
        return super.query(query, new TamVangMapper());
    }

    public void insert(TamVang tamVang) {
        String query = "INSERT INTO Giaytamvang(Manhankhau, Ngaytamvang, Noidi) VALUES (?, ?, ?)";
        super.update(query, tamVang.getMaNhanKhau(), tamVang.getNgayTamVang(), tamVang.getNoiDi());
    }

    public Integer countAll() {
        String query = "Select count(*) FROM Giaytamvang";
        return super.count(query);
    }
}
