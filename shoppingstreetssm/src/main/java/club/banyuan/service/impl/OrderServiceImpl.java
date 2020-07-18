package club.banyuan.service.impl;

import club.banyuan.dao.OrderDao;
import club.banyuan.dao.OrderDetailDao;
import club.banyuan.entity.Order;
import club.banyuan.entity.OrderDetail;
import club.banyuan.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderDetailDao orderDetailDao;


    public int addOrder(Order order) {
        return orderDao.addOrder(order);
    }

    public int addOrderDetail(OrderDetail detail) {
        return orderDetailDao.addOrderDetail(detail);
    }

    public void createOrder(Order order, List<OrderDetail> orderDetailList) {

        orderDao.addOrder(order);
        for(int i=0;i<orderDetailList.size();i++){
            orderDetailDao.addOrderDetail(orderDetailList.get(i));
        }
    }
}
