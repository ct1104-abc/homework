package club.banyuan.dao.impl;

import club.banyuan.dao.ProductDao;
import club.banyuan.eneity.Auction;
import club.banyuan.eneity.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductDaoImpl extends BaseDaoImpl implements ProductDao {
    public ProductDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public List<Product> selectall(Integer beauction) throws Exception {
        List<Product> productList=new ArrayList<>();
        String sql="select * from product where beauction = ?";
        ResultSet rs=executeQuery(sql,new Object[]{beauction});
        while(rs.next()){
            Product product=this.tableToClass(rs);
            System.out.println(product.getPname());
            productList.add(product);
        }
        this.closeResource(rs);
        this.closeResource();
        return productList;
    }

    @Override
    public Product selectById(Integer id) throws Exception {
        Product product=null;
        String sql="select * from product where id=?";

        ResultSet rs=executeQuery(sql,new Object[]{id});
        while(rs.next()){
            product=this.tableToClass(rs);
            System.out.println(product.getId());

        }
        this.closeResource(rs);
        this.closeResource();
        return  product;
    }

    @Override
    public int add(Product product) {
        String sql="insert into product(id,pname,beginprice,endprice,beginTime,endTime,description,beauction)values(null,?,?,?,?,?,?,0)";
        Object[] params=new Object[]{product.getPname(),product.getBeginprice(),product.getEndprice(),product.getBeginTime()
        ,product.getEndTime(),product.getDescription()};
        System.out.println(product);

        int i=executeInsert(sql,params);
        this.closeResource();
        return i;
    }

    @Override
    public int delete(Integer id) {
        String sql="delete from product where id=?";
        int i=executeUpdate(sql,new Object[]{id});
        this.closeResource();
        return i;
    }

    @Override
    public int updade(Product product) {
        String sql="update product set pname=?,beginprice=?,endprice=?,beginTime=?,endTime=?,description=?,beauction=0 where id=?";
        Object[] params=new Object[]{product.getPname(),product.getBeginprice(),product.getEndprice(),product.getBeginTime(),product.getEndTime(),product.getDescription(),product.getId()};
        int i=executeUpdate(sql,params);
        this.closeResource();
        return i;
    }

    @Override
    public List<Product> search(String sqls) throws SQLException {
        List<Product> productList=new ArrayList<>();
        ResultSet rs=executeQuery(sqls,new Object[]{});
        while(rs.next()){
            try {
                Product product=this.tableToClass(rs);
                productList.add(product);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.closeResource(rs);
        this.closeResource();
        return productList;
    }

    @Override
    public List<Product> selectBe(Integer beauction) throws SQLException {
        List<Product> productList=new ArrayList<>();
        String sql="select * from product where beauction=?";
        ResultSet rs=executeQuery(sql,new Object[]{beauction});
        while(rs.next()){
            try {
                Product product=this.tableToClass(rs);
                productList.add(product);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return productList;
    }


    @Override
    public Product tableToClass(ResultSet rs) throws Exception {
        Product product=new Product(rs.getInt(1),rs.getString(2),
                rs.getDouble(3),rs.getDouble(4),
                rs.getTimestamp(5),rs.getTimestamp(6),rs.getString(7),rs.getInt(8));
        return product;
    }
}
