package backend.repository.impl;

import backend.repository.IQLNSRepository;
import entity.Account;
import entity.Department;
import entity.Postion;
import enums.PositionName;
import ultils.JDBCUtils;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class QLNSReponsitoryImpl implements IQLNSRepository {
    @Override
    public List<Account> getAccounts() {
        List<Account> accounts = new ArrayList<>();
        try {
            Connection con= JDBCUtils.getConnection();
            String sql="SELECT * FROM dtn2603_testing_system.account;";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while (rs.next()) {
                Account a=new Account();
                a.setAccountId(rs.getInt("account_id"));
                a.setEmail(rs.getString("email"));
                a.setUserName(rs.getString("username"));
                a.setDepartment(this.getDepartmentById(rs.getInt("department_id")));
                a.setFullName(rs.getString("fullname"));
                a.setPostion(this.getPostionById(rs.getInt("position_id")));
                a.setCreateDate(rs.getObject("create_date", LocalDate.class));
                a.setGender(rs.getString("gender"));
                accounts.add(a);
            }
            JDBCUtils.close(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return accounts;
    }

    @Override
    public boolean kiemTraTonTaiAccountId(Integer accountId) {
        String sql="SELECT 1 FROM dtn2603_testing_system.account WHERE account_id=?;";
        try {
            Connection con= JDBCUtils.getConnection();
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, accountId);
            ResultSet rs=st.executeQuery();
            if (rs.next()) {
                return true;
            }
            else {
                JDBCUtils.close(con);
               return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean suaUsernameTheoId(Integer accountId, String userName) {
        String sql="UPDATE account SET username=? WHERE account_id=?;";
        try {
            Connection con= JDBCUtils.getConnection();
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1, userName);
            st.setInt(2, accountId);
            int i=st.executeUpdate();
            if (i>0) {
                return true;
            }
            else {
                JDBCUtils.close(con);
                return false;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean xoaAccountTheoId(Integer accountId) {
        String sql="DELETE FROM  account WHERE account_id=?;";
        try {
            Connection con= JDBCUtils.getConnection();
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, accountId);
            int i=st.executeUpdate();
            if (i>0) {
                return true;
            }
            else {
                JDBCUtils.close(con);
                return false;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean kiemTraTonTaiDepartmentId(Integer departmentId) {
        String sql="SELECT 1 FROM dtn2603_testing_system.department WHERE department_id=?;";
        try {
            Connection con= JDBCUtils.getConnection();
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, departmentId);
            ResultSet rs=st.executeQuery();
            if (rs.next()) {
                return true;
            }
            else {
                JDBCUtils.close(con);
                return  false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean kiemTraTonTaiPostionId(Integer positionId) {
        String sql="SELECT 1 FROM dtn2603_testing_system.position WHERE position_id=?;";
        try {
            Connection con= JDBCUtils.getConnection();
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, positionId);
            ResultSet rs=st.executeQuery();
            if (rs.next()) {
                return true;
            }
            else {
                JDBCUtils.close(con);
                return  false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean themAccount(String email, String userName, String fullName, Integer departmentId, Integer positionId, String gender) {
        String sql="INSERT INTO account\n" +
                "    (email, username, fullname, department_id, position_id,gender)\n" +
                "VALUES\n" +
                "    (?,   ?,   ?,  ?, ?,?)";
        try {
            Connection con= JDBCUtils.getConnection();
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1, email);
            st.setString(2, userName);
            st.setString(3, fullName);
            st.setInt(4, departmentId);
            st.setInt(5, positionId);
            st.setString(6, gender);
            int i=st.executeUpdate();
            if (i>0) {
                return true;
            }
            else {
                JDBCUtils.close(con);
                return false;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Department getDepartmentById(int departmentId) {
        Department department = new Department();
        try {
            Connection con= JDBCUtils.getConnection();
            String sql="SELECT * FROM dtn2603_testing_system.department where department_id=?;";
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1,departmentId);
            ResultSet rs=st.executeQuery();
            while (rs.next()) {
                department.setDepartmentId(rs.getInt("department_id"));
                department.setDepartmentName(rs.getString("department_name"));
                department.setQuantityAccount(rs.getInt("quantity_account"));
            }
            JDBCUtils.close(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  department;
    }
    public Postion getPostionById(int PostionId) {
        Postion postion = new Postion();
        try {
            Connection con= JDBCUtils.getConnection();
            String sql="SELECT * FROM dtn2603_testing_system.position where position_id=?;";
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, PostionId);
            ResultSet rs=st.executeQuery();
            while (rs.next()) {
                postion.setPostionId(rs.getInt("position_id"));
                String postionName = rs.getString("position_name");
                switch (postionName) {
                    case "DEV": postion.setPositionName(PositionName.DEV); break;
                    case "TEST": postion.setPositionName(PositionName.TEST); break;
                    case "SCRUM_MASTER": postion.setPositionName(PositionName.SCRUM_MASTER); break;
                    case "PM": postion.setPositionName(PositionName.PM); break;
                }
            }
            JDBCUtils.close(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  postion;
    }
}
