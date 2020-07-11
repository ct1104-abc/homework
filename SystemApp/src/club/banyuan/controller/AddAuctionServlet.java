package club.banyuan.controller;

import club.banyuan.eneity.Auction;
import club.banyuan.eneity.Product;
import club.banyuan.eneity.User;
import club.banyuan.service.AuctionService;
import club.banyuan.service.impl.AuctionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "AddAuctionServlet",urlPatterns = "/addauction.do")
public class AddAuctionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        User user=(User) session.getAttribute("user");
        Product product=(Product) session.getAttribute("product");
        Auction auction=new Auction();
        auction.setUserid(user.getId());
        auction.setLoginName(user.getLoginName());
        auction.setProductid(product.getId());
        Double price=Double.valueOf(request.getParameter("price"));
        auction.setPrice(price);
        auction.setAuctiontime(new Date());
        AuctionService auctionService=new AuctionServiceImpl();
        try {
            int i=auctionService.addAuction(auction);
            if(i>0)
                request.getRequestDispatcher("result.jsp").forward(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
