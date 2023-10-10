<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 10/10/2023
  Time: 11:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quên mật khẩu</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">Quên mật khẩu</div>
                <div class="card-body">
                    <form method="POST" action="forgot-password">
                        <div class="mb-3">
                            <label for="emailForgotPassword" class="form-label">Địa chỉ Email</label>
                            <input type="email" class="form-control" id="emailForgotPassword" name="emailForgotPassword" required>
                            <p class="text-danger">${param.message}</p>
                        </div>
                        <button type="submit" class="btn btn-primary">Gửi yêu cầu đặt lại mật khẩu</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
