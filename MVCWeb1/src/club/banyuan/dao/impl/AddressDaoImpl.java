package club.banyuan.dao.impl;

import club.banyuan.dao.AddressDao;
import club.banyuan.entity.Address;
import sun.jvm.hotspot.tools.SysPropsDumper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AddressDaoImpl extends BaseDaoImpl implements AddressDao {
    public AddressDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public int add(Address address) {
        String sql="insert into user_address (id,userId,address,createTime,isDefault,remark) values(null,?,?,null,0,?)";
        Object[] param=new Object[]{address.getUserId(),address.getUserId(),address.getAddress(),address.getCreateTime(),address.getIsDefault(),address.getRemark()};
        int i=executeInsert(sql,param);
        return i;
    }

    @Override
    public List<Address> getAddressByID(int id) throws Exception {
            String sql="select * from user_address where userId=?";
            Object[] param=new Object[]{id};
            ResultSet rs=executeQuery(sql,param);
            List<Address> addressList=new ArrayList<>();
            while(rs.next()){
                Address address=tableToClass(rs);
                addressList.add(address);
            }
            return addressList;

    }

    @Override
    public Address tableToClass(ResultSet rs) throws Exception {
        Address address=new Address();
        address.setId(rs.getInt("id"));
        address.setUserId(rs.getInt("userId"));
        address.setAddress(rs.getString("address"));
        address.setCreateTime(rs.getDate("createTime"));
        address.setIsDefault(rs.getInt("isDefault"));
        address.setRemark(rs.getString("remark"));
        return address;
    }
}
