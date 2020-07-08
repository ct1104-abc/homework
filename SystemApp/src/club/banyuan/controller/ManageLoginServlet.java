package club.banyuan.controller;

import club.banyuan.eneity.User;
import club.banyuan.service.UserService;
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
        UserService userService=new UserServiceImpl();
        User user=null;
        try {
            user=userService.login(loginName,password);
            //System.out.println(user.getLoginName());
            if(user!=null){
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
