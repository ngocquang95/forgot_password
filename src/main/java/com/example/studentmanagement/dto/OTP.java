package com.example.studentmanagement.dto;

import java.util.Date;

public class OTP {
    private String otp;
    private Date otpCreationTime;

    public OTP(String otp, Date otpCreationTime) {
        this.otp = otp;
        this.otpCreationTime = otpCreationTime;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public Date getOtpCreationTime() {
        return otpCreationTime;
    }

    public void setOtpCreationTime(Date otpCreationTime) {
        this.otpCreationTime = otpCreationTime;
    }
}
