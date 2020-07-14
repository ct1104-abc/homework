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
import java.util.List;

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
    public void testAddUser(){
        User user = new User();
        user.setLoginName("fdsgdfgdf");
        user.setPassword("123");
        user.setUserName("zxz");
        user.setSex(1);
        user.setMobile("1234678");
        user.setEmail("sdf@dfs.com");

        int i = userDao.addUser(user);
        System.out.println(i);
        System.out.println(user.getId());
    }

    @Test
    public void testgetLoginUser(){
        User user=new User();
        user.setLoginName("fdsgdfgdf");
        user.setPassword("123");
        User user1=userDao.getLoginUser(user);
        System.out.println(user1);
    }

    @Test
    public void getDefaultAddress(){
        String address;
        address=userDao.getDefaultAddress(23);
        System.out.println(address);
    }


    @After
    public void destrory() throws IOException {
        session.commit();
        session.close();
        ins.close();
    }
}
