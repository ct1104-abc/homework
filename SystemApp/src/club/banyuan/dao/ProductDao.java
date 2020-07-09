package club.banyuan.dao;

import club.banyuan.eneity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao extends IBaseDao {
    public List<Product> selectall() throws Exception;
    public Product selectById(Integer id) throws Exception;
}
