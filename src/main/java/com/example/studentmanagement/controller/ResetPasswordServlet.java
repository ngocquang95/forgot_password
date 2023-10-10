package com.example.studentmanagement.controller;

import com.example.studentmanagement.service.IUserService;
import com.example.studentmanagement.service.impl.UserService;
import com.example.studentmanagement.util.BCryptUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "ResetPasswordServlet", value = "/reset-password")
public class ResetPasswordServlet extends HttpServlet {
    private IUserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("isVerifiedOTP") == null) {
            response.sendRedirect("/verify-otp?message=" + URLEncoder.encode("Bạn chưa xác minh OTP", "UTF-8"));
            return;
        }

        request.getRequestDispatcher("resetPassword.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("isVerifiedOTP") == null) {
            response.sendRedirect("/verify-otp?message=" + URLEncoder.encode("Bạn chưa xác minh OTP", "UTF-8"));
            return;
        }

        String password = request.getParameter("password");
        String hashPassword = BCryptUtil.hashPassword(password);
        String email = (String) request.getSession().getAttribute("emailForgotPassword");

        userService.updatePasswordByEmail(hashPassword, email);
        response.sendRedirect("/login?message=" + URLEncoder.encode("Đã đổi mật khẩu thành công", "UTF-8"));
    }
}
