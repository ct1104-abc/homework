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
import java.util.Date;

@WebServlet(name = "UpdateProductServlet",urlPatterns = "/update.do")
public class UpdateProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product=new Product();
        HttpSession session=request.getSession();
        int pid=(Integer) session.getAttribute("pid");
        System.out.println("Pid="+pid);
        product.setId(pid);
        product.setPname(request.getParameter("pname"));
        product.setBeginprice(Double.valueOf(request.getParameter("beginprice")));
        System.out.println(product.getBeginprice());
        product.setEndprice(Double.valueOf(request.getParameter("endprice")));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            product.setBeginTime(simpleDateFormat.parse(request.getParameter("beginTime")));
            product.setEndTime(simpleDateFormat.parse(request.getParameter("endTime")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        product.setDescription(request.getParameter("description"));
        System.out.println(product);
        ProductService productService=new ProductServiceImpl();
        try {
            int i=productService.update(product);
            if(i>0){
                request.getRequestDispatcher("manageorder.jsp").forward(request,response);
                return;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
