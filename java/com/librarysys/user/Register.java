package com.librarysys.user;

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
}
