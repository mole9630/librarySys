<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户增加</title>
    <link rel="stylesheet" href="../../assets/css/admin/home.css">
</head>
<body>
<%@ include file="../left-nav.jsp"%>
    <div class="user_right">
        <form action="#" method="post">
            <table>
                <tr>
                    <td>卡号</td>
                    <td>
                        <input type="text" name="u_card_id" placeholder="请输入卡号">
                    </td>
                </tr>
                <tr>
                    <td>姓名</td>
                    <td>
                        <input type="text" name="u_name" placeholder="请输入姓名">
                    </td>
                </tr>
                <tr>
                    <td>密码</td>
                    <td>
                        <input type="password" name="u_password" placeholder="请输入密码">
                    </td>
                </tr>
                <tr>
                    <td>已交押金</td>
                    <td>
                        <input type="text" name="u_deposit" placeholder="请输入已交押金">
                    </td>
                </tr>
                <tr>
                    <td>卡内余额</td>
                    <td>
                        <input type="text" name="u_money" placeholder="请输入卡内余额">
                    </td>
                </tr>
                <tr>
                    <td>生日</td>
                    <td>
                        <input type="date" name="u_birthday">
                    </td>
                </tr>
                <tr>
                    <td>身份证号码</td>
                    <td>
                        <input type="text" name="u_identification_number" placeholder="请输入身份证号码">
                    </td>
                </tr>
                <tr>
                    <td>手机号</td>
                    <td>
                        <input type="text" name="u_phone" placeholder="请输入手机号">
                    </td>
                </tr>
                <tr>
                    <td>电子邮件</td>
                    <td>
                        <input type="email" name="u_mail" placeholder="请输入电子邮件">
                    </td>
                </tr>
                <tr>
                    <td>住址</td>
                    <td>
                        <input type="text" name="u_address" placeholder="请输入住址">
                    </td>
                </tr>
                <tr>
                    <td>账户状态</td>
                    <td>
                        <select name="u_status">
                            <option>封禁</option>
                            <option>正常</option>
                        </select>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
