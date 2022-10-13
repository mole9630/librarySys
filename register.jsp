<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> 注册 - 相城市图书馆</title>
    <link rel="stylesheet" type="text/css" href="css/register.css">
</head>
<body>
<%@ include file="header.jsp" %>
<article>
    <div id="form-div">
        <form id="reg-form" action="" method="">
            <table>
                <tr>
                    <td>用户名</td>
                    <td>
                        <input type="text" name="uid" id="uid" value="" placeholder="请输入用户名" required="required" autofocus="autofocus" />
                    </td>
                </tr>
                <tr>
                    <td>密码</td>
                    <td>
                        <input type="password" name="psw1" id="psw1" value="" placeholder="请输入密码" required="required" />
                    </td>
                </tr>
                <tr>
                    <td>确认密码</td>
                    <td>
                        <input type="password" name="psw2" id="psw2" value="" placeholder="请输入确认密码" required="required" />
                    </td>
                </tr>
                <tr>
                    <td>邮箱</td>
                    <td>
                        <input type="email" name="email" id="email" value="" pattern="^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$" />
                    </td>
                </tr>
                <tr>
                    <td>昵称</td>
                    <td>
                        <input type="text" name="nickname" id="nickname" value="" />
                    </td>
                </tr>
            </table>
            <div class="buttons">
                <input type="submit" style="margin-right: 20px;margin-top: 20px;" value="注  册" />
                <a href="login.jsp"><input type="button" style="margin-right: 45px;margin-top: 20px;" value="有账户，去登录" /></a>
            </div>
            <br class="clear">
        </form>
    </div>
    <div style="width: 100%; height: 100px"></div>
</article>
<%@ include file="footer.jsp" %>
</body>
</html>
