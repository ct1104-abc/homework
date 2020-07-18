package club.banyuan.service.impl;

import club.banyuan.dao.AddressDao;
import club.banyuan.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService implements club.banyuan.service.AddressService {
    @Autowired
    private AddressDao addressDao;

    public int add(Address address) {
        return addressDao.add(address);
    }

    public List<Address> getAddressByID(int id) {
        return addressDao.getAddressByID(id);
    }
}
