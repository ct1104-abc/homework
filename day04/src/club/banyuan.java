package club;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


    public class banyuan {
        public static void main(String[] args) {
            Connection conn=null;
            Statement stmt=null;
            try{
                conn= DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/db1",
                        "root","rootroot");

                stmt=conn.createStatement();
                String sql="CREATE TABLE `news` (\n" +
                        "  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',\n" +
                        "  `title` varchar(40) NOT NULL COMMENT '标题',\n" +
                        "  `content` varchar(1000) NOT NULL COMMENT '内容',\n" +
                        "  `createTime` varchar(10) NOT NULL COMMENT '创建时间',\n" +
                        "  PRIMARY KEY (`id`),\n" +
                        "  UNIQUE KEY `PK__SS___C63B5EE724927208` (`id`),\n" +
                        "  UNIQUE KEY `UQ__SS___C12AD09D276EDEB3` (`title`)\n" +
                        ") ";
                stmt.executeUpdate(sql);
                System.out.println("ok");
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


