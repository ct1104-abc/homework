package club.banyuan.dao;

import club.banyuan.eneity.Manage;


public interface ManageDao extends IBaseDao{
    public Manage getLogin(String loginName, String password);
}
