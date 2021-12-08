/** Mạnh Thắng **/
package nhom13.covid;

import java.sql.Connection;
import java.sql.DriverManager;

public class connect {
    private static String DB_URL = "jdbc:sqlserver://DESKTOP-BEHHFN5\\SQLEXPRESS:1433;databaseName=Quanlycovid19";
    private static String USER_NAME = "sa";
    private static String PASSWORD = "luthang2001";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
}
