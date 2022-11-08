package com.librarysys.user;

import com.librarysys.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    private String userPhone;
    private String userPassword;
    private String isAdministrator;

    // 构造方法
    public Login() {
    }
    public Login(String userPhone, String userPassword) {
        this.userPhone = userPhone;
        this.userPassword = userPassword;
    }

    //getter & setter
    public String getUserPhone() {
        return userPhone;
    }
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public String getIsAdministrator() {
        return isAdministrator;
    }
    public void setIsAdministrator(String isAdministrator) {
        this.isAdministrator = isAdministrator;
    }

    // 判断用户是否存在
    public int userLogin(String userPhone, String userPassword) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet sqlResult = null;
        int statusCode = -1;

        DBConnection dbc = new DBConnection();
        con = dbc.getDBConnection();

        try {
            String sqlStr = "SELECT u_status FROM user WHERE u_phone=? and u_password=?";

            pstm = con.prepareStatement(sqlStr);
            pstm.setString(1, userPhone);
            pstm.setString(2, userPassword);
            sqlResult = pstm.executeQuery();

            if (sqlResult.next()){
                statusCode = 1;
                System.out.println("[info] " + userPhone + "用户登录成功!");
            }
            else {
                statusCode = 0;
                System.out.println("[info] " + userPhone + "用户不存在或者密码错误,请检查后重试.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbc.closeDB(con, pstm, sqlResult);
            return statusCode;
        }
    }
}
