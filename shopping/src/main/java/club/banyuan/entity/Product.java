package club.banyuan.entity;

import java.util.Date;

public class Product {
    private Integer id;
    private String pname;
    private Double beginprice;
    private Double endprice;
    private Date beginTime;
    private Date endTime;
    private String description;
    private Integer beauction;

    public Product() {
    }

    public Product(Integer id, String pname, Double beginprice, Double endprice, Date beginTime, Date endTime, String description, Integer beauction) {
        this.id = id;
        this.pname = pname;
        this.beginprice = beginprice;
        this.endprice = endprice;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.description = description;
        this.beauction = beauction;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Double getBeginprice() {
        return beginprice;
    }

    public void setBeginprice(Double beginprice) {
        this.beginprice = beginprice;
    }

    public Double getEndprice() {
        return endprice;
    }

    public void setEndprice(Double endprice) {
        this.endprice = endprice;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getBeauction() {
        return beauction;
    }

    public void setBeauction(Integer beauction) {
        this.beauction = beauction;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", pname='" + pname + '\'' +
                ", beginprice=" + beginprice +
                ", endprice=" + endprice +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", description='" + description + '\'' +
                ", beauction=" + beauction +
                '}';
    }
}
