package entity;

import java.time.LocalDate;

public class Account {
    private Integer accountId;
    private String email;
    private String userName;
    private String fullName;
    private Department department;
    private Postion postion;
    private LocalDate createDate;
    private String gender;

    public Account(String gender, LocalDate createDate, Department department, String email, String fullName, String userName, Integer accountId, Postion postion) {
        this.gender = gender;
        this.createDate = createDate;
        this.department = department;
        this.email = email;
        this.fullName = fullName;
        this.userName = userName;
        this.accountId = accountId;
        this.postion = postion;
    }
    public void hienThiTheoDong(){
        System.out.printf("|%-10s|%-35s|%-15s|%-20s|%-10s|%-10s|%-20s|%-10s|\n",this.accountId,this.email,this.userName,this.fullName,this.department.getDepartmentId(),this.postion.getPostionId(),this.createDate,this.gender);

    }
    public Account() {
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Postion getPostion() {
        return postion;
    }

    public void setPostion(Postion postion) {
        this.postion = postion;
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
