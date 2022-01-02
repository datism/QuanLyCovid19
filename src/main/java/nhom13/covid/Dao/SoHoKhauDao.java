package nhom13.covid.Dao;

import nhom13.covid.Dao.mapper.SoHoKhauMapper;
import nhom13.covid.Model.SoHoKhau;

import java.util.List;

public class SoHoKhauDao extends AbstractDao<SoHoKhau> {
    public List<SoHoKhau> getAll() {
        String query = "Select * FROM Sohokhau";
        return super.query(query, new SoHoKhauMapper());
    }

    /**
     * Lấy sổ hộ khẩu theo mã hội khẩu
     * @param maHoKhau mã hộ khẩu
     * @return hộ khẩu tương ứng với mã mã hộ khẩu truyền vào
     *         null nếu mã hộ khẩu không tồn tại
     */
    public SoHoKhau getByMaHoKhau(int maHoKhau) {
        String query = "Select * FROM Sohokhau SO WHERE Mahokhau = ?";
        List<SoHoKhau> soHoKhauList = super.query(query, new SoHoKhauMapper(), maHoKhau);
        if (soHoKhauList == null || soHoKhauList.isEmpty())
            return null;
        else
            return soHoKhauList.get(0);
    }

    /**
     * Chỉnh sửa hộ khẩu
     * @param soHoKhau sổ hộ khẩu
     */
    public void update(SoHoKhau soHoKhau) {
        String query = "UPDATE Sohokhau SET Sonha = ?, DuongID = ?, Chuho = ?, Ngaycap = ? WHERE Sohokhau = ?";
        super.update(query, soHoKhau.getSoNha(), soHoKhau.getDuongID(), soHoKhau.getChuHo(), soHoKhau.getNgayCap(), soHoKhau.getMaHoKhau());
    }

    public void updateMachuHo(Integer maChuHo, Integer maHoKhau) {
        String query = "UPDATE Sohokhau SET Chuho WHERE Sohokhau = ?";
        super.update(query, maChuHo, maHoKhau);
    }

    /**
     * Thêm hộ khẩu vào bảng
     * @param soHoKhau không cần mã hộ khẩu
     */
    public Integer insert(SoHoKhau soHoKhau) {
        String query = "INSERT INTO Sohokhau(Sonha, DuongID, Chuho, Ngaycap) VALUES (?, ?, ?, ?)";
        return super.insert(query, soHoKhau.getSoNha(), soHoKhau.getDuongID(), soHoKhau.getChuHo(), soHoKhau.getNgayCap());
    }

    /**
     * Xoá hộ khẩu
     * @param maHoKhau mã hộ khẩu
     */
    public void delete(Integer maHoKhau) {
        String query = "DELETE FROM Sohokhau WHERE Sohokhau = ?";
        super.update(query, maHoKhau);
    }

    Integer countAll() {
        String query = "Select count(*) FROM Sohokhau";
        return super.count(query);
    }
}
