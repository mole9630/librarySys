<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap-4.6.1-dist/css/bootstrap.css"/>
    <style>
        form{
            text-align: center;
        }
    </style>
</head>
<body>
    <form action="#" method="post">
        <h5>用户添加</h5>
        <div class="form-group">
            姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:<input type="text" name="u_name"><br>
        </div>
        <div class="form-group">
            密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:<input type="password" name="u_password"><br>
        </div>
        <div class="form-group">
            身份证号:<input type="text" name="u_identification_number"><br>
        </div>
        <div class="form-group">
            手&nbsp;机&nbsp;&nbsp;号:<input type="text" name="u_phone"><br>
        </div>
        <div class="form-group">
            电子邮箱:<input type="email" name="u_email"><br>
        </div>
        <div class="form-group">
            家庭地址:<input type="text" name="u_address"><br>
        </div>
        <div class="form-group">
            生日:<input type="date" name="u_birthday"><br>
        </div>
        <div class="form-group">
            是否为管理员:<select>
            <option value="1">是</option>
            <option value="2" selected>否</option>
        </select><br>
        </div>
        <div class="form-group">
            <button class="btn btn-primary btn-lg btn-block" type="submit">添加</button>
            <button class="btn btn-primary btn-lg btn-block" type="reset">重置</button>
        </div>
    </form>
</body>
</html>
