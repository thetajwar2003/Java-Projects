package util;
import java.sql.*;
public class DBConnection {
    private static Connection con = null;
    static {
        String url = "jdbc:mysql://localhost:3306/atm?AllowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
        String user = "myuser";
        String pass = "xxx";
        try {
            con = DriverManager.getConnection(url, user, pass);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() {
        return con;
    }
}
