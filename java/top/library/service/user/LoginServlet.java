package top.library.service.user;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import top.library.util.db.SqlSessionFactoryUtils;
import top.library.util.log.getTimestampUtils;
import top.library.mapper.log.LogMapper;
import top.library.pojo.log.Log;
import top.library.mapper.user.UserMapper;
import top.library.pojo.user.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    // 可能经常用到,所以提取出来
    private UserService userService = new UserService();

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
        String resuleStr = null;

        // 调用UserService完成登录校验工作
        User user = userService.selectLogin(userPhone, userPassword);

        if (user != null) {
            // 写入登陆日志
//            getTimestampUtils getTimestampUtils = new getTimestampUtils();
//            Log log = new Log();
//            log.setuCardId(user.getuCardId());
//            log.setlStartTime(getTimestampUtils.getTimestamp());
//            log.setlEndTime(getTimestampUtils.getTimestamp());
//            log.setlType("user.login");
//            logMapper.insertLog(log);
//            sqlSession.commit();
//            // 释放资源
//            sqlSession.close();


            // 登陆成功
            resuleStr = "登录成功 --> 欢迎您:" ;
            request.getSession().setAttribute("user", user);
            response.sendRedirect("admin/home.jsp");
        }
        else {
            // 释放资源
            resuleStr = userPhone + "用户不存在或者密码错误,请检查后重试.";
            request.setAttribute("message", resuleStr);
            request.getRequestDispatcher("test.jsp").forward(request, response);
        }
    }
}
