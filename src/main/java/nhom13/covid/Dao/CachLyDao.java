package nhom13.covid.Dao;

import nhom13.covid.Dao.mapper.CachLyMapper;
import nhom13.covid.Model.CachLy;

import java.util.List;

public class CachLyDao extends AbstractDao<CachLy> {
    public List<CachLy> getAll() {
        String query = "Select * FROM Nguoicachly";
        return super.query(query, new CachLyMapper());
    }

    public Integer countByMucDo(Integer mucDo) {
        String query = "Select count(*) FROM Nguoicachly WHERE Mucdocachly_F = ?";
        return super.count(query, mucDo);
    }
}
