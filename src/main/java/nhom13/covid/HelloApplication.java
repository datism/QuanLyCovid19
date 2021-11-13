package nhom13.covid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HelloApplication {
    private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=Quanlycovid19;";
    private static String USER_NAME = "admin";
    private static String PASSWORD = "1";

    /**
     * main
     *
     * @author viettuts.vn
     * @param args
     */
    public static void main(String args[]) {
        try {
            // connnect to database 'testdb'
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
           // Statement stmt = conn.createStatement();
            // get data from table 'student'
           // ResultSet rs = stmt.executeQuery("select * from student");
            // show data
//            while (rs.next()) {
//                System.out.println(rs.getInt(1) + "  " + rs.getString(2)
//                        + "  " + rs.getString(3));
//            }
            // close connection
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

       // System.out.println("hello\n");
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