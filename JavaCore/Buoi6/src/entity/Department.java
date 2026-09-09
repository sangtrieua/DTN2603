package entity;

public class Department {
    private int departmentId;
    private String departmentName;
    private int quantityAccount;
    public Department(int departmentId, int departmentName, int quantityAccount) {
        this.departmentId = departmentId;
    }

    public Department() {
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getQuantityAccount() {
        return quantityAccount;
    }

    public void setQuantityAccount(int quantityAccount) {
        this.quantityAccount = quantityAccount;
    }
    public void hienThiTheoDong(){

        System.out.printf("|%-15s|%-30s|%-10s|\n",getDepartmentId(),getDepartmentName(),getQuantityAccount());

    }
}
