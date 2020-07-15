package club.banyuan.test;

import club.banyuan.dao.UserDao;
import club.banyuan.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestUserDao {
    InputStream ins;
    SqlSession session;
    UserDao userDao;
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
        userDao = session.getMapper(UserDao.class);
    }
    @Test
    public void Testadd(){
        User user=new User();
        user.setLoginName("dssdgadg");
        user.setPassword("123");
        user.setIdentityCode(1231234);
        user.setMobile("123");
        user.setAddress("123");
        user.setIdaddress(123);
        userDao.add(user);
    }

    @Test
    public void TestgetLoginUser(){
        User user=new User();
        user.setLoginName("ct123");
        user.setPassword("123");
        userDao.getLoginUser(user);
    }


    @After
    public void destrory() throws IOException {
        session.commit();
        session.close();
        ins.close();
    }

}
