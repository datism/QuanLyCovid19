package nhom13.covid.Dao.mapper;

import java.sql.ResultSet;

/**
 * @author dd
 * @param <T>
 */
public interface RowMapper<T> {
    /**
     * Khởi tạo object theo resultSet
     * @param[in] resultSet hàng vừa truy vấn
     * @return  object thuộc lớp T
     */
    T mapRow(ResultSet resultSet);
}
