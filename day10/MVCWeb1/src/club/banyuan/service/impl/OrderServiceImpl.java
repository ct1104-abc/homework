package club.banyuan.service.impl;

import club.banyuan.dao.OrderDao;
import club.banyuan.dao.OrderDetailDao;
import club.banyuan.dao.impl.OrderDaoImpl;
import club.banyuan.dao.impl.OrderDetailImpl;
import club.banyuan.entity.Order;
import club.banyuan.entity.OrderDetail;
import club.banyuan.service.OrderService;
import club.banyuan.util.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    @Override
    public void createOrder(Order order, List<OrderDetail> orderDetailList) throws SQLException {
        Connection conn=JdbcUtils.getConnection();
        OrderDao orderDao=new OrderDaoImpl(conn);
        orderDao.addOrder(order);
        OrderDetailDao orderDetailDao=new OrderDetailImpl(conn);
        for(int i=0;i<orderDetailList.size();i++){
            orderDetailDao.addOrderDetail(orderDetailList.get(i));
        }
    }
}
