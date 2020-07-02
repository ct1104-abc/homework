package homework;

public class indent_detail {
    private Integer id;
    private String userName;
    private String productName;
    private Integer quantity;
    private Float cost;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "indent_detail{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", cost=" + cost +
                '}';
    }
}
