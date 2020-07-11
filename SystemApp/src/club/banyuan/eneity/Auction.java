package club.banyuan.eneity;

import java.util.Date;

public class Auction {
    private Integer id;
    private Integer userid;
    private String loginName;
    private Integer productid;
    private Double price;
    private Date auctiontime;

    public Auction() {
    }

    public Auction(Integer id, Integer userid, String loginName, Integer productid, Double price, Date auctiontime) {
        this.id = id;
        this.userid = userid;
        this.loginName = loginName;
        this.productid = productid;
        this.price = price;
        this.auctiontime = auctiontime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getAuctiontime() {
        return auctiontime;
    }

    public void setAuctiontime(Date auctiontime) {
        this.auctiontime = auctiontime;
    }

    @Override
    public String toString() {
        return "Auction{" +
                "id=" + id +
                ", userid=" + userid +
                ", loginName='" + loginName + '\'' +
                ", productid=" + productid +
                ", price=" + price +
                ", auctiontime=" + auctiontime +
                '}';
    }
}
