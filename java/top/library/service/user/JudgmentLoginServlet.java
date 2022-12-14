package top.library.service.user;

import top.library.pojo.user.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * @author mole9630
 */
@WebServlet(name = "JudgmentLoginServlet", value = "/admin")
public class JudgmentLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Cookie cookie = null;
        String resuleStr = null;
        boolean flag = true;
        if (user == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
//            response.sendRedirect("login.jsp");  //= 报出NullPointerException的错误
        }
        else {
            flag = false;
            response.getWriter().println("欢迎您" + user.getuName() + ",<a href='/LoginOutServlet'>退出</a>");
            cookie = new Cookie("JSESSIONID", session.getId());
            // cookie的存在周期为3天
            cookie.setMaxAge(60 * 60 * 24 * 3);
            response.sendRedirect("adm/index.jsp");
        }
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
