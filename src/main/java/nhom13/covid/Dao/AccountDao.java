package nhom13.covid.Dao;

import nhom13.covid.Dao.mapper.AccountMapper;
import nhom13.covid.Model.Account;

import java.util.List;

public class AccountDao extends AbstractDao<Account> {
    Account getByUserName(Integer userName) {
        String query = "Select * FROM ACCOUNT WHERE Username = ?";
        List<Account> accounts = super.query(query,new AccountMapper(), userName);
        if (accounts == null || accounts.isEmpty())
            return null;
        else
            return accounts.get(0);
    }
}
