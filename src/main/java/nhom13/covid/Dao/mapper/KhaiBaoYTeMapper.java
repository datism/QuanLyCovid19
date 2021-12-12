package nhom13.covid.Dao.mapper;
import nhom13.covid.Model.KhaiBaoYTe;

import java.sql.ResultSet;
import java.sql.SQLException;

public class KhaiBaoYTeMapper implements RowMapper<KhaiBaoYTe> {

    @Override
    public KhaiBaoYTe mapRow(ResultSet resultSet) {
        try {
            KhaiBaoYTe khaiBaoYTe = new KhaiBaoYTe();
            khaiBaoYTe.setHoVaTen(resultSet.getString("Hovaten"));
            khaiBaoYTe.setCccd(resultSet.getString("CCCD"));
            khaiBaoYTe.setMaNhanKhau(resultSet.getInt("Manhankhau"));
            khaiBaoYTe.setSoDt(resultSet.getString("Sodienthoai"));
            khaiBaoYTe.setEmail(resultSet.getString("Email"));
            khaiBaoYTe.setNoiDiChuyen(resultSet.getString("Noidichuyen"));
            khaiBaoYTe.setTrieuChung(resultSet.getString("Trieuchung"));
            khaiBaoYTe.setTdKhaiBao(resultSet.getDate("Thoidiemkhaibao"));
            khaiBaoYTe.setTienSu(resultSet.getString("Tiensumacbanh"));
            return khaiBaoYTe;
        } catch (SQLException e) {
            return null;
        }
    }
}
