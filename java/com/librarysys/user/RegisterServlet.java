package com.librarysys.user;

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
        String userAddress = request.getParameter("u_address");
        int statusCode = -1;
        String resuleStr = null;
    }
}
