package nhom13.covid.Dao;

import nhom13.covid.Dao.mapper.NhanKhauMapper;
import nhom13.covid.Model.NhanKhau;

import java.util.List;

public class NhanKhauDao extends AbstractDao<NhanKhau> {
    public List<NhanKhau> getAll() {
        String query = "Select * FROM NhanKhau";
        return super.query(query, new NhanKhauMapper());
    }

    /**
     * Lấy nhân khẩu theo mã nhân khẩu
     * @param maNhanKhau mã nhân khẩu
     * @return nhân khẩu tương ứng với mã nhân khẩu truyền vào
     *         null nếu mã nhân khẩu không tồn tại
     */
    public NhanKhau getByMaNhanKhau(int maNhanKhau) {
        String query = "Select * FROM NhanKhau WHERE Manhankhau = ?";
        List<NhanKhau> nhanKhauList = super.query(query, new NhanKhauMapper(), maNhanKhau);
        if (nhanKhauList == null || nhanKhauList.isEmpty())
            return null;
        else
            return nhanKhauList.get(0);
    }

    /**
     * Chỉnh sửa nhân khẩu
     * @param nhanKhau nhân khẩu
     */
    public void update(NhanKhau nhanKhau) {
        String query = "UPDATE NhanKhau SET Hovaten = ?, CCCD = ?, Ngaysinh = ?, Noisinh = ?, Dantoc = ?, Tongiao = ?, Gioitinh = ?," +
                "Trinhdovanhoa = ?, Nghenghiep = ?, Noilamviec = ?, Ngaydangkithuongtru = ?, Quanhevoichuho = ?, Mahokhau = ?, Ghichu = ? WHERE Manhankhau = ?";
        super.update(query, nhanKhau.getHoVaTen(), nhanKhau.getCccd(), nhanKhau.getNgaySinh(), nhanKhau.getNoiSinh(), nhanKhau.getDanToc(), nhanKhau.getTonGiao(), nhanKhau.getGioiTinh(),
                nhanKhau.getTrinhDoVH(), nhanKhau.getNgheNghiep(), nhanKhau.getNoiLamViec(), nhanKhau.getNgayDKThuongTru(), nhanKhau.getQhChuHo(), nhanKhau.getMaHoKhau(), nhanKhau.getGhiChu(), nhanKhau.getMaNhanKhau());
    }

    /**
     * Thêm nhân khẩu vào bảng
     * @param nhanKhau không cần mã nhân khẩu
     */
    public void insert(NhanKhau nhanKhau) {
        String query = "INSERT INTO NhanKhau(Hovaten, CCCD, Ngaysinh, Noisinh, Dantoc, Tongiao, Gioitinh, " +
                "Trinhdovanhoa, Nghenghiep , Noilamviec, Ngaydangkithuongtru, Quanhevoichuho, Mahokhau, Ghichu) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        super.update(query, nhanKhau.getHoVaTen(), nhanKhau.getCccd(), nhanKhau.getNgaySinh(), nhanKhau.getNoiSinh(),
                nhanKhau.getDanToc(), nhanKhau.getTonGiao(), nhanKhau.getGioiTinh(), nhanKhau.getTrinhDoVH(), nhanKhau.getNgheNghiep(),
                nhanKhau.getNoiLamViec(), nhanKhau.getNgayDKThuongTru(), nhanKhau.getQhChuHo(), nhanKhau.getMaHoKhau(), nhanKhau.getGhiChu());
    }

    public void delete(Integer maNhanKhau) {
        String query = "DELETE FROM NhanKhau WHERE Manhankhau = ?";
        super.update(query, maNhanKhau);
    }

    Integer countAll() {
        String query = "Select count(*) FROM NhanKhau";
        return super.count(query);
    }
}
