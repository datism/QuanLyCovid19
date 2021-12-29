package nhom13.covid.Dao;

import nhom13.covid.Model.ChuyenDen;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChuyenDenDaoTest {

    @Test
    void getAll() {
        ChuyenDenDao chuyenDenDao = new ChuyenDenDao();
        List<ChuyenDen> chuyenDenList = chuyenDenDao.getAll();
        assertEquals(chuyenDenList.size(), 50);
    }

    @Test
    void insert() {
        ChuyenDenDao chuyenDenDao = new ChuyenDenDao();
        ChuyenDen chuyenDen = new ChuyenDen();
        chuyenDen.setMaNhanKhau(2969862);
        chuyenDen.setNgayChuyen(Date.valueOf(LocalDate.now()));
        chuyenDen.setNoiChuyenDi("hà nội");
        chuyenDen.setLyDo("nóng vl");
        chuyenDenDao.insert(chuyenDen);
        List<ChuyenDen> chuyenDenList = chuyenDenDao.getAll();
        assertEquals(chuyenDenList.size(), 51);
    }
}