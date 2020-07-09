package club.banyuan.service;

import club.banyuan.eneity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {
    public List<Product> selectall() throws Exception;
    public Product selectById(Integer id) throws Exception;
}
