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
    <style>

    </style>
</head>
<body>
    <div class="left-nav">
        <div class="accordion" id="accordionExample">
            <div class="card">
                <div class="card-header btn-content" id="headingOne">
                    <h2 class="mb-0">
                        <button class="btn btn-link btn-block text-left" type="button" data-toggle="collapse"
                                data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                            <i class="fa-solid fa-book-open left-nav-icon"></i><span class="box_select-text">图书管理</span>
                        </button>
                    </h2>
                </div>

                <div id="collapseOne" class="collapse show" aria-labelledby="headingOne"
                     data-parent="#accordionExample">
                    <div class="card-body">
                        <!-- 下拉框内内容 -->
                        <ul class="box_select">
                            <li class="box-select-item">
                                <span class="box_select-content">图书增加</span>
                            </li>
                            <li class="box-select-item">
                                <span class="box_select-content">图书删除</span>
                            </li>
                            <li class="box-select-item">
                                <span class="box_select-content">图书信息维护</span>
                            </li>
                            <li class="box-select-item">
                                <span class="box_select-content">用户借阅/归还查询</span>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="card">
                <div class="card-header btn-content" id="headingTwo">
                    <h2 class="mb-0">
                        <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse"
                                data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                            <i class="fa-solid fa-users-viewfinder left-nav-icon"></i><span class="box_select-text">用户管理</span>
                        </button>
                    </h2>
                </div>
                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
                    <div class="card-body">
                        <!-- 下拉框内内容 -->
                        <ul class="box_select">
                            <li class="box-select-item">
                                <span class="box_select-content">用户增加</span>
                            </li>
                            <li class="box-select-item">
                                <span class="box_select-content">用户删除</span>
                            <li class="box-select-item">
                                <span class="box_select-content">用户信息维护</span>
                            </li>
                            <li class="box-select-item">
                                <span class="box_select-content">用户借阅/归还查询</span>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="card">
                <div class="card-header btn-content" id="headingThree">
                    <h2 class="mb-0">
                        <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse"
                                data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                            <i class="fa-solid fa-magnifying-glass left-nav-icon"></i><span class="box_select-text">日志查询</span>
                        </button>
                    </h2>
                </div>
                <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
                    <div class="card-body">
                        <!-- 下拉框内内容 -->
                        <ul class="box_select">
                            <li class="box-select-item">
                                <span class="box_select-content">登录日志</span>
                            </li>
                            <li class="box-select-item">
                                <span class="box_select-content">图书信息维护日志</span>
                            </li>
                            <li class="box-select-item">
                                <span class="box_select-content">用户信息维护日志</span>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>