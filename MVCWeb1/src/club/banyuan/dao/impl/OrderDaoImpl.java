package club.banyuan.dao.impl;

import club.banyuan.dao.OrderDao;
import club.banyuan.entity.Order;

import java.sql.Connection;
import java.sql.ResultSet;

public class OrderDaoImpl extends BaseDaoImpl implements OrderDao {
    public OrderDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public void add(Order order) {
        Integer id = 0;
        String sql = "insert into shoppingStreet.order(userId,loginName,userAddress,createTime,cost,serialNumber ) values(?,?,?,?,?,?) ";
        Object[] param = new Object[]{order.getUserId(), order.getLoginName(), order.getUserAddress(), order.getCreateTime(), order.getCost(), order.getSerialNumber()};
        try {
            id = this.executeInsert(sql, param);
            order.setId(new Integer(id).intValue());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeResource();
        }
    }

    @Override
    public Object tableToClass(ResultSet rs) throws Exception {
        Order order = new Order();
        order.setId(rs.getInt("id"));
        order.setUserId(rs.getInt("userId"));
        order.setCreateTime(rs.getDate("createTime"));
        order.setCost(rs.getDouble("cost"));
        order.setUserAddress(rs.getString("userAddress"));
        order.setSerialNumber(rs.getString("serialNumber"));
        order.setLoginName(rs.getString("loginName"));
        return order;
    }
}
