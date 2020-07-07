package club.banyuan.dao.impl;

import club.banyuan.dao.UserDao;
import club.banyuan.entity.Product;
import club.banyuan.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {

    public UserDaoImpl(Connection conn){
        super(conn);
    }

    @Override
    public int add(User user) {
        String sql = "insert into user(id,loginName,userName,password,sex,email,mobile) values(null,?,?,?,?,?,?)";
        Object[] params = new Object[]{user.getLoginName()
        ,user.getUserName(),user.getPassword(),user.getSex(),user.getEmail(),user.getMobile()};
        int i= executeInsert(sql,params);
        return i;
    }

    @Override
    public User getLoginUser(String loginName, String pwd) {
        String sql = "select * from user where loginName=? and password=?";
        ResultSet rs = executeQuery(sql,new Object[]{loginName,pwd});
        User user = null;
        try {
            if(rs.next()){
                user = tableToClass(rs);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return user;
    }

    @Override
    public String getDefaultAddress(int userId) throws SQLException {
        String sql="select address from user_address where userId =? and isDefault=1";
        ResultSet rs=executeQuery(sql,new Object[]{userId});
        if(rs.next()){
            return rs.getString(1);
        }
        return null;
    }


    @Override
    public User tableToClass(ResultSet rs) throws Exception {
        User user = new User(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    null,rs.getInt(5),
                    rs.getString(7),rs.getString(8));

        return user;
    }
}
