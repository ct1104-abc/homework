package club.banyuan.dao.impl;

import club.banyuan.dao.ProductDao;
import club.banyuan.eneity.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl extends BaseDaoImpl implements ProductDao {
    public ProductDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public List<Product> selectall() throws Exception {
        List<Product> productList=new ArrayList<>();
        String sql="select * from product where pname like ?";
        String s = "%"+""+"%";
        ResultSet rs=executeQuery(sql,new Object[]{s});
        while(rs.next()){
            Product product=this.tableToClass(rs);
            System.out.println(product.getPname());
            productList.add(product);
        }

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
        return  product;
    }

    @Override
    public Product tableToClass(ResultSet rs) throws Exception {
        Product product=new Product(rs.getInt(1),rs.getString(2),
                rs.getFloat(3),rs.getFloat(4),
                rs.getTime(5),rs.getTime(6),rs.getString(7));
        return product;
    }
}
