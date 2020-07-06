package club.banyuan.service;

import club.banyuan.entity.Order;

import java.sql.SQLException;

public interface OrderService {
    public void add(Order order) throws SQLException;
}
