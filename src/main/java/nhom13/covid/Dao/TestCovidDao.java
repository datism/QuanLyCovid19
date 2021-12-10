package nhom13.covid.Dao.impl;

import nhom13.covid.Dao.mapper.TestCovidMapper;
import nhom13.covid.Model.TestCovid;

import java.util.List;

public class TestCovidDao extends AbstractDao<TestCovid> {

    public List<TestCovid> getAll() {
        String query = "Select * FORM Thongtintestcovid";
        return super.query(query, new TestCovidMapper());
    }

    public void update(TestCovid testCovid) {
        String query = "UPDATE Thongtintestcovid SET Hovaten = ?, CCCD = ?, Sodienthoai = ?, Solantest = ?," +
                "Hinhthuctest = ?, Ketqua = ?, Mucdonhiem_F = ?, Candicachly = ? WHERE Manhankhau = ?";
        super.update(query, testCovid.getHoVaTen(), testCovid.getCccd(), testCovid.getSoDt(), testCovid.getSoLanTest(),
                testCovid.getHinhThucTest(), testCovid.isKetQua(), testCovid.getMucDo(), testCovid.isCachLy(), testCovid.getMaNhanKhau());
    }

    public void delete(int maNhanKhau) {
        String query = "DELETE FROM Thongtintestcovid WHERE Manhankhau = ?";
        super.update(query, maNhanKhau);
    }

    public Integer countAll() {
        String query = "Select * FORM Thongtintestcovid";
        return super.count(query);
    }

}
