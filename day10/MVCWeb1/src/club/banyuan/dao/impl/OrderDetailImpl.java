package club.banyuan.dao.impl;

import club.banyuan.dao.OrderDetailDao;
import club.banyuan.entity.Order;
import club.banyuan.entity.OrderDetail;

import java.sql.Connection;
import java.sql.ResultSet;

public class OrderDetailImpl extends BaseDaoImpl implements OrderDetailDao {
    public OrderDetailImpl(Connection connection) {
        super(connection);
    }

    @Override
    public OrderDetail addOrderDetail(OrderDetail detail) {
        Integer id = 0;
        String sql = " insert into order_detail(orderId,productId,quantity,cost) values(?,?,?,?) ";
        try {
            Object param[] = new
                    Object[]{detail.getOrderId(),detail.getProductId(),detail.getQuantity(),detail.getCost()};
            id = this.executeInsert(sql, param);
            detail.setId(id);
        } catch (Exception e) {
            this.closeResource();
            e.printStackTrace();
        }
        return detail;
    }

    @Override
    public Object tableToClass(ResultSet rs) throws Exception {
        OrderDetail detail = new OrderDetail();
        detail.setId(rs.getInt("id"));
        detail.setOrderId(rs.getInt("orderId"));
        detail.setProductId(rs.getInt("productId"));
        detail.setQuantity(rs.getInt("quantity"));
        detail.setCost(rs.getDouble("cost"));
        return detail;
    }
}
