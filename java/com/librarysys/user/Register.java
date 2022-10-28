package com.librarysys.user;

import com.librarysys.db.DBConnection;
import com.librarysys.db.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Register {
    private String userPhone;
    private String userPassword;
    private String userRePassword;
    private String userEmail;
    private String userName;
    private String userIdentificationNumber;
    private String userAddress;

    // 构造函数
    public Register() {
    }
    public Register(String userPhone, String userPassword, String userRePassword, String userEmail, String userName, String userIdentificationNumber, String userAddress) {
        this.userPhone = userPhone;
        this.userPassword = userPassword;
        this.userRePassword = userRePassword;
        this.userEmail = userEmail;
        this.userName = userName;
        this.userIdentificationNumber = userIdentificationNumber;
        this.userAddress = userAddress;
    }

    // Getter & Setter
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
    public String getUserRePassword() {
        return userRePassword;
    }
    public void setUserRePassword(String userRePassword) {
        this.userRePassword = userRePassword;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserIdentificationNumber() {
        return userIdentificationNumber;
    }
    public void setUserIdentificationNumber(String userIdentificationNumber) {
        this.userIdentificationNumber = userIdentificationNumber;
    }
    public String getUserAddress() {
        return userAddress;
    }
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    // 注册函数
    public int userRegister(String userPhone, String userPassword, String userRePassword, String userEmail, String userName, String userIdentificationNumber, String userAddress) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet sqlResult = null;
        int statusCode = -1;

        DBConnection dbc = new DBConnection();
        con = dbc.getDBConnection();

        String sqlStr = "INSERT INTO user(u_name, u_password, u_deposit, u_identification_number, u_phone, u_mail, u_address, u_status) VALUES(?, ?, 0, 0, ?, ?, ?, ?, ?, 1)";


        DBUtil dbu = new DBUtil();
        try {
            pstm = con.prepareStatement(sqlStr);
            pstm.setString(1, userName);
            pstm.setString(2, userPassword);
            pstm.setString(3, userIdentificationNumber);
            pstm.setString(4, userPhone);
            pstm.setString(5, userEmail);
            pstm.setString(6, userAddress);
            pstm.setString(7, userPassword);
            statusCode = pstm.executeUpdate(sqlStr);

            if (statusCode > 0){
                System.out.println("[info] " + userPhone + "用户注册成功!");
            }
            else if (statusCode == 0){
                System.out.println("[info] " + userPhone + "用户注册失败,请稍后重试.");
            }
            else {
                System.out.println("[info] 非法请求");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbc.closeDB(con, pstm, sqlResult);
            return statusCode;
        }
    }
}
