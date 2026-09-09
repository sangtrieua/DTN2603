package backend;

import entity.Account;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QLAccount implements IQLAccount {
    private String url;
    private String user;
    private String password;
    private List<Account> accounts;
    private Scanner sc=new Scanner(System.in);
    public QLAccount() {
            url="jdbc:mysql://localhost:3306/dtn2603_testing_system";
            user="root";
            password="123456";
            accounts=new ArrayList<>();
    }

    public static void main(String[] args) {
        QLAccount obj=new QLAccount();
        obj.hienthi();
    }
    public void hienthi() {
    String sql="SELECT * FROM dtn2603_testing_system.account;";
        try {
            Connection con= DriverManager.getConnection(url,user,password);
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            System.out.println("DANH SÁCH ACCOUNT");
            System.out.println("+==========+===================================+===============+====================+==========+==========+====================+==========+");
            System.out.printf("|%-10s|%-35s|%-15s|%-20s|%-10s|%-10s|%-20s|%-10s|\n","Accout ID","Email","userName","fullName","departmentId","positionId","createDate","gender");
            System.out.println("+==========+===================================+===============+====================+==========+==========+====================+==========+");
            while (rs.next()) {
                Account a=new Account();
                a.setAccountId(rs.getInt("account_id"));
                a.setEmail(rs.getString("email"));
                a.setUserName(rs.getString("username"));
                a.setDepartmentId(rs.getString("department_id"));
                a.setFullName(rs.getString("fullname"));
                a.setPositionId(rs.getString("position_id"));
                a.setCreateDate(rs.getObject("create_date", LocalDate.class));
                a.setGender(rs.getString("gender"));
                a.hienThiTheoDong();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
