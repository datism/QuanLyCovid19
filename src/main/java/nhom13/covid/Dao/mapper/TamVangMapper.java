package nhom13.covid.Dao.mapper;

import nhom13.covid.Model.TamVang;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TamVangMapper implements RowMapper<TamVang> {
    @Override
    public TamVang mapRow(ResultSet resultSet) {
        try {
            TamVang tamVang = new TamVang();
            tamVang.setMaTamVang(resultSet.getInt("Magiaytamvang"));
            tamVang.setMaNhanKhau(resultSet.getInt("Manhankhau"));
            tamVang.setNgayTamVang(resultSet.getDate("Ngaytamvang"));
            tamVang.setNoiDi(resultSet.getString("Noidi"));
            return tamVang;
        } catch (SQLException e) {
            return null;
        }
    }
}
