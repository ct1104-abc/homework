package club.banyuan.controller;

import club.banyuan.entity.Product;
import club.banyuan.service.ProductService;
import club.banyuan.service.impl.ProductServiceImpl;
import sun.jvm.hotspot.tools.SysPropsDumper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet",urlPatterns = "/selectByName.do")
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("productname");
        List<Product> productList=new ArrayList<>();
        ProductService productService=new ProductServiceImpl();
        try {
           productList= productService.getProductByName(name);
           if(productList!=null){
               for (Product product : productList) {
                   System.out.println(product);
               }
               request.setAttribute("product",productList);
               request.getRequestDispatcher("CategoryList.jsp").forward(request,response);
           }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
