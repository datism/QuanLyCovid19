package nhom13.covid.Dao.mapper;

import nhom13.covid.Model.TestCovid;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author trdat
 */
public class TestCovidMapper implements RowMapper<TestCovid> {
    @Override
    public TestCovid mapRow(ResultSet resultSet) {
        try {
            //Khởi tạo đối tượng testCovid
            TestCovid testCovid = new TestCovid();

            //Thiết lập các thuộc tính của đối tượng testCovid theo hàng được truy vấn
            testCovid.setHoVaTen(resultSet.getString("Hovaten"));
            testCovid.setCccd(resultSet.getString("CCCD"));
            testCovid.setMaNhanKhau(resultSet.getInt("Manhankhau"));
            testCovid.setSoDt(resultSet.getString("Sodienthoai"));
            testCovid.setSoLanTest(resultSet.getInt("Solantest"));
            testCovid.setHinhThucTest(resultSet.getString("Hinhthuctest"));
            testCovid.setKetQua(resultSet.getBoolean("Ketqua"));
            testCovid.setNgayTest(resultSet.getDate("Ngaytest"));
            return testCovid;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
