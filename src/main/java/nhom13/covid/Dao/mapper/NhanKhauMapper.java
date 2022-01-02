package nhom13.covid.Dao.mapper;

import nhom13.covid.Model.NhanKhau;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NhanKhauMapper implements RowMapper<NhanKhau> {

    @Override
    public NhanKhau mapRow(ResultSet resultSet) {
        try {
            //Khởi tạo đối tượng
            NhanKhau nhanKhau = new NhanKhau();

            //Thiết lập các thuộc tính của đối tượng theo hàng được truy vấn
            nhanKhau.setMaNhanKhau(resultSet.getInt("Manhankhau"));
            nhanKhau.setHoVaTen(resultSet.getString("Hovaten"));
            nhanKhau.setCccd(resultSet.getString("CCCD"));
            nhanKhau.setNgaySinh(resultSet.getDate("Ngaysinh"));
            nhanKhau.setNoiSinh(resultSet.getString("Noisinh"));
            nhanKhau.setDanToc(resultSet.getString("Dantoc"));
            nhanKhau.setTonGiao(resultSet.getString("Tongiao"));
            nhanKhau.setGioiTinh(resultSet.getBoolean("Gioitinh"));
            nhanKhau.setTrinhDoVH(resultSet.getString("Trinhdovanhoa"));
            nhanKhau.setNgheNghiep(resultSet.getString("Nghenghiep"));
            nhanKhau.setNoiLamViec(resultSet.getString("Noilamviec"));
            nhanKhau.setNgayDKThuongTru(resultSet.getDate("Ngaydangkithuongtru"));
            nhanKhau.setQhChuHo(resultSet.getString("Quanhevoichuho"));

            Integer mahokhau= resultSet.getInt("Mahokhau");
            nhanKhau.setMaHoKhau(resultSet.wasNull() ? null : mahokhau);

            nhanKhau.setGhiChu(resultSet.getString("Ghichu"));

            return nhanKhau;
        } catch (SQLException e) {
            return null;
        }
    }
}
