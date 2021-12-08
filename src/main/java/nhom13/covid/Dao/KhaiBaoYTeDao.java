/** Mạnh Thắng **/
package nhom13.covid.Dao;

import nhom13.covid.Model.KhaiBaoYTe;
import nhom13.covid.connect;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KhaiBaoYTeDao implements Dao<KhaiBaoYTe>{
    @Override
    public List<KhaiBaoYTe> getAll() {
        return null;
    }

    @Override
    public void update(KhaiBaoYTe khaiBaoYTe) {
        try {
            Connection connection = connect.getConnection();
            //query thêm thông tin vào bảng khai báo y tế
            String sql = "insert into Thongtinkhaibaoyte(Hovaten, CCCD, Manhankhau, Sodienthoai, Email, Noidichuyen, Trieuchung, Thoidiemkhaibao, Tiensumacbanh) values(?,?,?,?,?,?,?,?, ?)";
            PreparedStatement statement = connection.prepareCall(sql);
            statement.setString(1, khaiBaoYTe.getHoVaTen());
            statement.setString(2, khaiBaoYTe.getCccd());
            statement.setInt(3, khaiBaoYTe.getMaNhanKhau());
            statement.setString(4, khaiBaoYTe.getSoDt());
            statement.setString(5, khaiBaoYTe.getEmail());
            statement.setString(6, khaiBaoYTe.getNoiDiChuyen());
            statement.setString(7, khaiBaoYTe.getTrieuChung());
            statement.setDate(8, (Date) khaiBaoYTe.getTdKhaiBao());
            statement.setString(9, khaiBaoYTe.getTienSu());

            statement.execute();

            statement.close();
            connection.close();
        } catch (Exception ex) {
            Logger.getLogger(KhaiBaoYTeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean check_Manhankhau(int ma) {
        try {
            Connection connection = connect.getConnection();
            //query kiểm tra xem mã nhân khẩu có tồn tại không
            String sql = "select Manhankhau from NhanKhau where Manhankhau=" + String.valueOf(ma);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                int std = resultSet.getInt("Manhankhau");
                if(std == ma) return true;
            }
            statement.close();
            connection.close();
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(KhaiBaoYTeDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public void delete(KhaiBaoYTe khaiBaoYTe) {

    }
}
