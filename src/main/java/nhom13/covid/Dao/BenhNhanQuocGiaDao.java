package nhom13.covid.Dao;
import nhom13.covid.Dao.mapper.BenhNhanQuocGiaMapper;
import nhom13.covid.Model.BenhNhanQuocGia;
import java.util.List;

public class BenhNhanQuocGiaDao extends AbstractDao<BenhNhanQuocGia> {
    public List<BenhNhanQuocGia> getAll() {
        String query = "Select * FROM Benhnhancovidquocgia";
        return super.query(query, new BenhNhanQuocGiaMapper());
    }

    public Integer countAll() {
        String query = "Select count(*) FROM Benhnhancovidquocgia";
        return super.count(query);
    }
}
