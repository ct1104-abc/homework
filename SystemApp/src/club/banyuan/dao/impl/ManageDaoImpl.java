package club.banyuan.dao.impl;

import club.banyuan.dao.ManageDao;
import club.banyuan.eneity.Manage;


import java.sql.Connection;
import java.sql.ResultSet;

public class ManageDaoImpl extends BaseDaoImpl implements ManageDao {
    public ManageDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Manage getLogin(String loginName, String password) {
        String sql="select * from manage where loginName=? and password=?";

        ResultSet rs=executeQuery(sql, new Object[]{loginName,password} );
        Manage manage=null;
        try {
            if(rs.next()){
                manage=tableToClass(rs);
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return manage;
    }

    @Override
    public Manage tableToClass(ResultSet rs) throws Exception {
        Manage manage=new Manage(rs.getInt(1),rs.getString(2),rs.getString(3));
        return manage;
    }
}
