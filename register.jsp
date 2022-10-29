<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> 注册 - 相城市图书馆</title>
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <link rel="stylesheet" type="text/css" href="bootstrap-4.6.1-dist/css/bootstrap.min.css">
</head>
<body>
    <%@ include file="header.jsp" %>
    <div class="body">
        <div class="register_all">
            <form action="/RegisterServlet" method="post" class="form-signin">
                <img class="mb-4" id="logo" src="img/login/user_img.jpg" alt="logo">
                <h1 class="h3 mb-3">请注册新的账号</h1>
                <div class="form-group">
                    <input type="text" name="u_phone" class="form-control" placeholder="请输入手机号">
                </div>
                <div class="form-group">
                    <input type="password" name="u_password" class="form-control" placeholder="请输入密码">
                    <small id="passwordHelp" class="form-text text-muted">密码必须8位以上字母、数字及特殊字符组合,且同时密码必须同时包含有数字、字母和特殊字符。</small>
                </div>
                <div class="form-group">
                    <input type="password" name="u_re_password" class="form-control" placeholder="请确认密码">
                </div>
                <div class="form-group">
                    <input type="email" name="u_email" class="form-control" placeholder="请输入电子邮箱">
                </div>
                <div class="row">
                    <div class="form-group col">
                        <input type="text" name="u_name" class="form-control" placeholder="请输入姓名">
                    </div>
                    <div class="form-group col">
                        <input type="text" name="u_identification_number" class="form-control" placeholder="请输入身份证号">
                    </div>
                </div>
                <div class="form-group">
                    <input type="date" name="u_address" class="form-control">
                </div>
                <div class="form-group">
                    <input type="text" name="u_address" class="form-control" placeholder="请输入家庭住址">
                </div>
                <div class="row">
                    <div class="col-4">
                        <button class="btn btn-primary btn-lg btn-block" type="submit">注册</button>
                    </div>
                    <div class="col">
                        <a>
                            <button class="btn btn-primary btn-lg btn-block" type="submit">有账号去登录</button>
                        </a>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <%@ include file="footer.jsp" %>
</body>
</html>

