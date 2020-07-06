package club.banyuan.service.impl;

import club.banyuan.dao.AddressDao;
import club.banyuan.dao.impl.AddressDaoImpl;
import club.banyuan.entity.Address;
import club.banyuan.service.AddressService;
import club.banyuan.util.JdbcUtils;

import java.sql.SQLException;
import java.util.List;

public class AddressServiceImpl implements AddressService {
    @Override
    public int add(Address address) throws SQLException {
        AddressDao addressDao=new AddressDaoImpl(JdbcUtils.getConnection());
        int i=addressDao.add(address);
        return i;
    }

    @Override
    public List<Address> getAddressByID(int id) throws Exception {
        AddressDao addressDao=new AddressDaoImpl(JdbcUtils.getConnection());
        List<Address> addressList=addressDao.getAddressByID(id);
        return addressList;
    }


}
