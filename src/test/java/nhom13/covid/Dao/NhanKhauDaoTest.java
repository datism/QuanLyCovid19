package nhom13.covid.Dao;

import nhom13.covid.Model.NhanKhau;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class NhanKhauDaoTest {
    NhanKhauDao nhanKhauDao = new NhanKhauDao();

    @Test
    void getAll() {
        List<NhanKhau> nhanKhauList = nhanKhauDao.getAll();
        assertEquals(nhanKhauList.size(), 50);
    }

    @Test
    void getByMaNhanKhau() {
        String name = "IOBTYR2W7183X5NWW3Y";
        int maNhanKhau = 2;
        NhanKhau nhanKhau= nhanKhauDao.getByMaNhanKhau(2);
        assertEquals(nhanKhau.getHoVaTen(), name);
    }

    @Test
    void update() {
        String newName = "DAT";
        int maNhanKhau = 3;
        NhanKhau oNhanKhau= nhanKhauDao.getByMaNhanKhau(maNhanKhau);
        oNhanKhau.setHoVaTen(newName);
        nhanKhauDao.update(oNhanKhau);
        NhanKhau nNhanKhau= nhanKhauDao.getByMaNhanKhau(maNhanKhau);
        assertEquals(nNhanKhau.getHoVaTen(), oNhanKhau.getHoVaTen());
    }

    @Test
    void insert() {
        NhanKhau nhanKhau = nhanKhauDao.getByMaNhanKhau(4);
        nhanKhau.setHoVaTen("heloWorld");
        nhanKhauDao.insert(nhanKhau);
        assertEquals(nhanKhauDao.getAll().size(), 51);
    }

    @Test
    void countAll() {
    }

    @Test
    void updateHoKhau() {
        Integer maNhaKhau = 1;
        Integer maHoKhau = 50;
        nhanKhauDao.updateHoKhau(maHoKhau, maNhaKhau);
        NhanKhau  nhanKhau = nhanKhauDao.getByMaNhanKhau(maNhaKhau);
        assertEquals(nhanKhau.getMaHoKhau(), maHoKhau);
    }
}