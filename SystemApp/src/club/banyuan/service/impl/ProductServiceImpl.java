package club.banyuan.service.impl;

import club.banyuan.dao.ProductDao;
import club.banyuan.dao.impl.ProductDaoImpl;
import club.banyuan.eneity.Product;
import club.banyuan.service.ProductService;
import club.banyuan.util.JdbcUtils;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Override
    public List<Product> selectall() throws Exception {
        ProductDao productDao=new ProductDaoImpl(JdbcUtils.getConnection());
        return productDao.selectall();
    }

    @Override
    public Product selectById(Integer id) throws Exception {
        ProductDao productDao=new ProductDaoImpl(JdbcUtils.getConnection());
        Product product=productDao.selectById(id);
        return product;
    }
}
