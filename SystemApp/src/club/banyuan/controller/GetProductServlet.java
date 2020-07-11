package club.banyuan.controller;

import club.banyuan.eneity.Product;
import club.banyuan.service.ProductService;
import club.banyuan.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "GetProductServlet",urlPatterns = "/getproduct.do")
public class GetProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();

        int pid=Integer.valueOf(request.getParameter("pid"));
        session.setAttribute("pid",pid);
        ProductService productService=new ProductServiceImpl();
        try {
            Product product=productService.selectById(pid);
            if(product!=null){
                session.setAttribute("product",product);
                request.getRequestDispatcher("updateproduct.jsp").forward(request,response);
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
