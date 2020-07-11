package club.banyuan.service;

import club.banyuan.eneity.Product;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface ProductService {
    public List<Product> selectall(Integer beauction) throws Exception;
    public Product selectById(Integer id) throws Exception;
    public int add(Product product) throws SQLException;
    public int delete(Integer id) throws SQLException;
    public int update(Product product) throws SQLException;
    public List<Product> search(String sqls) throws SQLException;
    public List<Product> selectBe(Integer beauction) throws SQLException;
}
