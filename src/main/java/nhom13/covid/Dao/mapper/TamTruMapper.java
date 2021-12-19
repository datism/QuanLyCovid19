package nhom13.covid.Dao.mapper;

import nhom13.covid.Model.TamTru;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TamTruMapper implements RowMapper<TamTru> {
    @Override
    public TamTru mapRow(ResultSet resultSet) {
        try {
            TamTru soTamTru = new TamTru();
            soTamTru.setMaTamTru(resultSet.getInt("Matamtru"));
            soTamTru.setMaHoKhau(resultSet.getInt("Mahokhau"));
            soTamTru.setMaNhanKhau(resultSet.getInt("Manhankhau"));
            soTamTru.setDcThuongTru(resultSet.getString("Diachithuongtru"));
            soTamTru.setNgayThuongTru(resultSet.getDate("Ngaytamtru"));
            soTamTru.setThoiHan(resultSet.getDate("Thoihan"));
            return soTamTru;
        } catch (SQLException e) {
            return null;
        }
    }
}
