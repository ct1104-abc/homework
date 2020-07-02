package club;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name=sc.nextLine();
        System.out.println("请输入密码：");
        String password=sc.nextLine();

        try {
            validate(name,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public static void validate(String name,String password) throws SQLException {
       Connection conn=JdbcUtils.getConnection();
       String sql="select * from user where name=? and password=?";
        PreparedStatement pstmt=conn.prepareStatement(sql);
        pstmt.setString(1,name);
        pstmt.setString(2,password);
        ResultSet rs= pstmt.executeQuery();
        if(rs.next()){
            System.out.println("登录成功");
        }else
            System.out.println("登录失败");
        JdbcUtils.close(pstmt,conn,rs);


    }
}
