package club.banyuan.service;

import club.banyuan.entity.Address;

import java.sql.SQLException;
import java.util.List;

public interface AddressService {
    public int add(Address address) throws SQLException;
    public List<Address> getAddressByID(int id) throws Exception;

}
