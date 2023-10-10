package com.example.studentmanagement.controller;

import com.example.studentmanagement.dto.OTP;
import com.example.studentmanagement.util.OTPGenerator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "VerifyOTPServlet", value = "/verify-otp")
public class VerifyOTPServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("emailForgotPassword") == null) {
            response.sendRedirect("/forgot-password?message=" + URLEncoder.encode("Bạn chưa cung cấp mail", "UTF-8"));
            return;
        }

        request.getRequestDispatcher("verifyOtp.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("emailForgotPassword") == null) {
            response.sendRedirect("/forgot-password?message=" + URLEncoder.encode("Bạn chưa cung cấp mail", "UTF-8"));
            return;
        }

        String otpEnter = request.getParameter("otp");
        OTP otp = (OTP) request.getSession().getAttribute("otp");

        if (OTPGenerator.isOTPExpired(otp.getOtpCreationTime())) {
            response.sendRedirect("/verify-otp?message=" + URLEncoder.encode("OTP đã hết hạn", "UTF-8"));
            return;
        }

        if (!otpEnter.equals(otp.getOtp())) {
            response.sendRedirect("/verify-otp?message=" + URLEncoder.encode("OTP chưa đúng", "UTF-8"));
            return;
        }

        request.getSession().setAttribute("isVerifiedOTP", true);
        response.sendRedirect("reset-password");
    }
}
