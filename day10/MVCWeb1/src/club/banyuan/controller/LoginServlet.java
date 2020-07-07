package club.banyuan.controller;

import club.banyuan.entity.User;
import club.banyuan.service.UserService;
import club.banyuan.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        String loginName = request.getParameter("loginName");
        String password = request.getParameter("password");
//        格式验证

//        调用service处理登录请求
        UserService userService = new UserServiceImpl();
        try {
            User user = userService.login(loginName,password);
            if(user!=null){
                HttpSession session=request.getSession();
                session.setAttribute("user",user);
                session.setAttribute("userId",user.getId());
                session.setAttribute("mobile",user.getMobile());
                session.setAttribute("email",user.getEmail());
                Cookie cookie=new Cookie("loginName",user.getLoginName());
                response.addCookie(cookie);
                request.getRequestDispatcher("index.jsp").forward(request,response);
                return ;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("login.html").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
