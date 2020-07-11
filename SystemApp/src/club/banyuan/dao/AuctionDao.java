package club.banyuan.dao;

import club.banyuan.eneity.Auction;

import java.sql.SQLException;
import java.util.List;

public interface AuctionDao extends IBaseDao {
    public List<Auction> selectByPId(Integer id) throws SQLException;
    public int addAuction(Auction auction);
    public Auction selectResultByPId(Integer pid) throws SQLException;
    public List<Auction> selectResult(Integer pid) throws SQLException;

}
