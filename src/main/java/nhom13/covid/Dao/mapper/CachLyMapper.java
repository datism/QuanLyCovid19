package nhom13.covid.Dao.mapper;

import nhom13.covid.Model.CachLy;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CachLyMapper implements RowMapper<CachLy> {
    @Override
    public CachLy mapRow(ResultSet resultSet) {
        try {
            CachLy cachLy = new CachLy();
            cachLy.setHoVaTen(resultSet.getString("Hovaten"));
            cachLy.setMaNhanKhau(resultSet.getInt("Manhankhau"));
            cachLy.setMucDo(resultSet.getInt("Mucdocachly_F"));
            cachLy.setBenhNhanTx(resultSet.getInt("Mabenhnhantiepxuc"));
            cachLy.setTdCachLy(resultSet.getDate("Thoidiemcachly"));
            cachLy.setKvCachLy(resultSet.getString("Khuvuccachly"));
            return cachLy;
        } catch (SQLException e) {
            return null;
        }
    }
}
