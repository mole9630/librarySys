package com.librarysys.user;

import com.librarysys.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.lang.System.out;

public class Login {
    private String userPhone;
    private String userPassword;

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

    // 判断用户是否存在
    public int userLogin(String userPhone, String userPassword) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet sqlResult = null;
        int statusCode = -1;

        DBConnection dbc = new DBConnection();
        con = dbc.getDBConnection();
        int n = -1;

        try {
            String sql = "SELECT * FROM user WHERE u_phone=? and u_password=?";

            pstm = con.prepareStatement(sql);
            pstm.setString(1, userPhone);
            pstm.setString(2, userPassword);
            sqlResult = pstm.executeQuery();

            if (sqlResult.next()){
                statusCode = 1;
                System.out.print("[info] " + userPhone + "用户登录成功!\n");
            }
            else {
                statusCode = 0;
                System.out.print("[info] " + userPhone + "用户不存在或者密码错误,请检查后重试.\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbc.closeDB(con, pstm, sqlResult);
            return statusCode;
        }
    }
}
