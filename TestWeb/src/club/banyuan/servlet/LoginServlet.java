package club.banyuan.servlet;

import club.banyuan.dao.UserDao;
import club.banyuan.dao.impl.UserDaoImpl;
import club.banyuan.entity.User;
import club.banyuan.util.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user=new User();
        user.setLoginName(request.getParameter("loginName"));
        user.setPassword(request.getParameter("password"));
        int i=1;
        try {
            UserDao userDao=new UserDaoImpl(JdbcUtils.getConnection());
            User n=userDao.getLoginUser(user.getLoginName(),user.getPassword());
            if(n!=null)
                i=0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//        response.setCharacterEncoding("utf-8");
//        PrintWriter writer = response.getWriter();
//        writer.println("<html>");
//        writer.println("<meta charset='utf-8'/>");
//        writer.println("<body>");
//        writer.println(i==0?"登录成功":"登录失败");
//        writer.println("</body>");
//        writer.println("</html>");
//        writer.flush();
//        writer.close();
            if(i==0)
             response.sendRedirect("Index.html");
            else
                response.sendRedirect("Login.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
