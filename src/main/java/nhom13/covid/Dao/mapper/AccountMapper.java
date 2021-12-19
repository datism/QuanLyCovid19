package nhom13.covid.Dao.mapper;

import nhom13.covid.Model.Account;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet resultSet) {
        try {
          Account account = new Account();
          account.setUserName(resultSet.getInt("Username"));
          account.setPassword(resultSet.getString("Password"));
          account.setAccess(resultSet.getInt("ACCESS"));
          return account;
        } catch (SQLException e) {
            return null;
        }
    }
}
