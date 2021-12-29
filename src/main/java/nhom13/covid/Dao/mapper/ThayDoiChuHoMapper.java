package nhom13.covid.Dao.mapper;

import nhom13.covid.Model.ThayDoiChuHo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ThayDoiChuHoMapper implements RowMapper<ThayDoiChuHo> {
    @Override
    public ThayDoiChuHo mapRow(ResultSet resultSet) {
        try {
            ThayDoiChuHo thayDoiChuHo = new ThayDoiChuHo();
            thayDoiChuHo.setMaThayDoiChuHo(resultSet.getInt("Maphieuthaydoichuho"));
            thayDoiChuHo.setMaChuHoCu(resultSet.getInt("Machuhocu"));
            thayDoiChuHo.setMaChuHoMoi(resultSet.getInt("Machuhomoi"));
            thayDoiChuHo.setNgayThayDoi(resultSet.getDate("Ngaythaydoi"));
            thayDoiChuHo.setLyDo(resultSet.getString("Lydothaydoi"));
            return thayDoiChuHo;
        } catch (SQLException e) {
            return null;
        }
    }
}
