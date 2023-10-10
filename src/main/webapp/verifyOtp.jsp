<%@ page import="com.example.studentmanagement.dto.OTP" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Nhập OTP</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
          integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
          crossorigin="anonymous"></script>
  <script>
    var otpCreationTime = new Date(<%= ((OTP)session.getAttribute("otp")).getOtpCreationTime().getTime() %>);

    var countdown = 900; // 15 phút trong giây
    var interval;

    function startCountdown() {
      interval = setInterval(function() {
        var now = new Date();
        var elapsedTime = Math.floor((now - otpCreationTime) / 1000); // Thời gian đã trôi qua tính bằng giây

        var remainingTime = countdown - elapsedTime;
        if (remainingTime <= 0) {
          clearInterval(interval);
          document.getElementById('countdown').textContent = 'Hết hạn';
          // Thêm logic xử lý khi hết hạn ở đây (ví dụ: hiển thị thông báo)
        } else {
          var minutes = Math.floor(remainingTime / 60);
          var seconds = remainingTime % 60;
          document.getElementById('countdown').textContent = minutes + ' phút ' + seconds + ' giây';
        }
      }, 1000);
    }

    window.onload = function() {
      startCountdown();
    }
  </script>
</head>
<body>
<div class="container mt-5">
  <div class="row justify-content-center">
    <div class="col-md-6">
      <div class="card">
        <div class="card-header">Nhập OTP</div>
        <div class="card-body">
          <form action="verify-otp" method="post">
            <div class="form-group">
              <label for="otp">Nhập OTP:</label>
              <input type="text" class="form-control" id="otp" name="otp" required>
            </div>
            <p class="text-danger">${param.message}</p>
            <button type="submit" class="btn btn-primary my-2">Xác nhận</button>
            <p>Thời gian còn lại: <span id="countdown"></span></p>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
