package club.banyuan.service.impl;

import club.banyuan.dao.ProductDao;
import club.banyuan.dao.impl.ProductDaoImpl;
import club.banyuan.entity.Product;
import club.banyuan.service.ProductService;
import club.banyuan.util.JdbcUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Override
    public List<Product> getProductByName(String pname) throws Exception {
        ProductDao productDao=new ProductDaoImpl(JdbcUtils.getConnection());
        List<Product> productList=new ArrayList<>();
        productList=productDao.getProductByName(pname);
        return productList;
    }
}
