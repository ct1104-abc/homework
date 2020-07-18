package club.banyuan.controller;

import club.banyuan.entity.Product;
import club.banyuan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/search")
    public String search(HttpServletRequest request){
        String productName=request.getParameter("productName");
        System.out.println(productName);
        List<Product> productList=productService.getProductByName("%"+productName+"%");
        for (Product product : productList) {
            System.out.println(product);
        }
        request.setAttribute("size", productList.size());
        request.setAttribute("productList", productList);
        return "CategoryList";
    }

    @RequestMapping("/detail")
    public String ProductDetail(HttpServletRequest request){
        int id=Integer.valueOf(request.getParameter("id"));
        System.out.println(id);
        Product product=productService.getProductById(id);
        request.setAttribute("product",product);
        return "product";
    }

    @RequestMapping("/addCart")
    public String AddCart(HttpServletRequest request, HttpSession session){
        int id=Integer.valueOf(request.getParameter("productId"));
        int num=Integer.valueOf(request.getParameter("num"));
        Product product=productService.getProductById(id);
        System.out.println(product);
        if(product!=null) {
            Map<Product,Integer> cart=null;
            if(session.getAttribute("cart")==null){
                cart = new HashMap<Product,Integer>();

            }else {
                cart=(Map<Product, Integer>)session.getAttribute("cart");
            }
            cart.put(product,num);
            session.setAttribute("cart",cart);
        }
        return "buycar";
    }

}
