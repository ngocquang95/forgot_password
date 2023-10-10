package com.example.studentmanagement.util;

import java.security.SecureRandom;
import java.util.Date;

public class OTPGenerator {
    // Độ dài của mã OTP (6 chữ số)
    private static final int OTP_LENGTH = 6;

    // Thời gian hết hạn của mã OTP (15 phút)
    private static final long OTP_EXPIRATION_TIME_MS = 15 * 60 * 1000; // 15 phút

    public static String generateOTP() {
        // Tạo chuỗi ngẫu nhiên cho mã OTP, chứa các số từ 0 đến 9
        SecureRandom random = new SecureRandom();
        StringBuilder otpBuilder = new StringBuilder();
        for (int i = 0; i < OTP_LENGTH; i++) {
            int digit = random.nextInt(10); // Số ngẫu nhiên từ 0 đến 9
            otpBuilder.append(digit);
        }

        return otpBuilder.toString();
    }

    public static boolean isOTPExpired(Date otpCreationTime) {
        // Lấy thời gian hiện tại
        Date currentTime = new Date();

        // Tính thời gian trôi qua kể từ khi tạo OTP
        long elapsedTime = currentTime.getTime() - otpCreationTime.getTime();

        // Kiểm tra xem thời gian trôi qua có lớn hơn thời gian hết hạn không
        return elapsedTime > OTP_EXPIRATION_TIME_MS;
    }

    public static void main(String[] args) {
        // Tạo mã OTP
        String otp = generateOTP();
        System.out.println("Generated OTP: " + otp);

        // Lưu thời điểm tạo mã OTP
        Date otpCreationTime = new Date();

        // Kiểm tra xem mã OTP đã hết hạn chưa
        boolean isExpired = isOTPExpired(otpCreationTime);
        System.out.println("Is OTP Expired: " + isExpired);
    }
}
