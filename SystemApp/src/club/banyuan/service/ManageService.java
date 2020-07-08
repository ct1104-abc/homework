package club.banyuan.service;

import club.banyuan.eneity.Manage;


import java.sql.SQLException;

public interface ManageService {
    public Manage login(String loginName, String password) throws SQLException;
}
