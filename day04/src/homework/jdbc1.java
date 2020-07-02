package homework;

import java.sql.*;
import java.util.*;

public class jdbc1 {
    public static  String NewName;
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);

        System.out.println("1:登录");
        System.out.println("2:注册");
        int n=sc.nextInt();
        if(n==1){
            LOGIN();
        }else{
            Regist();
        }

    SELECTProduct();




    }
    public static void SELECTProduct(){
        Scanner sc=new Scanner(System.in);
        System.out.println("输入需要查询的商品描述");
        String productname=sc.nextLine();
        try {
            selectProduct(productname,NewName);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            selectall(NewName,productname);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void LOGIN(){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name=sc.nextLine();
        NewName=name;
        System.out.println("请输入密码：");
        String password=sc.nextLine();
        try {
            Login(name,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void Regist(){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name=sc.nextLine();
        System.out.println("请输入密码：");
        String password=sc.nextLine();
        try {
            insertUser(name,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void Login(String name,String password) throws SQLException {
        Connection conn=JdbcUtils.getConnection();
        String sql="select * from user where name=? and password=?";
        PreparedStatement psmt=conn.prepareStatement(sql);
        psmt.setString(1,name);
        psmt.setString(2,password);
        ResultSet rs=psmt.executeQuery();
        if(rs.next()){
            System.out.println("登录成功");
        }else
            System.out.println("登录失败");
        JdbcUtils.close(psmt,conn,rs);
    }
    public static void insertUser(String name,String password) throws SQLException {
        Connection conn=JdbcUtils.getConnection();
        PreparedStatement psmt=conn.prepareStatement("insert into user value (null,?,?)");
        psmt.setString(1,name);
        psmt.setString(2,password);
        int i=psmt.executeUpdate();
        System.out.println(i>=1?"添加成功":"添加失败");
        JdbcUtils.close(psmt,conn);
    }
    public static void selectProduct(String productname,String name) throws SQLException {
         List<Product> productList=new ArrayList<>();
        Connection conn=JdbcUtils.getConnection();
        Statement stmt=conn.createStatement();
        String sql="select * from product where name like '"+productname+"%';";
        ResultSet rs=stmt.executeQuery(sql);

        while(rs.next()){
            Product product=new Product();
            product.setId(rs.getInt(1));
            product.setName(rs.getString(2));
            product.setPrice(rs.getFloat(3));
            product.setStock(rs.getInt(4));
            productList.add(product);
            insertorder(name,product.getPrice(),product.getStock());
        }
        for(Product product:productList){
            System.out.println(product);
        }
        JdbcUtils.close(stmt,conn,rs);


    }
    public static void insertorder(String name,float price,int stock) throws SQLException {
        float sum=0;
        sum=price*stock;
        Connection conn1=JdbcUtils.getConnection();
        String sql1="insert into indent value (null,?,?)";
        PreparedStatement psmt=conn1.prepareStatement(sql1);
        psmt.setString(1,name);
        psmt.setFloat(2,sum);
        int i=psmt.executeUpdate();
        System.out.println(i>=1?"添加成功":"添加失败");
        JdbcUtils.close(psmt,conn1);
    }
    public static void selectall(String name,String productname) throws SQLException {
        List<indent_detail> idList=new ArrayList<>();
        Connection conn=JdbcUtils.getConnection();
        Statement stmt=conn.createStatement();
        String sql="select indent.id,indent.userName,indent_detail.productName,indent_detail.quantity,indent_detail.cost from indent inner join indent_detail on indent.userName=indent_detail.userName where indent.userName='"+name+"';";
        ResultSet rs=stmt.executeQuery(sql);
        while (rs.next()){
            indent_detail id=new indent_detail();
            id.setId(rs.getInt(1));
            id.setUserName(rs.getString(2));
            id.setProductName(rs.getString(3));
            id.setQuantity(rs.getInt(4));
            id.setCost(rs.getFloat(5));
            idList.add(id);
        }
        for(indent_detail id:idList)
            System.out.println(id);
        JdbcUtils.close(stmt,conn,rs);

    }

}