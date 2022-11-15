<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="assets/plugins/bootstrap-4.6.1-dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/plugins/fontawesome-free-6.2.0-web/css/all.min.css">
        <link rel="stylesheet" type="text/css" href="assets/css/header.css"/>
    </head>
    <body>
    <div class="container">
        <!--  导航菜单  -->
        <div class="row header">
            <!--  图标  -->
            <div class="col-lg-4 col-md-6 col-sm-6 col-6">
                <img src="assets/img/logo.png" alt="logo" class="log center no-repeat">
            </div>
            <!--   跳转文字  -->
            <div class="col-lg-8 d-dm-none d-sm-none d-lg-block d-none">
                <ul>
                    <li><a href="#"><i class="fa-solid fa-house"></i>网站首页</a></li>
                    <li><a href="#"><i class="fa-solid fa-circle-info"></i>本馆概况</a></li>
                    <li><a href="#"><i class="fa-solid fa-magnifying-glass"></i>书目检索</a></li>
                    <li><a href="#"><i class="fa-solid fa-user-check"></i>用户登录</a></li>
                    <li><a href="#"><i class="fa-solid fa-user-plus"></i>用户注册</a></li>
                </ul>
            </div>
            <!--  响应式的折叠按钮  -->
            <div class="d-lg-none col-md-6 col-sm-6 col-6">
                <button class="navbar-toggler" type="button" data-togger="clooapse" data-targer="#navbar">
                    <span class="navbar-toggler-icon"></span>
                    <i class="fa-solid fa-bars"></i>
                </button>
            </div>
        </div>
    </div>
    <!--  背景图片  -->
    <div class="banner container-fluid"></div>
    </body>
</html>
