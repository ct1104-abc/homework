package club;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class jdbc4 {
    public static void main(String[] args) {
        try {
            selectall();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public static void selectall() throws SQLException {
        List<dept> deptList=new ArrayList<>();
        Connection conn=JdbcUtils.getConnection();
        String sql="select * from user";
        PreparedStatement pstmt=conn.prepareStatement(sql);
        ResultSet rs=pstmt.executeQuery();

        while(rs.next()){
            dept dept1 = new dept();
            dept1.setId(rs.getInt(1));
            dept1.setName(rs.getString(2));
            dept1.setPassword(rs.getString(3));
            deptList.add(dept1);
        }
        for(dept dept1:deptList)
            System.out.println(dept1);
        JdbcUtils.close(pstmt,conn,rs);
    }
}
