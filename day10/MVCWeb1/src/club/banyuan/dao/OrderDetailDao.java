package club.banyuan.dao;


import club.banyuan.entity.Order;
import club.banyuan.entity.OrderDetail;

public interface OrderDetailDao extends IBaseDao{
    public OrderDetail addOrderDetail(OrderDetail detail);
}
