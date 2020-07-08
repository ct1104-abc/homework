package club.banyuan.service;

import club.banyuan.eneity.User;

import java.sql.SQLException;

public interface UserService {
    public User login(String loginName,String password) throws SQLException;
    public int add(User user) throws SQLException;
}
