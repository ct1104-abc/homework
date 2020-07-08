package club.banyuan.service.impl;

import club.banyuan.dao.ManageDao;
import club.banyuan.dao.impl.ManageDaoImpl;
import club.banyuan.eneity.Manage;
import club.banyuan.eneity.User;
import club.banyuan.service.ManageService;
import club.banyuan.util.JdbcUtils;

import java.sql.SQLException;

public class ManageServiceImpl implements ManageService {
    @Override
    public Manage login(String loginName, String password) throws SQLException {
        ManageDao manageDao=new ManageDaoImpl(JdbcUtils.getConnection());
        return  manageDao.getLogin(loginName,password);

    }
}
