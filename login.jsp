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
            <form>
                <img class="mb-4" id="logo" src="img/login/user_img.jpg" alt="logo">
                <h1 class="h3 mb-3">请登录</h1>
                <div class="form-group">
                    <input type="email" class="form-control" placeholder="电子邮件">
                    <small id="emailHelp" class="form-text text-muted">我们永远不会与其他人分享您的电子邮件。</small>
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="密码">
                    <small id="passwordHelp" class="form-text text-muted">密码必须8位以上字母、数字及特殊字符组合,且同时密码必须同时包含有数字、字母和特殊字符。</small>
                </div>
                <div class="form-group form-check">
                    <input type="checkbox" class="form-check-input" id="exampleCheck1">
                    <label class="form-check-label" for="exampleCheck1">检查是不是机器人?</label>
                </div>
                <button class="btn btn-primary btn-lg btn-block" type="submit">登录</button>
            </form>
        </div>
        <%@ include file="footer.jsp" %>
    </div>
</body>
</html>
