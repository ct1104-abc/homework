package club.banyuan.dao;

import club.banyuan.eneity.Auction;
import club.banyuan.eneity.Product;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface ProductDao extends IBaseDao {
    public List<Product> selectall(Integer beauction) throws Exception;
    public Product selectById(Integer id) throws Exception;
    public int add(Product product);
    public int delete(Integer id);
    public int updade(Product product);
    public List<Product> search(String sqls) throws SQLException;
    public List<Product> selectBe(Integer beauction) throws SQLException;


}
