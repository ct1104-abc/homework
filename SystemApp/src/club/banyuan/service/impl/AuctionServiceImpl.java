package club.banyuan.service.impl;

import club.banyuan.dao.AuctionDao;
import club.banyuan.dao.impl.AuctionDaoImpl;
import club.banyuan.eneity.Auction;
import club.banyuan.service.AuctionService;
import club.banyuan.util.JdbcUtils;

import java.sql.SQLException;
import java.util.List;

public class AuctionServiceImpl implements AuctionService {
    @Override
    public List<Auction> selectByPId(Integer id) throws SQLException {
        AuctionDao auctionDao=new AuctionDaoImpl(JdbcUtils.getConnection());
        return auctionDao.selectByPId(id);
    }

    @Override
    public int addAuction(Auction auction) throws SQLException {
        AuctionDao auctionDao=new AuctionDaoImpl(JdbcUtils.getConnection());
        return auctionDao.addAuction(auction);
    }

    @Override
    public Auction selectResultByPId(Integer pid) throws SQLException {
        AuctionDao auctionDao=new AuctionDaoImpl(JdbcUtils.getConnection());
        Auction auction=auctionDao.selectResultByPId(pid);
        return auction;
    }

    @Override
    public List<Auction> selectResult(Integer pid) throws SQLException {
        AuctionDao auctionDao=new AuctionDaoImpl(JdbcUtils.getConnection());
        return auctionDao.selectResult(pid);
    }
}
