<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 10/10/2023
  Time: 2:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đặt lại mật khẩu</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
            crossorigin="anonymous"></script>
    <script>
        function validatePassword() {
            var password = document.getElementById('password').value;
            var confirmPassword = document.getElementById('confirmPassword').value;

            if (password === confirmPassword) {
                document.getElementById('passwordError').textContent = '';
                return true;
            } else {
                document.getElementById('passwordError').textContent = 'Mật khẩu xác nhận không trùng khớp';
                return false;
            }
        }
    </script>
</head>
<body>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">Đặt lại mật khẩu</div>
                <div class="card-body">
                    <form action="reset-password" method="post" onsubmit="return validatePassword()">
                        <div class="form-group">
                            <label for="password">Mật khẩu mới:</label>
                            <input type="password" class="form-control" id="password" name="password" required>
                        </div>
                        <div class="form-group">
                            <label for="confirmPassword">Xác nhận mật khẩu mới:</label>
                            <input type="password" class="form-control" id="confirmPassword" name="confirmPassword"
                                   required>
                            <span id="passwordError" class="text-danger"></span>
                        </div>
                        <button type="submit" class="btn btn-primary mt-2">Xác nhận</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>