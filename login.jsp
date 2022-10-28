<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录 - 相城市图书馆</title>
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <link rel="stylesheet" href="bootstrap-4.6.1-dist/css/bootstrap.min.css">
</head>
<body>
    <%@ include file="header.jsp" %>
    <div class="body">
        <div class="all">
            <form action="/LoginServlet" method="post">
                <img class="mb-4" id="logo" src="img/login/user_img.jpg" alt="logo">
                <h1 class="h3 mb-3">请登录</h1>
                <div class="form-group">
                    <input type="text" name="u_phone" class="form-control" placeholder="手机号">
                    <small id="phoneHelp" class="form-text text-muted">我们永远不会与其他人分享您的手机号。</small>
                </div>
                <div class="form-group">
                    <input type="password" name="u_password" class="form-control" placeholder="密码">
                    <small id="passwordHelp" class="form-text text-muted">密码必须8位以上字母、数字及特殊字符组合,且同时密码必须同时包含有数字、字母和特殊字符。</small>
                </div>
                <div class="form-group form-check">
                    <input type="checkbox" class="form-check-input" id="remember_me">
                    <label class="form-check-label" for="remember_me">1天内免登录</label>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="checkbox" class="form-check-input" id="verification_check">
                    <label class="form-check-label" for="verification_check">检查是不是机器人?</label>
                </div>

                <button class="btn btn-primary btn-lg btn-block" type="submit">登录</button>
            </form>
        </div>
        <%@ include file="footer.jsp" %>
    </div>
</body>
</html>
