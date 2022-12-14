package top.library.pojo.book;

public class Book {
    private String bIBSN;
    private String bName;
    private String bPublicationDate;
    private String bAuthor;
    private Float bPrice;
    private Integer bPageNumber;
    private String bClassification;
    private Integer bPublicationStatus;
    private Integer bOrdered;
    private Integer bStatus;

    public Book() {
    }

    public Book(String bIBSN, String bName, String bPublicationDate, String bAuthor, Float bPrice, Integer bPageNumber, String bClassification, Integer bPublicationStatus, Integer bOrdered, Integer bStatus) {
        this.bIBSN = bIBSN;
        this.bName = bName;
        this.bPublicationDate = bPublicationDate;
        this.bAuthor = bAuthor;
        this.bPrice = bPrice;
        this.bPageNumber = bPageNumber;
        this.bClassification = bClassification;
        this.bPublicationStatus = bPublicationStatus;
        this.bOrdered = bOrdered;
        this.bStatus = bStatus;
    }

    public String getbIBSN() {
        return bIBSN;
    }

    public void setbIBSN(String bIBSN) {
        this.bIBSN = bIBSN;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getbPublicationDate() {
        return bPublicationDate;
    }

    public void setbPublicationDate(String bPublicationDate) {
        this.bPublicationDate = bPublicationDate;
    }

    public String getbAuthor() {
        return bAuthor;
    }

    public void setbAuthor(String bAuthor) {
        this.bAuthor = bAuthor;
    }

    public Float getbPrice() {
        return bPrice;
    }

    public void setbPrice(Float bPrice) {
        this.bPrice = bPrice;
    }

    public Integer getbPageNumber() {
        return bPageNumber;
    }

    public void setbPageNumber(Integer bPageNumber) {
        this.bPageNumber = bPageNumber;
    }

    public String getbClassification() {
        return bClassification;
    }

    public void setbClassification(String bClassification) {
        this.bClassification = bClassification;
    }

    public Integer getbPublicationStatus() {
        return bPublicationStatus;
    }

    public void setbPublicationStatus(Integer bPublicationStatus) {
        this.bPublicationStatus = bPublicationStatus;
    }

    public Integer getbOrdered() {
        return bOrdered;
    }

    public void setbOrdered(Integer bOrdered) {
        this.bOrdered = bOrdered;
    }

    public Integer getbStatus() {
        return bStatus;
    }

    public void setbStatus(Integer bStatus) {
        this.bStatus = bStatus;
    }
}
