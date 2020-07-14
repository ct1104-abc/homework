package club.banyuan.test;

import club.banyuan.dao.OrderDao;
import club.banyuan.dao.ProductDao;
import club.banyuan.entity.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestOrderDao {
    InputStream ins;
    SqlSession session;
    OrderDao orderDao;
    @Before
    public void init() throws IOException {
        // 加载配置文件
        ins = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获取用于创建SqlSessionFactory对象的类的对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = builder.build(ins);
        // 创建SqlSession对象
        session = sqlSessionFactory.openSession();
        // 获取接口的实现类对象
        // 动态代理设计模式，获取接口的实现类对象
        orderDao = session.getMapper(OrderDao.class);
    }
    @Test
    public void testaddOrder(){
       // userId},#{loginName},#{userAddress},#{createTime},#{cost},#{serialNumber}
        Order order=new Order();
        order.setUserId(1);
        order.setLoginName("adfsf");
        order.setUserAddress("fdsdgs");
        order.setCost(99983.0);
        order.setSerialNumber("60B7487F47F9434EAA5FD1D9E22CB06C");
        Order order1=orderDao.addOrder(order);
        System.out.println(order1);

    }


    @After
    public void destrory() throws IOException {
        session.commit();
        session.close();
        ins.close();
    }
}
