package club.banyuan.eneity;

public class User {
    private Integer id;
    private String loginName;
    private String password;
    private Integer identityCode;
    private String mobile;
    private String address;
    private Integer idaddress;

    public User() {
    }

    public User(Integer id, String loginName, String password, Integer identityCode, String mobile, String address, Integer idaddress) {
        this.id = id;
        this.loginName = loginName;
        this.password = password;
        this.identityCode = identityCode;
        this.mobile = mobile;
        this.address = address;
        this.idaddress = idaddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIdentityCode() {
        return identityCode;
    }

    public void setIdentityCode(Integer identityCode) {
        this.identityCode = identityCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getIdaddress() {
        return idaddress;
    }

    public void setIdaddress(Integer idaddress) {
        this.idaddress = idaddress;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", identityCode=" + identityCode +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                ", idaddress=" + idaddress +
                '}';
    }
}
