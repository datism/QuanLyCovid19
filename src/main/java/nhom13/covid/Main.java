package nhom13.covid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=Quanlycovid19;";
    private static String USER_NAME = "admin";
    private static String PASSWORD = "1";


    public static void main(String args[]) {
        try {
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static Connection getConnection(String dbURL, String userName,
                                           String password) {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
}