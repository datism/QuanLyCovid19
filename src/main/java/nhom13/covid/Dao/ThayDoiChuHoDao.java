package nhom13.covid.Dao;

import nhom13.covid.Dao.mapper.ThayDoiChuHoMapper;
import nhom13.covid.Model.ThayDoiChuHo;

import java.util.List;

public class ThayDoiChuHoDao extends AbstractDao<ThayDoiChuHo> {
    public List<ThayDoiChuHo> getAll() {
        String query = "Select * FROM Phieuthaydoichuho";
        return super.query(query, new ThayDoiChuHoMapper());
    }

    public void insert(ThayDoiChuHo thayDoiChuHo) {
        String query = "INSERT INTO Phieuthaydoichuho(Lydothaydoi, Ngaythaydoi, Machuhocu, Machuhomoi) VALUES (?, ?, ?, ?)";
        super.update(query, thayDoiChuHo.getLyDo(), thayDoiChuHo.getNgayThayDoi(), thayDoiChuHo.getMaChuHoCu(), thayDoiChuHo.getMaChuHoMoi());
    }
}
