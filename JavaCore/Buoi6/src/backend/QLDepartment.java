package backend;

import entity.Account;
import entity.Department;

import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class QLDepartment implements IQLDepartment  {
    private String url;
    private String user;
    private String password;
    private Scanner sc=new Scanner(System.in);
    public QLDepartment() {
        url="jdbc:mysql://localhost:3306/dtn2603_testing_system";
        user="root";
        password="123456";
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

    @Override
    public void themDepartment() {
        System.out.println("bạn có muốn tự Nhập departmentId:             1:có                khác:tự động tăng");
        String choose=sc.nextLine();
        StringBuffer columSub=new StringBuffer();
        StringBuffer valueSub=new StringBuffer();
        switch (choose) {
            case "1":

                Integer departmentId;
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
                                System.out.println(" departmentId này đã tồn tại hãy nhập lại!!");
                            }
                            else {

                                break;
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
                columSub.append(",department_id");
                valueSub.append(",").append(departmentId);
                break;
            default:
        }

        System.out.println("nhập departmentName:    ");
        String departmentName=sc.nextLine();

        columSub.insert(0,"department_name");
        valueSub.insert(0,"'"+departmentName+"'");
        String sql="INSERT INTO department\n" +
                "    ("+columSub+")\n" +
                "VALUES\n" +
                "    ("+valueSub+")";
        try {
            Connection con= DriverManager.getConnection(url,user,password);
            PreparedStatement st=con.prepareStatement(sql);

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
    public void suaDepartmentNameTheoId() {
        Integer departmentId;
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
                        System.out.println(" departmentId này không tồn tại hãy nhập lại!!");

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
        System.out.println("nhập departmentName:    ");
        String departmentName=sc.nextLine();
        String sql="UPDATE department SET department_name=? WHERE department_id=?;";
        try {
            Connection con= DriverManager.getConnection(url,user,password);
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1, departmentName);
            st.setInt(2, departmentId);
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
    public void xoaDepartment() {
        Integer departmentId;
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
                        System.out.println(" departmentId này không tồn tại hãy nhập lại!!");

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
        String sql="DELETE FROM  department WHERE department_id=?;";
        try {
            Connection con= DriverManager.getConnection(url,user,password);
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, departmentId);
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
        QLDepartment qd=new QLDepartment();
        qd.xoaDepartment();
        qd.hienthi();
    }
}
