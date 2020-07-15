package club.banyuan.test;

import club.banyuan.dao.AuctionDao;
import club.banyuan.dao.ManageDao;
import club.banyuan.entity.Auction;
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

public class TestAuctionDao {
    InputStream ins;
    SqlSession session;
    AuctionDao auctionDao;
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
       auctionDao = session.getMapper(AuctionDao.class);
    }
    @Test
    public void TestselectByPId(){
        List<Auction> auctionList=new ArrayList<>();
        auctionList=auctionDao.selectByPId(1);
        for (Auction auction : auctionList) {
            System.out.println(auction);
        }
    }

    @Test
    public void TestaddAuction(){
        Auction auction=new Auction();
        auction.setUserid(123);
        auction.setLoginName("ct13");
        auction.setProductid(1);
        auction.setPrice(13212.0);
        auction.setAuctiontime(new Date());
        auctionDao.addAuction(auction);
    }
    @Test
    public void TestselectResultByPId(){
        Auction auction=new Auction();
        auction=auctionDao.selectResultByPId(1);
        System.out.println(auction);
    }

    @Test
    public void TestselectResult(){
        List<Auction> auctionList=new ArrayList<>();
        auctionList=auctionDao.selectResult(1);
        for (Auction auction : auctionList) {
            System.out.println(auction);
        }
    }

    @After
    public void destrory() throws IOException {
        session.commit();
        session.close();
        ins.close();
    }
}
