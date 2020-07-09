package club.banyuan.eneity;

import java.util.Date;

public class Product {
    private Integer id;
    private String pname;
    private Float beginprice;
    private Float endprice;
    private Date beginTime;
    private Date endTime;
    private String description;

    public Product() {
    }

    public Product(Integer id, String pname, Float beginprice, Float endprice, Date beginTime, Date endTime, String description) {
        this.id = id;
        this.pname = pname;
        this.beginprice = beginprice;
        this.endprice = endprice;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.description = description;
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

    public Float getBeginprice() {
        return beginprice;
    }

    public void setBeginprice(Float beginprice) {
        this.beginprice = beginprice;
    }

    public Float getEndprice() {
        return endprice;
    }

    public void setEndprice(Float endprice) {
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
                '}';
    }
}
