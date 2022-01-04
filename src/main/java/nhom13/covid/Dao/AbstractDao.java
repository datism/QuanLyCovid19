package nhom13.covid.Dao;

import nhom13.covid.Dao.mapper.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author trdat
 * @param <T>
 */
public class AbstractDao<T>{
    private Connection getConnection() {
        String db = "Quanlycovid19";
        String user = "admin";
        String pass = "1";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=" + db + ";user=" + user + ";password=" + pass;
            return DriverManager.getConnection(url);
        } catch (SQLException | ClassNotFoundException e) {
            return null;
        }
    }

    private void setParameter(PreparedStatement prepareStatement, Object... parameters) {
        try {
            for(int i = 1; i<= parameters.length; i++) {
                Object parameter = parameters[i - 1];
                if (parameter ==  null)
                    prepareStatement.setNull(i, Types.NULL);
                else if (parameter instanceof String)
                    prepareStatement.setString(i, (String) parameter);
                else if (parameter instanceof Integer)
                    prepareStatement.setInt(i, (Integer) parameter);
                else if (parameter instanceof Boolean)
                    prepareStatement.setBoolean(i, (Boolean) parameter);
                else if(parameter instanceof Date)
                   prepareStatement.setDate(i, (Date) parameter);
            }
        } catch (SQLException ignored) {}
    }

    protected List<T> query(String query, RowMapper<T> rowMapper, Object... parameters) {
        List<T> results = new ArrayList<>();
        Connection connection = null;
        PreparedStatement prepareStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            prepareStatement = connection.prepareStatement(query);

            //Khởi tạo các tham số cho câu lệnh truy vấn
            setParameter(prepareStatement, parameters);

            //Thực hiện truy vấn
            resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                results.add(rowMapper.mapRow(resultSet));
            }
            return results;
        } catch (SQLException e) {
            return null;
        } finally {
            try {
                if(connection != null)
                    connection.close();
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException ignored) {}
        }
    }

    protected void update(String query, Object... parameters) {
        Connection connection = null;
        PreparedStatement prepareStatement = null;
        try {
            connection = getConnection();

            //Quản lý transaction thủ công
            connection.setAutoCommit(false);

            //Khởi tạo các tham số cho câu lệnh truy vấn
            prepareStatement = connection.prepareStatement(query);
            setParameter(prepareStatement, parameters);
            prepareStatement.executeUpdate();

            //Thực hiện thay đổi
            connection.commit();

        } catch (SQLException e) {
            try {
                //Khôi phục lại thay đổi
                connection.rollback();
            } catch (SQLException ignored) {}
        } finally {
            try {
                if (connection != null)
                    connection.close();
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
            } catch (SQLException ignored) {}
        }
    }

    protected Integer insert(String query, Object... parameters) {
        ResultSet resultSet = null;
        Integer id = null;
        Connection connection = null;
        PreparedStatement prepareStatement = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            prepareStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            setParameter(prepareStatement, parameters);
            prepareStatement.executeUpdate();
            resultSet = prepareStatement.getGeneratedKeys();
            if (resultSet.next()) {
                id = resultSet.getInt(1);
            }
            connection.commit();
            return id;
        } catch (SQLException e) {
            try {
                //Khôi phục lại thay đổi
                connection.rollback();
            } catch (SQLException ignored) {}
            return null;
        } finally {
            try {
                if (connection != null)
                    connection.close();
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
            } catch (SQLException ignored) {}
        }
    }

    protected Integer count(String query, Object... parameters) {
        Connection connection = null;
        PreparedStatement prepareStatement = null;
        ResultSet resultSet = null;
        try {
            Integer count = 0;
            connection = getConnection();

            //Khởi tạo các tham số cho câu lệnh truy vấn
            prepareStatement = connection.prepareStatement(query);
            setParameter(prepareStatement, parameters);

            //Thực hiện truy vấn
            resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                count = (Integer)resultSet.getInt(1);
            }
            return count;
        } catch (SQLException e) {
            return null;
        } finally {
            try {
                if (connection != null)
                    connection.close();
                if (prepareStatement != null)
                    prepareStatement.close();
                if (resultSet != null)
                    resultSet.close();
            } catch (SQLException ignored) {}
        }
    }
}
