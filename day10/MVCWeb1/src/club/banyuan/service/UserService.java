package club.banyuan.service;

import club.banyuan.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    public User login(String username, String password) throws SQLException;
    public int add(User user) throws SQLException;
    public String getDefaultAddress(int userId) throws SQLException;
}
