package club.banyuan.service;

import club.banyuan.eneity.Auction;

import java.sql.SQLException;
import java.util.List;

public interface AuctionService {
    public List<Auction> selectByPId(Integer id) throws SQLException;
    public int addAuction(Auction auction) throws SQLException;
    public Auction selectResultByPId(Integer pid) throws SQLException;
    public List<Auction> selectResult(Integer pid) throws SQLException;
}
