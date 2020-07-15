package club.banyuan.test;

import club.banyuan.dao.ManageDao;
import club.banyuan.dao.UserDao;
import club.banyuan.entity.Manage;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestManageDao {
    InputStream ins;
    SqlSession session;
    ManageDao manageDao;
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
        manageDao = session.getMapper(ManageDao.class);
    }

    @Test
    public void TestgetLogin(){
        Manage manage=new Manage();
        manage.setLoginName("qqq");
        manage.setPassword("123");
        manageDao.getLogin(manage);
    }

    @After
    public void destrory() throws IOException {
        session.commit();
        session.close();
        ins.close();
    }
}
