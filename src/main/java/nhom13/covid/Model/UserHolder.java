//Thanh vien xay dung: An, Dat

package nhom13.covid.Model;

//Singleton Class
//luon chi co 1 user xuyen suot chuong trinh
public final class UserHolder {

    private Account user;
    private final static UserHolder INSTANCE = new UserHolder();

    //de khong the khoi tao
    private UserHolder() {}

    public static UserHolder getInstance() {
        return INSTANCE;
    }

    public void setUser(Account u) {
        this.user = u;
    }

    public Account getUser() {
        return this.user;
    }
}