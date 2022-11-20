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

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userPhone = request.getParameter("u_phone");
        String userPassword = request.getParameter("u_password");
        String userRePassword = request.getParameter("u_re_password");
        String userEmail = request.getParameter("u_email");
        String userName = request.getParameter("u_name");
        String userIdentificationNumber = request.getParameter("u_identification_number");
        String userBirthday = request.getParameter("u_birthday");
        String userAddress = request.getParameter("u_address");
        int statusCode = -1;
        String resuleStr = null;

        // 判断不可为空的字段是否为空
        if (userPhone == null || userPhone.equals("") || userRePassword == null || userRePassword.equals("") || userEmail == null || userEmail.equals("") || userName == null || userName.equals("") || userIdentificationNumber == null || userIdentificationNumber.equals("") || userAddress == null || userAddress.equals("") || userBirthday == null || userBirthday.equals("")) {
            statusCode = 0;
            resuleStr = "请填写完整信息,请检查后重试.";
            request.setAttribute("message", resuleStr);
            request.getRequestDispatcher("test.jsp").forward(request, response);
        } else if (!userPassword.equals(userRePassword)) {
            statusCode = 0;
            resuleStr = "两次密码不一致,请检查后重试.";
            request.setAttribute("message", resuleStr);
            request.getRequestDispatcher("test.jsp").forward(request, response);
        } else {
            // 获取SqlSessionFactory
            SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

            // 获取SqlSession对象
            SqlSession sqlSession = factory.openSession();

            // 获取Mapper对象接口的代理对象
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            LogMapper logMapper = sqlSession.getMapper(LogMapper.class);

            // 判断手机号是否存在
            User userJudgment = userMapper.selectUserByPhone(userPhone);

            if (userJudgment != null) {
                statusCode = 0;
                System.out.println("[info] " + userPhone + "用户注册失败,可能是用户已存在.");
                resuleStr = userPhone + "用户已存在.";
                request.setAttribute("message", resuleStr);
                request.getRequestDispatcher("test.jsp").forward(request, response);
            } else {
                // 设置user对象值
                User user = new User();
                user.setuPhone(userPhone);
                user.setuPassword(userPassword);
                user.setuEmail(userEmail);
                user.setuName(userName);
                user.setuIdentificationNumber(userIdentificationNumber);
                user.setuBirthday(userBirthday);
                user.setuAddress(userAddress);

                //执行方法
                statusCode = userMapper.insertRegister(user);

                // 写入登陆日志
                getTimestampUtils getTimestampUtils = new getTimestampUtils();
                Log log = new Log();
                log.setuCardId(user.getuCardId());
                log.setlStartTime(getTimestampUtils.getTimestamp());
                log.setlEndTime(getTimestampUtils.getTimestamp());
                log.setlType("user.register");
                logMapper.insertLog(log);

                // 提交事务
                sqlSession.commit();

                // 释放资源
                sqlSession.close();

                if (statusCode == 1) {
                    System.out.println("[info] " + userPhone + "用户注册成功!");
                    resuleStr = "注册成功 --> 欢迎您:" + userName;
                } else {
                    resuleStr = "系统繁忙,请稍后重试.";
                }

                request.setAttribute("message", resuleStr);
                request.getRequestDispatcher("test.jsp").forward(request, response);
            }
        }
    }
}
