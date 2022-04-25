package web;

import pojo.User;
import service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        String checkCode = request.getParameter("checkCode");
        HttpSession session = request.getSession();
        Object checkCode1 = session.getAttribute("checkCode");
        if (checkCode1.equals(checkCode)) {
            UserService userService = new UserService();
            for (User user1 : userService.selectAllUser()) {
                if (user1.getUsername().equals(user.getUsername())) {
                    request.setAttribute("register_msg","用户名已经存在");
                    request.getRequestDispatcher("register.jsp").forward(request,response);
                    return;
                }
            }
            userService.register(user);
            request.setAttribute("register_msg","注册成功请登录");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
        }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
