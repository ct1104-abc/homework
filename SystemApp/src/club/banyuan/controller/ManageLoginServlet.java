package club.banyuan.controller;

import club.banyuan.eneity.Manage;
import club.banyuan.eneity.User;
import club.banyuan.service.ManageService;
import club.banyuan.service.UserService;
import club.banyuan.service.impl.ManageServiceImpl;
import club.banyuan.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ManageLoginServlet",urlPatterns = "/managelogin.do")
public class ManageLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loginName=request.getParameter("loginName");
        String password=request.getParameter("password");
        ManageService manageService=new ManageServiceImpl();
        Manage manage =null;
        try {
            manage=manageService.login(loginName,password);
            if(manage!=null){
                request.getRequestDispatcher("manageorder.jsp").forward(request,response);
                return;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("managelogin.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
