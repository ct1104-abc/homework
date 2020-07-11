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
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "SearchServlet",urlPatterns = "/search.do")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sql="select * from product where beauction=0 ";
        String pname=request.getParameter("pname");
        System.out.println(pname);
        String description=request.getParameter("description");
        String beginTime=request.getParameter("beginTime");
        String endTime=request.getParameter("endTime");
        if(pname!=""){
            sql=sql+" and pname like '%"+pname+"%'";
            System.out.println(sql);
        }
        if(description!=""){
            sql=sql+" and description like '%"+description+"%'";
            System.out.println(sql);
        }
        if(beginTime!=""){
            sql=sql+" and beginTime >='"+beginTime+"'";
            System.out.println(sql);
        }
        if(endTime!=""){
            sql=sql+" and endTime <='"+endTime+"'";
            System.out.println(sql);
        }
        ProductService productService=new ProductServiceImpl();
        List<Product> productList=new ArrayList<>();
        try {
            productList=productService.search(sql);
            System.out.println(productList);
            HttpSession session=request.getSession();
            session.setAttribute("productList",productList);
            request.getRequestDispatcher("manageorder.jsp").forward(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
