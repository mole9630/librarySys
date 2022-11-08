<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书增加</title>
</head>
<body>
    <div style="width: 500px;margin: 5px auto">
        <form action="#" method="post">
            <table style="height: 150px">
                <tr>
                    <td>IBSN</td>
                    <td>
                        <input type="text" name="b_IBSN" placeholder="请输入IBSN">
                    </td>
                </tr>
                <tr>
                    <td>书名</td>
                    <td>
                        <input type="text" name="b_name" placeholder="请输入书名">
                    </td>
                </tr>
                <tr>
                    <td>出版日期</td>
                    <td>
                        <input type="date" name="b_publication_date" class="form-control">
                    </td>
                </tr>
                <tr>
                    <td>作者</td>
                    <td>
                        <input type="text" name="b_author" placeholder="请输入作者">
                    </td>
                </tr>
                <tr>
                    <td>价格</td>
                    <td>
                        <input type="text" name="b_price" placeholder="请输入价格">
                    </td>
                </tr>
                <tr>
                    <td>总页数</td>
                    <td>
                        <input type="text" name="b_page_number" placeholder="请输入总页数">
                    </td>
                <tr>
                    <td>出版状态</td>
                    <td>
                        <select name="b_publication_status">
                            <option>未出版</option>
                            <option>已出版</option>
                            <option>出版中</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>图书分类</td>
                    <td>
                        <option>未出版</option>
                        <option>已出版</option>
                        <option>出版中</option>
                    </td>
                <tr>
                <tr>
                    <td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="submit" value="添加">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="reset" value="取消">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
