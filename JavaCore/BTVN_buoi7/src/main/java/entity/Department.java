package entity;

public class Department {
    private Integer departmentId;
    private String departmentName;
    private Integer quantityAccount;
    public Department(Integer departmentId, Integer departmentName, Integer quantityAccount) {
        this.departmentId = departmentId;
    }

    public Department() {
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getQuantityAccount() {
        return quantityAccount;
    }

    public void setQuantityAccount(Integer quantityAccount) {
        this.quantityAccount = quantityAccount;
    }
    public void hienThiTheoDong(){

        System.out.printf("|%-15s|%-30s|%-10s|\n",getDepartmentId(),getDepartmentName(),getQuantityAccount());

    }
}
