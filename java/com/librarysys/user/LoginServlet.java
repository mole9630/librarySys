package com.librarysys.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import static java.lang.System.out;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userPhone = request.getParameter("u_phone");
        String userPassword = request.getParameter("u_password");
        int statusCode = -1;
        String resuleStr = null;

        Login login = new Login();
        statusCode = login.userLogin(userPhone, userPassword);

        if (statusCode == 1) {
            resuleStr = "登录成功 --> 欢迎您:" + userPhone;
        }
        else if (statusCode == 0) {
            resuleStr = userPhone + "用户不存在或者密码错误,请检查后重试.";
        }
        else {
            resuleStr = "非法请求";
        }

        request.setAttribute("message", resuleStr);
        request.getRequestDispatcher("test.jsp").forward(request, response);

    }
}
