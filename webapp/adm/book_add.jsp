<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="adm/css/bootstrap-4.6.1-dist/css/bootstrap.css"/>
    <style>
        form{
            text-align: center;
        }
    </style>
</head>
<body>
<form action="#" method="post">
    <h5>图书添加</h5>
    <div class="form-group">
        I&nbsp;&nbsp;B&nbsp;&nbsp;S&nbsp;&nbsp;N:<input type="text" name="b_IBSN"><br>
    </div>
    <div class="form-group">
        图书名称:<input type="text" name="b_name"><br>
    </div>
    <div class="form-group">
        作&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;者:<input type="text" name="b_author"><br>
    </div>
    <div class="form-group">
        价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;格:<input type="text" name="b_price"><br>
    </div>
    <div class="form-group">
        总&nbsp;页&nbsp;&nbsp;数:<input type="text" name="b_page_number"><br>
    </div>
    <div class="form-group">
        图书类别:<input type="text" name="b_classification"><br>
    </div>
    <div class="form-group">
        出版日期:<input type="date" name="b_publication_date"><br>
    </div>
    <div class="form-group">
        <button class="btn btn-primary btn-lg btn-block" type="submit">添加</button>
        <button class="btn btn-primary btn-lg btn-block" type="reset">重置</button>
    </div>
</form>
</body>
</html>
