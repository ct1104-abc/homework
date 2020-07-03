package club.banyuan.controller;

import club.banyuan.entity.User;
import club.banyuan.service.UserService;
import club.banyuan.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "RegistServlet",urlPatterns = "/regist.do")
public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user=new User();
        user.setLoginName(request.getParameter("loginName"));
        user.setUserName(request.getParameter("userName"));
        user.setPassword(request.getParameter("password"));
        user.setSex(Integer.valueOf(request.getParameter("sex")));
        user.setEmail(request.getParameter("email"));
        user.setMobile(request.getParameter("mobile"));
        UserService userService=new UserServiceImpl();
        try {
            int i=userService.add(user);
            if(i>0){
                request.getRequestDispatcher("login.html").forward(request,response);
                return ;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        PrintWriter printWriter=response.getWriter();
        response.setContentType("text/html;charset=utf-8");
        printWriter.println("<script>alert('注册失败');</script>");
        //request.getRequestDispatcher("Regist.html").forward(request,response);
        //request.getRequestDispatcher("login.html").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
