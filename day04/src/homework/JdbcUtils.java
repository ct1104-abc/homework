package homework;

import java.sql.*;

public class JdbcUtils {
    private static String URL="jdbc:mysql://localhost:3306/shoppingstreet";
    private static String USER="root";
    private static String PWD="rootroot";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USER,PWD);
    }

    public static void close(Statement stmt, Connection conn) throws SQLException {
        if(stmt != null){
            stmt.close();
        }
        if(conn !=null){
            conn.close();
        }

    }
    public static  void close(Statement stmt, Connection conn, ResultSet rs) throws SQLException {
        if(rs!=null){
            rs.close();
        }
        close(stmt,conn);
    }
}

