package club.banyuan.dao;

import club.banyuan.entity.Order;

public interface OrderDao extends IBaseDao {
    public void add(Order order);

}
