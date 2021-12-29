package nhom13.covid.Dao.mapper;

import nhom13.covid.Model.BenhNhanQuocGia;
import nhom13.covid.Model.TestCovid;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BenhNhanQuocGiaMapper implements RowMapper<BenhNhanQuocGia> {
    @Override
    public BenhNhanQuocGia mapRow(ResultSet resultSet) {
        try {
            //Khởi tạo đối tượng
            BenhNhanQuocGia benhNhanQuocGia = new BenhNhanQuocGia();

            //Thiết lập các thuộc tính của đối tượng theo hàng được truy vấn
            benhNhanQuocGia.setHoVaTen(resultSet.getString("Hovaten"));
            benhNhanQuocGia.setCccd(resultSet.getString("CCCD"));
            benhNhanQuocGia.setTuoi(resultSet.getInt("Tuoi"));
            benhNhanQuocGia.setGioiTinh(resultSet.getBoolean("Gioitinh"));
            benhNhanQuocGia.setTdNhiem(resultSet.getDate("Thoidiemnhiem"));
            benhNhanQuocGia.setNoiNhiem(resultSet.getString("Noinhiem"));
            benhNhanQuocGia.setMaBenhNhan(resultSet.getInt("Mabenhnhannhiem"));
            return benhNhanQuocGia;
        } catch (SQLException e) {
            return null;
        }
    }
}
