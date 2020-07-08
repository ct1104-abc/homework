package club.banyuan.dao;

import club.banyuan.eneity.User;

public interface UserDao extends IBaseDao{
    public int add(User user);
    public User getLoginUser(String loginName,String pwd);
}
