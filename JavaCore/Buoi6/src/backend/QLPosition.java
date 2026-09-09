package backend;

import entity.Account;
import entity.Postion;

import javax.swing.text.Position;
import java.sql.*;
import java.time.LocalDate;

public class QLPosition implements IQLPosition{
    private String url;
    private String user;
    private String password;

    public QLPosition() {
        url="jdbc:mysql://localhost:3306/dtn2603_testing_system";
        user="root";
        password="123456";
    }

    public static void main(String[] args) {
        QLPosition q=new QLPosition();
        q.hienthi();
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
}
