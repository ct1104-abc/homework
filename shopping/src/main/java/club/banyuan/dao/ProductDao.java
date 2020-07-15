package club.banyuan.dao;

import club.banyuan.entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
    public List<Product> selectall(Integer beauction);
    public Product selectById(Integer id);
    public int add(Product product);
    public int delete(Integer id);
    public int updade(Product product);
    public List<Product> search(String sqls);
    public List<Product> selectBe(Integer beauction);
}
