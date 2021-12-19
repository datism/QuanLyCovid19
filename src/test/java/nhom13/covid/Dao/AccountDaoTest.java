package nhom13.covid.Dao;

import nhom13.covid.Model.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountDaoTest {

    @Test
    void getByUserName() {
        AccountDao accountDao = new AccountDao();
        Account account = accountDao.getByUserName(8564649);
        assertNotNull(account);
    }
}