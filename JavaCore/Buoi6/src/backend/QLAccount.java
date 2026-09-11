package backend;

import entity.Account;

import java.sql.*;
import java.text.SimpleDateFormat;
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
                a.setDepartmentId(rs.getInt("department_id"));
                a.setFullName(rs.getString("fullname"));
                a.setPositionId(rs.getInt("position_id"));
                a.setCreateDate(rs.getObject("create_date", LocalDate.class));
                a.setGender(rs.getString("gender"));
                a.hienThiTheoDong();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void themAccount() {
        String email;
        String userName;
        String fullName;
        Integer departmentId;
        Integer positionId;
        LocalDate createDate;
        String gender;
        System.out.println("Nhập email");
        email=sc.nextLine();
        System.out.println("Nhập userName");
        userName=sc.nextLine();
        System.out.println("Nhập fullName");
        fullName=sc.nextLine();
        while (true) {
            System.out.println("Nhập departmentId");
            if(sc.hasNextInt()) {
            departmentId = sc.nextInt();
                sc.nextLine();
                String sql="SELECT 1 FROM dtn2603_testing_system.department WHERE department_id=?;";
                try {
                    Connection con= DriverManager.getConnection(url,user,password);
                    PreparedStatement st=con.prepareStatement(sql);
                    st.setInt(1, departmentId);
                    ResultSet rs=st.executeQuery();
                    if (rs.next()) {
                        break;
                    }
                    else {
                        System.out.println(" departmentId này chưa tồn tại hãy nhập lại!!");
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            else  {
                System.out.println("hãy nhập 1 số nguyên");
                sc.nextLine();
            }
        }
        while (true) {
            System.out.println("Nhập positionId");
            if(sc.hasNextInt()) {
                positionId = sc.nextInt();
                sc.nextLine();
                String sql="SELECT 1 FROM dtn2603_testing_system.position WHERE position_id=?;";
                try {
                    Connection con= DriverManager.getConnection(url,user,password);
                    PreparedStatement st=con.prepareStatement(sql);
                    st.setInt(1, positionId);
                    ResultSet rs=st.executeQuery();
                    if (rs.next()) {
                        break;
                    }
                    else {
                        System.out.println(" positionId này chưa tồn tại hãy nhập lại!!");
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            else  {
                System.out.println("hãy nhập 1 số nguyên");
                sc.nextLine();
            }
        }

        System.out.println("Nhập gender:Nhập: 1:Nam      2:Nữ        khác:Chưa xác định");
        String choosenGender=sc.nextLine();
        switch(choosenGender) {
            case "1":gender="nam";
            break;
            case "2": gender="nữ";
            break;
            default: gender="chưa xác định";
        }
        String sql="INSERT INTO account\n" +
                "    (email, username, fullname, department_id, position_id,gender)\n" +
                "VALUES\n" +
                "    (?,   ?,   ?,  ?, ?,?)";
        try {
            Connection con= DriverManager.getConnection(url,user,password);
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1, email);
            st.setString(2, userName);
            st.setString(3, fullName);
            st.setInt(4, departmentId);
            st.setInt(5, positionId);
            st.setString(6, gender);
            int i=st.executeUpdate();
            if (i>0) {
                System.out.println("thêm Thành công");
            }
            else {
                System.out.println("thêm Thất bại");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void suaUsernameTheoId() {
        Integer accountId;
        String userName;
        while (true) {
            System.out.println("Nhập accountId");
            if(sc.hasNextInt()) {
                accountId = sc.nextInt();
                sc.nextLine();
                String sql="SELECT 1 FROM dtn2603_testing_system.account WHERE account_id=?;";
                try {
                    Connection con= DriverManager.getConnection(url,user,password);
                    PreparedStatement st=con.prepareStatement(sql);
                    st.setInt(1, accountId);
                    ResultSet rs=st.executeQuery();
                    if (rs.next()) {
                        break;
                    }
                    else {
                        System.out.println(" account_id này chưa tồn tại hãy nhập lại!!");
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            else  {
                System.out.println("hãy nhập 1 số nguyên");
                sc.nextLine();
            }
        }
        System.out.println("nhập username:");
        userName=sc.nextLine();
        //String sql="UPDATE tai_lieu SET ten_nxb=? where ma_tai_lieu=?;";

        String sql="UPDATE account SET username=? WHERE account_id=?;";
        try {
            Connection con= DriverManager.getConnection(url,user,password);
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1, userName);
            st.setInt(2, accountId);
            int i=st.executeUpdate();
            if (i>0) {
                System.out.println("sửa Thành công");
            }
            else {
                System.out.println("sửa Thất bại");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void xoaAccount() {
        Integer accountId;
        while (true) {
            System.out.println("Nhập accountId");
            if(sc.hasNextInt()) {
                accountId = sc.nextInt();
                sc.nextLine();
                String sql="SELECT 1 FROM dtn2603_testing_system.account WHERE account_id=?;";
                try {
                    Connection con= DriverManager.getConnection(url,user,password);
                    PreparedStatement st=con.prepareStatement(sql);
                    st.setInt(1, accountId);
                    ResultSet rs=st.executeQuery();
                    if (rs.next()) {
                        break;
                    }
                    else {
                        System.out.println(" account_id này chưa tồn tại hãy nhập lại!!");
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            else  {
                System.out.println("hãy nhập 1 số nguyên");
                sc.nextLine();
            }
        }
//        String sql = "DELETE FROM tai_lieu WHERE ma_tai_lieu = ?";

        String sql="DELETE FROM  account WHERE account_id=?;";
        try {
            Connection con= DriverManager.getConnection(url,user,password);
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, accountId);
            int i=st.executeUpdate();
            if (i>0) {
                System.out.println("xóa Thành công");
            }
            else {
                System.out.println("xóa Thất bại");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static void main(String[] args) {
        QLAccount obj=new QLAccount();

        obj.xoaAccount();
        obj.hienthi();
    }
}
