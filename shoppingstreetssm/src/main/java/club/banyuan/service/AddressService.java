package club.banyuan.service;

import club.banyuan.entity.Address;

import java.util.List;

public interface AddressService {
    public int add(Address address);
    public List<Address> getAddressByID(int id);
}
