package nhom13.covid.Model;

public class Account {
    Integer userName;
    String password;
    Integer access;

    public Account(Integer userName, String password, Integer access) {
        this.userName = userName;
        this.password = password;
        this.access = access;
    }

    public Account() {
    }

    public Integer getUserName() {
        return userName;
    }

    public void setUserName(Integer userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAccess() {
        return access;
    }

    public void setAccess(Integer access) {
        this.access = access;
    }
}
