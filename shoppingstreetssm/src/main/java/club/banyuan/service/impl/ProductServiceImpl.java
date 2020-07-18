package club.banyuan.service.impl;

import club.banyuan.dao.ProductDao;
import club.banyuan.entity.Product;
import club.banyuan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;


    public List<Product> getProductByName(String proName) {
        List<Product> productList=productDao.getProductByName(proName);
        return productList;
    }

    public Product getProductById(Integer id) {
        Product product=productDao.getProductById(id);
        return product;
    }
}
