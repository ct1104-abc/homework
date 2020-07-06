package club.banyuan.dao;

import club.banyuan.entity.User;

import java.util.List;

public interface UserDao extends IBaseDao{
    public int add(User user);
    public User getLoginUser(String loginName,String pwd);
}
