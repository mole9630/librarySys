package com.librarysys.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "JudgmentLoginServlet", value = "/admin")
public class JudgmentLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Login login = (Login) session.getAttribute("user");
        Cookie cookie = null;
        String resuleStr = null;
        boolean flag = true;
        if (login == null) {
//            request.getRequestDispatcher("login.jsp").forward(request, response); // 能正常运行
            response.sendRedirect("login.jsp");  //= 报出NullPointerException的错误


//            response.getWriter().println("您还未登录,请先去<a href='login.jsp'>登录</a>");
//            response.getWriter().print("123");
        }
        else {
            flag = false;
            response.getWriter().println("欢迎您" + login.getUserPhone() + ",<a href='/LoginOutServlet'>退出</a>");
            cookie = new Cookie("JSESSIONID", session.getId());
            cookie.setMaxAge(60 * 60 * 24 * 3); // cookie的存在周期为3天
//            resuleStr = "登录成功 --> 欢迎您:" + login.getUserPhone();
//            request.setAttribute("message", resuleStr);
//            request.getRequestDispatcher("test.jsp").forward(request, response);
            response.sendRedirect("admin/home.jsp");
        }
        cookie.setPath("/");
        response.addCookie(cookie);

        if (flag) {
//            response.sendRedirect("login.jsp");
            response.getWriter().print("234");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
