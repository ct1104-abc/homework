package club.banyuan.dao;

import club.banyuan.entity.Address;

import java.util.List;

public interface AddressDao {
    public int add(Address address);
    public List<Address> getAddressByID(int id) throws Exception;
}
