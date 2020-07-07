package club.banyuan.controller;

import club.banyuan.entity.Product;
import club.banyuan.entity.User;
import club.banyuan.service.UserService;
import club.banyuan.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet(name = "ConfirmOrderServlet",urlPatterns = "/confirmOrder.do")
public class ConfirmOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        if(session.getAttribute("user")==null){
            request.getRequestDispatcher("login.jsp").forward(request,response);
            return;
        }
        //判断购物车、计算总价、查询用户地址
        Map<Product,Integer> cart=(Map<Product,Integer>)session.getAttribute("cart");
        double cost=0;
        for(Product product:cart.keySet()){
            cost+=product.getPrice()*cart.get(product);
        }
        session.setAttribute("cost",cost);
        UserService userService=new UserServiceImpl();
        User user=(User) session.getAttribute("user");
        try {
           String userAddress=  userService.getDefaultAddress(user.getId());
           session.setAttribute("userAddress",userAddress);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.getRequestDispatcher("BuyCar_Two.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
