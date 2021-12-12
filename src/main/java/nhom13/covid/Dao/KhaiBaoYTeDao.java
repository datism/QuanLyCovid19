package nhom13.covid.Dao;
import nhom13.covid.Dao.mapper.KhaiBaoYTeMapper;
import nhom13.covid.Model.KhaiBaoYTe;
import java.util.List;

/**
 * @author manhThang
 */
public class KhaiBaoYTeDao extends AbstractDao<KhaiBaoYTe>{
    public List<KhaiBaoYTe> getAll() {
        String query = "Select * FROM Thongtinkhaibaoyte";
        return super.query(query, new KhaiBaoYTeMapper());
    }

    public void insert(KhaiBaoYTe khaiBaoYTe) {
        String query = "INSERT INTO Thongtinkhaibaoyte(Hovaten, CCCD, MaNhankhau, Sodienthoai, Email, Noidichuyen," +
                " Trieuchung, Thoidiemkhaibao, Tiensumacbanh) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        super.update(query, khaiBaoYTe.getHoVaTen(), khaiBaoYTe.getCccd(), khaiBaoYTe.getMaNhanKhau(), khaiBaoYTe.getSoDt(), khaiBaoYTe.getEmail(),
                khaiBaoYTe.getNoiDiChuyen(), khaiBaoYTe.getTrieuChung(), khaiBaoYTe.getTienSu());
    }
}
