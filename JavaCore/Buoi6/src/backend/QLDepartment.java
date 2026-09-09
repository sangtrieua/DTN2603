package backend;

import entity.Account;
import entity.Department;

import java.sql.*;
import java.time.LocalDate;

public class QLDepartment implements IQLDepartment  {
    private String url;
    private String user;
    private String password;

    public QLDepartment() {
        url="jdbc:mysql://localhost:3306/dtn2603_testing_system";
        user="root";
        password="123456";
    }

    public static void main(String[] args) {
        QLDepartment qd=new QLDepartment();
        qd.hienthi();
    }
    @Override
    public void hienthi() {
        String sql="SELECT * FROM dtn2603_testing_system.department;";
        try {
            Connection con= DriverManager.getConnection(url,user,password);
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            System.out.println("DANH SÁCH DEPARTMENT");
            System.out.println("+===============+==============================+==========+");
            System.out.printf("|%-15s|%-30s|%-10s|\n","depID","Dep Name","Quantity Account");
            System.out.println("+===============+==============================+==========+");
            while (rs.next()) {
               Department dep=new Department();
               dep.setDepartmentId(rs.getInt("department_id"));
               dep.setDepartmentName(rs.getString("department_name"));
               dep.setQuantityAccount(rs.getInt("quantity_account"));
               dep.hienThiTheoDong();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
