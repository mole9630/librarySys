<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="adm/css/bootstrap-4.6.1-dist/css/bootstrap.css"/>
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
                <form action="/SelectBook" method="get">
                    <input type="text" name="b_name" placeholder="请输入图书信息" class="input-sm form-control">
                    <span class="input-group-btn" style="margin-left: 10px;">
                        <input type="submit" class="btn btn-primary" value="搜索">
                    </span>
                </form>
            </div>
        </div>
        <div class="col-md-2">
            <a href="/BookAll" class="btn btn-info">刷新</a>
            <a href="book_add.jsp" class="btn btn-success">添加</a>
        </div>
    </div>
</div>
<table class="table">
    <thead class="thead-light">
    <tr>
        <th>IBSN</th>
        <th>书名</th>
        <th>出版日期</th>
        <th>作者</th>
        <th>价格</th>
        <th>总页数</th>
        <th>图书类别</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="books">
        <tr>
            <td>${books.getbIBSN()}</td>
            <td>${books.getbName()}</td>
            <td>${books.getbPublicationDate()}</td>
            <td>${books.getbAuthor()}</td>
            <td>${books.getbPrice()}</td>
            <td>${books.getbPageNumber()}</td>
            <td>${books.getbClassification()}</td>
            <td>
                <a href="#" class="btn btn-primary btn-operate">修改</a>
                <a href="/DeleteBook?bIBSN=${books.getbIBSN()}" class="btn btn-danger btn-operate">删除</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

