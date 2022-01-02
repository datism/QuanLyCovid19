package nhom13.covid.Dao.mapper;

import nhom13.covid.Model.SoHoKhau;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SoHoKhauMapper implements RowMapper<SoHoKhau> {

    @Override
    public SoHoKhau mapRow(ResultSet resultSet) {
        try {
            SoHoKhau soHoKhau = new SoHoKhau();
            soHoKhau.setMaHoKhau(resultSet.getInt("Mahokhau"));
            soHoKhau.setSoNha(resultSet.getString("Sonha"));
            soHoKhau.setDuongID(resultSet.getInt("DuongID"));
            soHoKhau.setChuHo(resultSet.getInt("Chuho"));
            soHoKhau.setNgayCap(resultSet.getDate("Ngaycap"));
            return soHoKhau;
        } catch (SQLException e) {
            return null;
        }
    }
}
