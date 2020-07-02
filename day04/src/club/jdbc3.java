package club;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class jdbc3 {
    public static void main(String[] args) {
        Connection conn=null;
        Statement stmt=null;
        try{
            conn= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db1",
                    "root","rootroot");

            stmt=conn.createStatement();
            int i =stmt.executeUpdate("INSERT INTO `news` VALUES ('597', '迎双旦促销大酬宾', '迎双旦促销大酬宾', '2010-12-24');");
           // i+=stmt.executeUpdate("INSERT INTO `news` VALUES ('649', '加入会员，赢千万大礼包', '加入会员，赢千万大礼包', '2010-12-22');");
            System.out.println(i>=1? "ok":"false");

            /*int i=stmt.executeUpdate("update news set title='sfdsfsdf' where id=597;\n");
            System.out.println(i>=1? "ok":"false");*/

            /*int i=stmt.executeUpdate("delete from news where id=597");
            System.out.println(i>=1?"ok":"false");*/

            ResultSet rs=stmt.executeQuery("select * from news");
            System.out.println("id\t\ttitle\t\tcontent\t\tcreateTime");
            while(rs.next()){
                int id=rs.getInt(1);
                String title=rs.getString(2);
                String content=rs.getString(3);
                Date createTime=rs.getDate(4);
                System.out.println(id+"\t"+title+"\t"+content+"\t"+createTime);
            }

        }catch(SQLException throwables){
            throwables.printStackTrace();
        }finally {
            if(stmt != null){
                try{
                    stmt.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
                if(conn !=null){
                    try{
                        conn.close();
                    }catch (SQLException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
