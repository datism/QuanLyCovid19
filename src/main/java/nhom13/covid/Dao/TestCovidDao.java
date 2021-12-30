package nhom13.covid.Dao;

import nhom13.covid.Dao.mapper.TestCovidMapper;
import nhom13.covid.Model.TestCovid;
import java.util.List;

/**
 * @author trdat
 */
public class TestCovidDao extends AbstractDao<TestCovid> {

    public List<TestCovid> getAll() {
        String query = "Select * FROM Thongtintestcovid";
        return super.query(query, new TestCovidMapper());
    }

    public void update(TestCovid testCovid) {
        String query = "UPDATE Thongtintestcovid SET Hovaten = ?, CCCD = ?, Sodienthoai = ?, Solantest = ?," +
                "Hinhthuctest = ?, Ketqua = ?, Ngaytest = ? WHERE Manhankhau = ?";
        super.update(query, testCovid.getHoVaTen(), testCovid.getCccd(), testCovid.getSoDt(), testCovid.getSoLanTest(),
                testCovid.getHinhThucTest(), testCovid.getKetQua(), testCovid.getNgayTest(), testCovid.getMaNhanKhau());
    }

    public void insert(TestCovid testCovid) {
        String query = "INSERT INTO Thongtintestcovid(Hovaten, CCCD, MaNhankhau, Sodienthoai, Solantest, Hinhthuctest, Ketqua, Ngaytest) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        super.update(query, testCovid.getHoVaTen(), testCovid.getCccd(), testCovid.getMaNhanKhau(), testCovid.getSoDt(), testCovid.getSoLanTest(),
                testCovid.getHinhThucTest(), testCovid.getKetQua(), testCovid.getNgayTest());
    }

    public void delete(int maNhanKhau) {
        String query = "DELETE FROM Thongtintestcovid WHERE Manhankhau = ?";
        super.update(query, maNhanKhau);
    }


}
