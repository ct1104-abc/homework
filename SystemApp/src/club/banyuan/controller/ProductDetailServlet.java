package club.banyuan.controller;

import club.banyuan.eneity.Auction;
import club.banyuan.eneity.Product;
import club.banyuan.service.AuctionService;
import club.banyuan.service.ProductService;
import club.banyuan.service.impl.AuctionServiceImpl;
import club.banyuan.service.impl.ProductServiceImpl;
import com.mysql.cj.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductDetailServlet",urlPatterns = "/detail.do")
public class ProductDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService productService=new ProductServiceImpl();
        int pid=Integer.valueOf(request.getParameter("pid"));
        try {
            Product product=productService.selectById(pid);
            HttpSession session=request.getSession();
            session.setAttribute("product",product);
            AuctionService auctionService=new AuctionServiceImpl();
            List<Auction> auctionList=auctionService.selectByPId(pid);
            session.setAttribute("auctionList",auctionList);
            request.getRequestDispatcher("auction.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
