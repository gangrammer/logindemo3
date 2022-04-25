package web;

import com.mysql.cj.Session;
import pojo.Brand;
import pojo.User;
import service.UserService;
import service.service1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;


@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        UserService userService = new UserService();
        User usre1 = userService.login(user);
        if (usre1 != null) {
            if ("1" .equals(remember)) {
                Cookie cookie = new Cookie("username",username);
                Cookie cookie1 = new Cookie("password",password);
                cookie.setMaxAge(60*60*7*24);
                cookie1.setMaxAge(60*60*24*7);
                response.addCookie(cookie);
                response.addCookie(cookie1);
            }

            HttpSession session = request.getSession();
            session.setAttribute("user1",usre1);
            response.sendRedirect("/logindemo3_war_exploded/selectAllServlet");
        }else {
          request.setAttribute("login_msg","用户名或密码错误");
          request.getRequestDispatcher("login.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
