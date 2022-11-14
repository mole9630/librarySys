//package top.library.user;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//import javax.servlet.annotation.*;
//import java.io.IOException;
//
//@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
//public class RegisterServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doPost(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String userPhone = request.getParameter("u_phone");
//        String userPassword = request.getParameter("u_password");
//        String userRePassword = request.getParameter("u_re_password");
//        String userEmail = request.getParameter("u_email");
//        String userName = request.getParameter("u_name");
//        String userIdentificationNumber = request.getParameter("u_identification_number");
//        String userAddress = request.getParameter("u_address");
//        int statusCode = -1;
//        String resuleStr = null;
//
//        Register reg = new Register();
//        statusCode = reg.userRegister(userPhone, userPassword, userRePassword, userEmail, userName, userIdentificationNumber, userAddress);
//
//        if (statusCode == 1) {
//            resuleStr = "注册成功 --> 欢迎您:" + userName;
//        }
//        else if (statusCode == 0) {
//            resuleStr = userPhone + "已存在";
//        }
//        else {
//            resuleStr = "非法请求";
//        }
//
//        request.setAttribute("message", resuleStr);
//        request.getRequestDispatcher("test.jsp").forward(request, response);
//    }
//}
