package club.banyuan.service.impl;

import club.banyuan.dao.ProductDao;
import club.banyuan.dao.impl.ProductDaoImpl;
import club.banyuan.eneity.Product;
import club.banyuan.service.ProductService;
import club.banyuan.util.JdbcUtils;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Override
    public List<Product> selectall(Integer beauction) throws Exception {
        ProductDao productDao=new ProductDaoImpl(JdbcUtils.getConnection());
        return productDao.selectall(beauction);
    }

    @Override
    public Product selectById(Integer id) throws Exception {
        ProductDao productDao=new ProductDaoImpl(JdbcUtils.getConnection());
        Product product=productDao.selectById(id);
        return product;
    }

    @Override
    public int add(Product product) throws SQLException {
        ProductDao productDao=new ProductDaoImpl(JdbcUtils.getConnection());
        int i=productDao.add(product);
        return i;
    }

    @Override
    public int delete(Integer id) throws SQLException {
        ProductDao productDao=new ProductDaoImpl(JdbcUtils.getConnection());
        int i=productDao.delete(id);
        return i;
    }

    @Override
    public int update(Product product) throws SQLException {
        ProductDao productDao=new ProductDaoImpl(JdbcUtils.getConnection());
        int i=productDao.updade(product);
        return i;
    }

    @Override
    public List<Product> search(String sqls) throws SQLException {
        ProductDao productDao=new ProductDaoImpl(JdbcUtils.getConnection());
        return productDao.search(sqls);
    }

    @Override
    public List<Product> selectBe(Integer beauction) throws SQLException {
        ProductDao productDao=new ProductDaoImpl(JdbcUtils.getConnection());
        return productDao.selectBe(beauction);
    }


}
