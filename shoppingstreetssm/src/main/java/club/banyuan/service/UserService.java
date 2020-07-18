package club.banyuan.service;


import club.banyuan.entity.User;

import java.util.Map;

public interface UserService {

    public int add(User user);
    public User getLoginUser(Map map);
    public String getDefaultAddress(int userId);
}
