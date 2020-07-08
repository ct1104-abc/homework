package club.banyuan.service.impl;

import club.banyuan.dao.UserDao;
import club.banyuan.dao.impl.UserDaoImpl;
import club.banyuan.eneity.User;
import club.banyuan.service.UserService;
import club.banyuan.util.JdbcUtils;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    @Override
    public User login(String loginName, String password) throws SQLException {
        UserDao userDao=new UserDaoImpl(JdbcUtils.getConnection());
        return userDao.getLoginUser(loginName,password);
    }

    @Override
    public int add(User user) throws SQLException {
        UserDao userDao=new UserDaoImpl(JdbcUtils.getConnection());
        int i=userDao.add(user);
        return i;
    }
}
