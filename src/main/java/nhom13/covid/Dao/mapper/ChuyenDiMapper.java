package nhom13.covid.Dao.mapper;

import nhom13.covid.Model.ChuyenDi;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChuyenDiMapper implements RowMapper<ChuyenDi> {
    @Override
    public ChuyenDi mapRow(ResultSet resultSet) {
        try {
            ChuyenDi chuyenDi = new ChuyenDi();
            chuyenDi.setMaChuyenDi(resultSet.getInt("Maphieuchuyendi"));
            chuyenDi.setMaNhanKhau(resultSet.getInt("Mahankhau"));
            chuyenDi.setNoiChuyenDen(resultSet.getString("Noichuyenden"));
            chuyenDi.setNgayChuyen(resultSet.getDate("Ngaychuyendi"));
            chuyenDi.setLyDo(resultSet.getString("Lydochuyendi"));
            return chuyenDi;
        } catch (SQLException e) {
            return null;
        }
    }
}
