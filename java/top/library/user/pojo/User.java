package top.library.user.pojo;

public class User {
    private Integer uCardId;
    private String uName;
    private String uPassword;
    private Integer uDeposit;
    private Float uMoney;
    private String uBirthday;
    private String uIdentificationNumber;
    private String uPhone;
    private String uEmail;
    private String uAddress;
    private Integer uStatus;
    private Integer uIdentity;

    // 构造函数
    public User() {
    }

    public User(Integer uCardId, String uName, String uPassword, Integer uDeposit, Float uMoney, String uBirthday, String uIdentificationNumber, String uPhone, String uEmail, String uAddress, Integer uStatus, Integer uIdentity) {
        this.uCardId = uCardId;
        this.uName = uName;
        this.uPassword = uPassword;
        this.uDeposit = uDeposit;
        this.uMoney = uMoney;
        this.uBirthday = uBirthday;
        this.uIdentificationNumber = uIdentificationNumber;
        this.uPhone = uPhone;
        this.uEmail = uEmail;
        this.uAddress = uAddress;
        this.uStatus = uStatus;
        this.uIdentity = uIdentity;
    }

    // 注册
    public User(String uPhone, String uPassword, String uEmail, String uName, String uIdentificationNumber, String uAddress) {
        this.uPhone = uPhone;
        this.uPassword = uPassword;
        this.uEmail = uEmail;
        this.uName = uName;
        this.uIdentificationNumber = uIdentificationNumber;
        this.uAddress = uAddress;
    }

    // Getter & Setter
    public Integer getuCardId() {
        return uCardId;
    }
    public void setuCardId(Integer uCardId) {
        this.uCardId = uCardId;
    }
    public String getuName() {
        return uName;
    }
    public void setuName(String uName) {
        this.uName = uName;
    }
    public String getuPassword() {
        return uPassword;
    }
    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }
    public Integer getuDeposit() {
        return uDeposit;
    }
    public void setuDeposit(Integer uDeposit) {
        this.uDeposit = uDeposit;
    }
    public Float getuMoney() {
        return uMoney;
    }
    public void setuMoney(Float uMoney) {
        this.uMoney = uMoney;
    }
    public String getuBirthday() {
        return uBirthday;
    }
    public void setuBirthday(String uBirthday) {
        this.uBirthday = uBirthday;
    }
    public String getuIdentificationNumber() {
        return uIdentificationNumber;
    }
    public void setuIdentificationNumber(String uIdentificationNumber) {
        this.uIdentificationNumber = uIdentificationNumber;
    }
    public String getuPhone() {
        return uPhone;
    }
    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }
    public String getuEmail() {
        return uEmail;
    }
    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }
    public String getuAddress() {
        return uAddress;
    }
    public void setuAddress(String uAddress) {
        this.uAddress = uAddress;
    }
    public Integer getuStatus() {
        return uStatus;
    }
    public void setuStatus(Integer uStatus) {
        this.uStatus = uStatus;
    }
    public Integer getuIdentity() {
        return uIdentity;
    }
    public void setuIdentity(Integer uIdentity) {
        this.uIdentity = uIdentity;
    }

    @Override
    public String toString() {
        return "User{" +
                "uCardId=" + uCardId +
                ", uName='" + uName + '\'' +
                ", uPassword='" + uPassword + '\'' +
                ", uDeposit=" + uDeposit +
                ", uMoney=" + uMoney +
                ", uBirthday='" + uBirthday + '\'' +
                ", uIdentificationNumber='" + uIdentificationNumber + '\'' +
                ", uPhone='" + uPhone + '\'' +
                ", uEmail='" + uEmail + '\'' +
                ", uAddress='" + uAddress + '\'' +
                ", uStatus=" + uStatus +
                ", uIdentity=" + uIdentity +
                '}';
    }
}
