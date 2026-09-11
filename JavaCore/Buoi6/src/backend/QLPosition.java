package backend;

import entity.Account;
import entity.Postion;

import javax.swing.text.Position;
import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class QLPosition implements IQLPosition{
    private String url;
    private String user;
    private String password;
    private Scanner sc = new Scanner(System.in);
    public QLPosition() {
        url="jdbc:mysql://localhost:3306/dtn2603_testing_system";
        user="root";
        password="123456";
    }


    @Override
    public void hienthi() {
        String sql="SELECT * FROM dtn2603_testing_system.position;";
        try {
            Connection con= DriverManager.getConnection(url,user,password);
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            System.out.println("DANH SÁCH POSTION");
            System.out.println("+===============+==============================+");
            System.out.printf("|%-15s|%-30s|\n", "POS ID", "POS NAME");
            System.out.println("+===============+==============================+");
            while (rs.next()) {
                Postion pos=new Postion();
                pos.setPostionId(rs.getInt("position_id"));
                pos.setPositionName(rs.getString("position_name"));
                pos.hienThiTheoDong();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void themPosition() {
        System.out.println("bạn có muốn tự Nhập positionId:             1:có                khác:tự động tăng");
        String choose=sc.nextLine();
        StringBuffer columSub=new StringBuffer();
        StringBuffer valueSub=new StringBuffer();
        switch (choose) {
            case "1":

                Integer positionId;
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
                                System.out.println(" positionId này đã tồn tại hãy nhập lại!!");
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
                columSub.append(",position_id");
                valueSub.append(",").append(positionId);
                break;
            default:
        }

        String postionName;
        System.out.println("nhập postionName:       1:DEV       2:TEST      3:SCRUM MASTER      khác:PM");
        String select=sc.nextLine();
        switch (select) {
            case "1":postionName="DEV";
            break;
            case "2":postionName="TEST";
            break;
            case "3":postionName="SCRUM MASTER";
            break;
            default: postionName="PM";

        }
        columSub.insert(0,"position_name");
        valueSub.insert(0,"'"+postionName+"'");
        String sql="INSERT INTO position\n" +
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
    public void suaPositionNameTheoId() {
        Integer positionId;
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
                        System.out.println(" positionId này không tồn tại hãy nhập lại!!");

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
        String postionName;
        System.out.println("nhập postionName:       1:DEV       2:TEST      3:SCRUM MASTER      khác:PM");
        String select=sc.nextLine();
        switch (select) {
            case "1":postionName="DEV";
                break;
            case "2":postionName="TEST";
                break;
            case "3":postionName="SCRUM MASTER";
                break;
            default: postionName="PM";

        }
        String sql="UPDATE position SET position_name=? WHERE position_id=?;";
        try {
            Connection con= DriverManager.getConnection(url,user,password);
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1, postionName);
            st.setInt(2, positionId);
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
    public void xoaPosition() {
        Integer positionId;
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
                        System.out.println(" positionId này không tồn tại hãy nhập lại!!");

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
        String sql="DELETE FROM  position WHERE position_id=?;";
        try {
            Connection con= DriverManager.getConnection(url,user,password);
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, positionId);
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
        QLPosition q=new QLPosition();
        q.xoaPosition();
        q.hienthi();
    }
}
