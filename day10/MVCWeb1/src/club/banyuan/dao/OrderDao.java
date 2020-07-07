package club.banyuan.dao;

import club.banyuan.entity.Order;

public interface OrderDao extends IBaseDao {
    public Order addOrder(Order order);

}
