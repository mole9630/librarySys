<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="renderer" content="webkit">

  <title></title>

  <meta name="keywords" content="">
  <meta name="description" content="">

  <link rel="shortcut icon" href="favicon.ico">
  <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
  <link href="css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
  <link href="css/animate.css" rel="stylesheet">
  <link href="css/style.css?v=4.1.0" rel="stylesheet">
</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<div id="wrapper">
  <!--左侧导航开始-->
  <nav class="navbar-default navbar-static-side" role="navigation">
    <div class="nav-close"><i class="fa fa-times-circle"></i>
    </div>
    <div class="sidebar-collapse">
      <ul class="nav" id="side-menu">
        <li class="nav-header">
          <div class="dropdown profile-element">
            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                                    <span class="block m-t-xs" style="font-size:20px;">
                                        <i class="fa fa-area-chart"></i>
                                        <strong class="font-bold">相城市图书馆</strong>
                                    </span>
                                </span>
            </a>
          </div>
          <div class="logo-element">相城市图书馆</div>
        </li>
        <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
          <span class="ng-scope">功能</span>
        </li>
        <li>
          <a class="J_menuItem" href="index_v1.jsp">
            <i class="fa fa-home"></i>
            <span class="nav-label">主页</span>
          </a>
        </li>
        <li>
          <a class="J_menuItem" href="index_v2.jsp">
            <i class="fa fa-home"></i>
            <span class="nav-label">用户管理</span>
          </a>
        </li>
        <li>
          <a  class="J_menuItem" href="/BookAll">
            <i class="fa fa fa-bar-chart-o"></i>
            <span class="nav-label">图书管理</span>
          </a>
        </li>
      </ul>
    </div>
  </nav>
  <!--左侧导航结束-->
  <!--右侧部分开始-->
  <div id="page-wrapper" class="gray-bg dashbard-1">
    <div class="row J_mainContent" id="content-main">
      <iframe id="J_iframe" width="100%" height="100%" src="index_v1.jsp?v=4.0" frameborder="0" data-id="index_v1.html" seamless></iframe>
    </div>
  </div>
  <!--右侧部分结束-->
</div>

<!-- 全局js -->
<script src="js/jquery.min.js?v=2.1.4"></script>
<script src="js/bootstrap.min.js?v=3.3.6"></script>
<script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="js/plugins/layer/layer.min.js"></script>

<!-- 自定义js -->
<script src="js/hAdmin.js?v=4.1.0"></script>
<script type="text/javascript" src="js/index.js"></script>

<!-- 第三方插件 -->
<script src="js/plugins/pace/pace.min.js"></script>

</body>

</html>
