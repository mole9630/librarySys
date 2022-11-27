package top.library.service.user;

import top.library.service.log.LogService;
import top.library.pojo.user.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * @author mole9630
 */
@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();
    private LogService logService = new LogService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String userPhone = request.getParameter("u_phone");
        String userPassword = request.getParameter("u_password");
//        String selectRememberMe = request.getParameter("remember_me");
        String resultStr = null;

        // 调用UserService完成登录校验工作
        User user = userService.selectLogin(userPhone, userPassword);

        if (user != null) {
            // 写入登陆日志
            logService.insertLoginLog(user);

            if (user.getuStatus() == 0) {
                // 用户状态为0,表示用户已被禁用
                resultStr = user.getuName() + ":您的账号已被封禁.";

                request.setAttribute("message", resultStr);
                request.getRequestDispatcher("info.jsp").forward(request, response);
            } else {
                if (user.getuIdentity() == 0) {
                    // 用户登陆成功
                    System.out.println("[info] " + userPhone + ":登录成功！");
                    request.setAttribute("user", user);

                    // 登录成功信息储存在session中
                    request.getSession().setAttribute("user", user);
                    response.sendRedirect("admin/home.jsp");
                }
                else if (user.getuIdentity() == 1) {
                    // 管理员登陆成功
                    System.out.println("[info] " + userPhone + ":登录成功！");
                    request.setAttribute("user", user);

                    // 登录成功信息储存在session中
                    request.getSession().setAttribute("user", user);
                    response.sendRedirect("user/home.jsp");
                }
                else {
                    // 未知类型用户登陆成功
                    System.out.println("[info] " + userPhone + ":登录成功！");
                    System.out.println("[warn] " + userPhone + ":用户类型有误！");
                    request.setAttribute("user", user);

                    // 登录成功信息储存在session中
                    request.getSession().setAttribute("user", user);
                    response.sendRedirect("user/home.jsp");
                }
            }

        }
        else {
            // 释放资源
            resultStr = userPhone + "用户不存在或者密码错误,请检查后重试.";
            request.setAttribute("message", resultStr);
            request.getRequestDispatcher("test.jsp").forward(request, response);
        }
    }
}
