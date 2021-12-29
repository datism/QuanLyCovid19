package nhom13.covid.Dao.mapper;

import nhom13.covid.Dao.AbstractDao;
import nhom13.covid.Model.NhanKhau;
import nhom13.covid.Model.SoHoKhau;

import java.util.List;

public class SoHoKhauDao extends AbstractDao<SoHoKhau> {
    public List<SoHoKhau> getAll() {
        String query = "Select * FROM Sohokhau";
        return super.query(query, new SoHoKhauMapper());
    }

    /**
     * Lấy hộ khẩu theo mã hộ khẩu
     * @param maHoKhau mã hộ khẩu
     * @return nhân khẩu tương ứng với mã nhân khẩu truyền vào
     *         null nếu mã nhân khẩu không tồn tại
     */
    public SoHoKhau getByMaHoKhau(int maHoKhau) {
        String query = "Select * FROM NhanKhau WHERE Manhankhau = ?";
        List<SoHoKhau> hoKhauList = super.query(query, new SoHoKhauMapper(), maHoKhau);
        if (hoKhauList == null || hoKhauList.isEmpty())
            return null;
        else
            return hoKhauList.get(0);
    }

    public void insert(SoHoKhau soHoKhau) {
        String query = "INSERT INTO Sohokhau(Sonha, DuongID, Chuho, Ngaycap) VALUES(?, ?, ?, ?)";
        super.update(query, soHoKhau.getSoNha(), soHoKhau.getDuongID(), soHoKhau.getChuHo(), soHoKhau.getNgayCap());
    }

    Integer countAll(){
        String query = "Select count(*) FROM NhanKhau WHERE Manhankhau = ?";
        return  super.count(query);
    }
}
