package top.library.user;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import top.library.log.Tools;
import top.library.log.mapper.LogMapper;
import top.library.log.pojo.Log;
import top.library.user.mapper.UserMapper;
import top.library.user.pojo.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
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

        // 获取SqlSessionFactory
        // 加载mybatis的核心配置文件,获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 获取Mapper对象接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        LogMapper logMapper = sqlSession.getMapper(LogMapper.class);

        //执行方法
        User user = userMapper.selectLogin(userPhone, userPassword);

        if (user != null) {
            // 写入登陆日志
            Tools tools = new Tools();
            Log log = new Log();
            log.setuCardId(user.getuCardId());
            log.setlStartTime(tools.getTimestamp());
            log.setlType("5001");
            logMapper.insertLog(log);
            sqlSession.commit();
            // 释放资源
            sqlSession.close();


            // 登陆成功
            resuleStr = "登录成功 --> 欢迎您:" ;
            request.getSession().setAttribute("user", user);
            response.sendRedirect("admin/home.jsp");
        }
        else {
            // 释放资源
            sqlSession.close();
            resuleStr = userPhone + "用户不存在或者密码错误,请检查后重试.";
            request.setAttribute("message", resuleStr);
            request.getRequestDispatcher("test.jsp").forward(request, response);
        }
    }
}
