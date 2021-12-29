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

    public Integer countAll() {
        String query = "Select count(*) FROM Thongtinkhaibaoyte";
        return super.count(query);
    }

    public Integer countByTrieuChung(String trieuChung) {
        StringBuilder query = new StringBuilder("Select count(*) FROM Thongtinkhaibaoyte WHERE ");
        if (trieuChung != null) {
            if(trieuChung.equals("Khác"))
                query.append("Trieuchung NOT LIKE N'%ho%' AND Trieuchung NOT LIKE N'%sốt%' AND Trieuchung NOT LIKE N'%khó thở%' AND Trieuchung NOT LIKE N'đau họng%'");
            else
                query.append("Trieuchung LIKE " + "N'%").append(trieuChung).append("%'");
        }
        else
            query.append("Trieuchung is null");

        return super.count(query.toString());
    }
}
