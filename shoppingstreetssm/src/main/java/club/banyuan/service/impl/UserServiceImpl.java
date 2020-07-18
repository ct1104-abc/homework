package club.banyuan.service.impl;

import club.banyuan.dao.UserDao;
import club.banyuan.entity.User;
import club.banyuan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public int add(User user){
        return userDao.add(user);
    }

    public User getLoginUser(Map map) {
        return userDao.getLoginUser(map);
    }

    public String getDefaultAddress(int userId) {
        return userDao.getDefaultAddress(userId);
    }
}
