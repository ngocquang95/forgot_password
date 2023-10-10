package com.example.studentmanagement.controller;

import com.example.studentmanagement.dto.OTP;
import com.example.studentmanagement.service.IUserService;
import com.example.studentmanagement.service.impl.UserService;
import com.example.studentmanagement.util.EmailUtil;
import com.example.studentmanagement.util.FileUtil;
import com.example.studentmanagement.util.OTPGenerator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;

@WebServlet(name = "ForgotPasswordServlet", value = "/forgot-password")
public class ForgotPasswordServlet extends HttpServlet {
    private IUserService userService = new UserService();

    private String host = "smtp.gmail.com";
    private String port = "587";
    private String user = "xxxxxx@gmail.com"; // Gmail để server gửi đi (Mail admin)
    private String pass = "xxxxxxxxxxxx"; // Mật khẩu ứng dụng

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("forgotPassword.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String emailForgotPassword = request.getParameter("emailForgotPassword");
        if (userService.findByUsernameOrEmail(emailForgotPassword) == null) {
            response.sendRedirect("/forgot-password?message=" + URLEncoder.encode("Email không tồn tại trong hệ thống", "UTF-8"));
            return;
        }


        OTP otp = new OTP(OTPGenerator.generateOTP(), new Date());
        request.getSession().setAttribute("otp", otp);

        String emailContent = FileUtil.readResourceFile(getServletContext(), "template/emailTemplate.html");
        emailContent = emailContent.replace("${otp}", otp.getOtp());

        try {
            EmailUtil.sendEmail(host, port, user, pass, emailForgotPassword, "Đặt lại Mật khẩu",
                    emailContent);
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.getSession().setAttribute("emailForgotPassword", emailForgotPassword);
        response.sendRedirect("/verify-otp");
    }
}
