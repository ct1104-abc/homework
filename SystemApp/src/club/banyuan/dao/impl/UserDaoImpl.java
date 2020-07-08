package club.banyuan.dao.impl;

import club.banyuan.dao.UserDao;
import club.banyuan.eneity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {
    public UserDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public int add(User user) {
        String sql="insert into user (id,loginName,password,identityCode,mobile,address,idaddress)values(null,?,?,?,?,?,?)";
        Object[] params=new Object[]{user.getLoginName(),user.getPassword(),user.getIdentityCode(),user.getMobile(),user.getAddress(),user.getIdaddress()};
        int i=executeInsert(sql,params);
        return i;
    }

    @Override
    public User getLoginUser(String loginName, String pwd) {
        String sql="select * from user where loginName=? and password=?";
        ResultSet rs=executeQuery(sql, new Object[]{loginName,pwd} );
        User user=null;
        try {
            if(rs.next()){
                user=tableToClass(rs);
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public User tableToClass(ResultSet rs) throws Exception {
        User user=new User(rs.getInt(1),rs.getString(2),rs.getString(3),
                rs.getInt(4),rs.getString(5),rs.getString(6),
                rs.getInt(7));
        return user;
    }
}
