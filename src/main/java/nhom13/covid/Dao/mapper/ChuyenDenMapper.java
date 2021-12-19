package nhom13.covid.Dao.mapper;

import nhom13.covid.Model.ChuyenDen;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChuyenDenMapper implements RowMapper<ChuyenDen> {
    @Override
    public ChuyenDen mapRow(ResultSet resultSet) {
        try {
            ChuyenDen chuyenDen = new ChuyenDen();
            chuyenDen.setMaChuyenDen(resultSet.getInt("Maphieuchuyenden"));
            chuyenDen.setMaNhanKhau(resultSet.getInt("Manhankhau"));
            chuyenDen.setNoiChuyenDi(resultSet.getString("Noichuyendi"));
            chuyenDen.setNgayChuyen(resultSet.getDate("Ngaychuyenden"));
            chuyenDen.setLyDo(resultSet.getString("Lydochuyenden"));
            return chuyenDen;
        } catch (SQLException e) {
            return null;
        }
    }
}
