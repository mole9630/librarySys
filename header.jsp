<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>header</title>
    <style>
        /* 头部 */
        .top{
            width: 100%;
            height: 30px;
            background-image: linear-gradient(to right,#148D96, #148D96, #065279);
        }
        /* 图片 */
        .log{
            height: 81px;
            margin: 0 auto;
            width: 100%;
            background-image: url("img/head_bg.png");
            position: relative;
            float: right;

        }
        .log img{
            width: 400px;
            height: 90px;
            position: relative;
            left: 50px;
            top: -10px;
        }
        /* 导航栏 */
        .nav{
            width: 1000px;
            height: 81px;
            position: absolute;
            left: 520px;
            top: 0px;
        }
        .nav_colum{
            height: 50px;
            width: 1000px;
            margin: 0 auto;
        }
        .nav .nav_colum ul,.nav .nav_colum ul li{
            list-style: none;
            padding: 0;
            margin: 0;
        }
        .nav .nav_colum ul li{
            float: left;
            width: 125px;
            height: 81px;
            line-height: 81px;
            text-align: center;
        }
        .nav .nav_colum ul li a{
            text-decoration: none;
            color: black;
            display: block;
        }
        .nav .nav_colum ul li a:hover{
            background-color: #065279;
            color: white;
            opacity:0.85;
            filter:alpha(opacity=85);
        }
    </style>
</head>
<body>
    <div class="top"></div>
    <div class="log">
        <img src="img/logo.png">
        <div class="nav">
            <div class="nav_colum">
                <ul>
                    <li><a href="head.jsp">网站首页</a></li>
                    <li><a href="info.jsp">学院概况</a></li>
                    <li><a href="dang.jsp">党的建设</a></li>
                    <li><a href="jiao.jsp">教学系部</a></li>
                    <li><a href="info.jsp">科学科研</a></li>
                    <li><a href="info.jsp">学生工作</a></li>
                    <li><a href="info.jsp">招生就业</a></li>
                    <li><a href="info.jsp">学习平台</a></li>
                </ul>
            </div>
        </div>
    </div>
</body>
</html>
