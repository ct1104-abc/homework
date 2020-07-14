package club.banyuan.dao;

import club.banyuan.entity.User;

public interface UserDao {
    public int addUser(User user);
    public User getLoginUser(User user);
    public String getDefaultAddress(int userId);
}
