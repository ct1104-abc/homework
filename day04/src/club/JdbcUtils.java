package club;

import javax.xml.transform.Result;
import java.sql.*;

public class JdbcUtils {
            //设置jdbc连接数据库的url，登录数据的用户名和密码
            private static String URL="jdbc:mysql://localhost:3306/db1";
            private static String USER= "root";
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
