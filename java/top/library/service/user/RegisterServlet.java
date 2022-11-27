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
@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private UserService userService = new UserService();
    private LogService logService = new LogService();

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
        if (userPhone == null || "".equals(userPhone) || userRePassword == null || "".equals(userRePassword) || userEmail == null || "".equals(userEmail) || userName == null || "".equals(userName) || userIdentificationNumber == null || "".equals(userIdentificationNumber) || userAddress == null || "".equals(userAddress) || userBirthday == null || "".equals(userBirthday)) {
            resuleStr = "请填写完整信息,请检查后重试.";
            request.setAttribute("message", resuleStr);
            request.getRequestDispatcher("test.jsp").forward(request, response);
        } else if (!userPassword.equals(userRePassword)) {
            resuleStr = "两次密码不一致,请检查后重试.";
            request.setAttribute("message", resuleStr);
            request.getRequestDispatcher("test.jsp").forward(request, response);
        } else {
            // 判断手机号是否存在
            User userJudgment = userService.selectUserByPhone(userPhone);

            if (userJudgment != null) {
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
                statusCode = userService.insertRegister(user);

                // 写入注册日志
                logService.insertRegisterLog(user);

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
