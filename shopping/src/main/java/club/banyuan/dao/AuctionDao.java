package club.banyuan.dao;

import club.banyuan.entity.Auction;

import java.sql.SQLException;
import java.util.List;

public interface AuctionDao {
    public List<Auction> selectByPId(Integer id) ;
    public int addAuction(Auction auction);
    public Auction selectResultByPId(Integer pid);
    public List<Auction> selectResult(Integer pid);
}
