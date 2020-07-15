package club.banyuan.test;

import club.banyuan.dao.AuctionDao;
import club.banyuan.dao.ProductDao;
import club.banyuan.entity.Product;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestProductDao {
    InputStream ins;
    SqlSession session;
    ProductDao productDao;
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
        productDao = session.getMapper(ProductDao.class);
    }

    @Test
    public void Testselectall(){
        List<Product> productList=new ArrayList<>();
        productList=productDao.selectall(0);
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    @Test
    public void TestselectById(){
        Product product=new Product();
        product=productDao.selectById(1);
        System.out.println(product);
    }

    @Test
    public void Testadd(){
        Product product=new Product();
        product.setPname("dsfsd");
        product.setBeginprice(142342.0);
        product.setEndprice(343656.0);
        product.setBeginTime(new Date());
        product.setEndTime(new Date());
        product.setDescription("dsfsdf");
        productDao.add(product);
    }

    @Test
    public void Testdelete(){
        productDao.delete(6);
    }

    @Test
    public void Testupdade(){
        Product product=new Product();
        product.setId(5);
        product.setPname("abc");
        product.setBeginprice(1234.0);
        product.setEndprice(5678.0);
        product.setBeginTime(new Date());
        product.setEndTime(new Date());
        product.setDescription("123123");
        productDao.updade(product);
    }

    @Test
    public void TestselectBe(){
        List<Product>productList=new ArrayList<>();
        productList=productDao.selectBe(1);
        for (Product product : productList) {
            System.out.println(product);
        }
    }


    @After
    public void destrory() throws IOException {
        session.commit();
        session.close();
        ins.close();
    }
}
