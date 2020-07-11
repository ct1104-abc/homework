package club.banyuan.dao.impl;

import club.banyuan.dao.AuctionDao;
import club.banyuan.eneity.Auction;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuctionDaoImpl extends BaseDaoImpl implements AuctionDao {

    public AuctionDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public List<Auction> selectByPId(Integer id) throws SQLException {
        List<Auction> auctionList=new ArrayList<>();
        String sql="select * from auction where productid=?";
        ResultSet rs=executeQuery(sql,new Object[]{id});
        while(rs.next()){
            try {
                Auction auction=this.tableToClass(rs);
                auctionList.add(auction);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return auctionList;
    }

    @Override
    public int addAuction(Auction auction) {
        String sql="insert into auction (id,userid,loginName,productid,price,auctiontime) values (null,?,?,?,?,?)";
        int i=executeInsert(sql,new Object[]{auction.getUserid(),auction.getLoginName(),
                auction.getProductid(),auction.getPrice(),auction.getAuctiontime()});
        return i;
    }

    @Override
    public Auction selectResultByPId(Integer pid) throws SQLException {
        Auction auction=null;
        String sql="select * from auction where productid=? order by price desc limit 0,1";
        ResultSet rs=executeQuery(sql,new Object[]{pid});
        while(rs.next()){
            try {
                auction=this.tableToClass(rs);
                System.out.println(auction);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return auction ;
    }

    @Override
    public List<Auction> selectResult(Integer pid) throws SQLException {
        List<Auction> auctionList=new ArrayList<>();
        String sql="select * from auction where productid=?";
        ResultSet rs=executeQuery(sql,new Object[]{pid});
        while(rs.next()){
            try {
                Auction auction=this.tableToClass(rs);
                auctionList.add(auction);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return auctionList;
    }

    @Override
    public Auction tableToClass(ResultSet rs) throws Exception {
        Auction auction=new Auction(rs.getInt(1),rs.getInt(2),rs.getString(3),
                rs.getInt(4),rs.getDouble(5),rs.getTimestamp(6));

        return auction;
    }
}
