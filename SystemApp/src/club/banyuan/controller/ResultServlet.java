package club.banyuan.controller;

import club.banyuan.eneity.Auction;
import club.banyuan.eneity.Product;
import club.banyuan.service.AuctionService;
import club.banyuan.service.ProductService;
import club.banyuan.service.impl.AuctionServiceImpl;
import club.banyuan.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ResultServlet",urlPatterns = "/result.do")
public class ResultServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService productService=new ProductServiceImpl();
        List<Product> products=new ArrayList<>();

        try {
            products=productService.selectBe(1);
            HttpSession session=request.getSession();
            session.setAttribute("products",products);
            products=productService.selectBe(0);
            session.setAttribute("products1",products);
            request.getRequestDispatcher("result.jsp").forward(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
