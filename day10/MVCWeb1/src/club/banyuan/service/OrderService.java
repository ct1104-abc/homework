package club.banyuan.service;

import club.banyuan.entity.Order;
import club.banyuan.entity.OrderDetail;

import java.sql.SQLException;
import java.util.List;

public interface OrderService {
    public void createOrder(Order order, List<OrderDetail> orderDetailList) throws SQLException;
}
