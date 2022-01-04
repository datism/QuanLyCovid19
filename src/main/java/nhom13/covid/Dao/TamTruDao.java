package nhom13.covid.Dao;

import nhom13.covid.Dao.mapper.TamTruMapper;
import nhom13.covid.Model.TamTru;

import java.util.List;

public class TamTruDao extends AbstractDao<TamTru> {
    public List<TamTru> getAll() {
        String query = "Select * FROM Giaytamtru";
        return super.query(query, new TamTruMapper());
    }

    public void insert(TamTru tamTru) {
        String query = "INSERT INTO Giaytamtru(Mahokhau, Diachithuongtru, Manhankhau, Ngaytamtru, Thoihan) VALUES (?, ?, ?, ?, ?)";
        super.update(query, tamTru.getMaHoKhau(), tamTru.getDcThuongTru(), tamTru.getMaNhanKhau(), tamTru.getNgayThuongTru(), tamTru.getThoiHan());
    }

    public Integer countAll() {
        String query = "Select count(*) FROM Giaytamtru";
        return super.count(query);
    }
}
