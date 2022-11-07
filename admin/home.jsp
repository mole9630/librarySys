<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title></title>
    <link rel="stylesheet" href="../bootstrap-4.6.1-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/admin/home.css">
    <link rel="stylesheet" href="../fontawesome-free-6.2.0-web/css/all.min.css">
    <script src="../js/jquery-3.6.1.min.js"></script>
    <script src="../bootstrap-4.6.1-dist/js/bootstrap.min.js"></script>
    <script src="../js/admin/home.js"></script>
</head>
<body>
    <div class="left-nav">
        <div class="accordion" id="accordion">
            <div class="card">
                <h2 class="mb-0">
                    <button class="btn btn-block text-left" type="button" data-toggle="collapse"
                            data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                        <i class="fa-solid fa-book-open left-nav-icon"></i><span class="box-select-text active">图书管理</span>
                    </button>
                </h2>
                <div id="collapseOne" class="collapse show" aria-labelledby="headingOne"
                     data-parent="#accordion">
                    <div class="card-body">
                        <!-- 下拉框内内容 -->
                        <ul class="box-select">
                            <li class="box-select-item">
                                <span class="box-select-content">
                                    <span class="box-select-menu-title active">图书增加</span>
                                </span>
                            </li>
                            <li class="box-select-item">
                                <span class="box-select-content">
                                    <span class="box-select-menu-title">图书删除</span>
                                </span>
                            </li>
                            <li class="box-select-item">
                                <span class="box-select-content">
                                    <span class="box-select-menu-title">图书信息维护</span>
                                </span>
                            </li>
                            <li class="box-select-item">
                                <span class="box-select-content">
                                    <span class="box-select-menu-title">用户借阅/归还查询</span>
                                </span>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="card">
                <h2 class="mb-0">
                    <button class="btn btn-block text-left collapsed" type="button" data-toggle="collapse"
                            data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                        <i class="fa-solid fa-users-viewfinder left-nav-icon"></i><span class="box-select-text">用户管理</span>
                    </button>
                </h2>
                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordion">
                    <div class="card-body">
                        <!-- 下拉框内内容 -->
                        <ul class="box-select">
                            <li class="box-select-item">
                                <span class="box-select-content">
                                    <span class="box-select-menu-title">用户增加</span>
                                </span>
                            </li>
                            <li class="box-select-item">
                                <span class="box-select-content">
                                    <span class="box-select-menu-title">用户删除</span>
                                </span>
                            <li class="box-select-item">
                            <span class="box-select-content">
                                <span class="box-select-menu-title">用户信息维护</span>
                            </span>
                            </li>
                            <li class="box-select-item">
                                <span class="box-select-content">
                                    <span class="box-select-menu-title">用户借阅/归还查询</span>
                                </span>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="card">
                <h2 class="mb-0">
                    <button class="btn btn-block text-left collapsed" type="button" data-toggle="collapse"
                            data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                        <i class="fa-solid fa-magnifying-glass left-nav-icon"></i><span class="box-select-text">日志查询</span>
                    </button>
                </h2>
                <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordion">
                    <div class="card-body">
                        <!-- 下拉框内内容 -->
                        <ul class="box-select">
                            <li class="box-select-item">
                                <span class="box-select-content">
                                    <span class="box-select-menu-title">登录日志</span>
                                </span>
                            </li>
                            <li class="box-select-item">
                                <span class="box-select-content">
                                    <span class="box-select-menu-title">图书信息维护日志</span>
                                </span>
                            </li>
                            <li class="box-select-item">
                                <span class="box-select-content">
                                    <span class="box-select-menu-title">用户信息维护日志</span>
                                </span>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>