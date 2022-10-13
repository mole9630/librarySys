<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>
<body>
<div class="logo">
    <div class="logocontent">
        xxxxx管理信息系统
    </div>
</div>
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
        <%
            String url="jdbc:mysql://localhost:3306/library";
            String usr="library";
            String password="L6fWDw2XWXLZYkDY";
            String sql;
            Connection con=null;
            Statement stm=null;
            ResultSet rs=null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con= DriverManager.getConnection(url,usr,password);
                stm=con.createStatement();
                sql="select * from user";
                rs=stm.executeQuery(sql);
                out.print("<table border='1px solid blue'>");
                out.print("<tr><td>用户ID</td><td>用户名</td><td>用户密码</td><td>备注</td><td>操作</td></tr>");
                while (rs.next()){
                    int id=rs.getInt(1);
                    String username=rs.getString(2);
                    String userpwd=rs.getString(3);
                    String memo=rs.getString(4);
                    out.print("<tr><td>"+id+"</td><td>"+username+"</td><td>"+ userpwd + "</td><td>" +memo + "</td><td>"+"<a href='#'>操作</a>"+"</td></tr>");
                }
                out.print("</table>");
            } catch (Exception e) {
                e.printStackTrace();
            }
        %>
    </div>
    <div class="clear"></div>
</div>
<div class="foot">
    <div class="content">
        联系方式：1243546352
    </div>
</div>
</body>
</html>
