<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap-4.6.1-dist/css/bootstrap.css" />
    <style type="text/css">
        table{
            text-align: center;
            font-size: 12px;
        }
        .ibox-content{
            margin-top: 10px;
            margin-bottom: 10px;
        }
        .btn-operate{
            width: 50px;
            height: 30px;
            font-size: 12px;
        }
    </style>
</head>
<body>
<div class="ibox-content">
    <div class="row m-b-sm m-t-sm">
        <div class="col-md-10">
            <div class="input-group">
                <input type="text" placeholder="请输入用户信息" class="input-sm form-control">
                <span class="input-group-btn" style="margin-left: 10px;">
		                    <button type="button" class="btn btn-primary"> 搜索</button>
						</span>
            </div>
        </div>
        <div class="col-md-2">
            <button type="button" class="btn btn-info"> 刷新</button>
            <a href="user_add.jsp" class="btn btn-success">添加</a>
        </div>
    </div>
</div>
<table class="table">
    <thead class="thead-light">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>密码</th>
        <th>生日</th>
        <th>身份证号</th>
        <th>手机号</th>
        <th>电子邮箱</th>
        <th>住址</th>
        <th>用户角色</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>1123</td>
        <td>王五五五五</td>
        <td>1234567890</td>
        <td>12月5日</td>
        <td>340000000000000000</td>
        <td>14585632145</td>
        <td>54515@qq.com</td>
        <td>安徽省阜阳市临泉县鲖城镇回民街270号</td>
        <td>管理员</td>
        <td>
            <button type="button" class="btn-operate btn btn-success">修改</button>
            <button type="button" class="btn-operate btn btn-danger">删除</button>
        </td>
    </tr>
    </tbody>
</table>
</body>
</html>
