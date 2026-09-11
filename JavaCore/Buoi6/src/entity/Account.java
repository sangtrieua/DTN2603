package entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Account {
    private int accountId;
    private String email;
    private String userName;
    private String fullName;
    private Integer departmentId;
    private Integer positionId;
    private LocalDate createDate;
    private String gender;

    public Account(String gender, LocalDate createDate, Integer departmentId, String email, String fullName, String userName, int accountId, Integer positionId) {
        this.gender = gender;
        this.createDate = createDate;
        this.departmentId = departmentId;
        this.email = email;
        this.fullName = fullName;
        this.userName = userName;
        this.accountId = accountId;
        this.positionId = positionId;
    }
    public void hienThiTheoDong(){
        System.out.printf("|%-10s|%-35s|%-15s|%-20s|%-10s|%-10s|%-20s|%-10s|\n",this.accountId,this.email,this.userName,this.fullName,this.departmentId,this.positionId,this.createDate,this.gender);

    }
    public Account() {
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
