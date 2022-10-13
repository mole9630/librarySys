<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>
<body>
    <%@ include file="header.jsp" %>
    <div class="out">
        <div class="left">
            <ul>
                <li><a href="userAdministration.jsp">用户管理</a></li>
                <li><a href="studentManagement.jsp">学生管理</a></li>
                <li><a href="bookManagement.jsp">图书管理</a></li>
                <li><a href="bookLoan.jsp">图书借阅</a></li>
                <li><a href="bookAlert.jsp">图书预警</a></li>
            </ul>
        </div>
        <div class="right">
            <div class="yhgl">用户管理</div>
            <div class="xsgl">学生管理</div>
            <div class="tsgl">图书管理</div>
            <div class="tsjy">图书借阅</div>
            <div class="tsyj">图书预警</div>
        </div>
        <div class="clear"></div>
    </div>
    <%@ include file="footer.jsp" %>
</body>
</html>
