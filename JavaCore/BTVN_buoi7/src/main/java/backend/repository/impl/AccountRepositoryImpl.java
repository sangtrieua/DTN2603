package backend.repository.impl;

import backend.repository.IAccountRepository;
import backend.repository.IDepartmentRepository;
import backend.repository.IPositionRepository;
import entity.Account;
import entity.Department;
import entity.Postion;
import enums.PositionName;
import ultils.JDBCUtils;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AccountRepositoryImpl implements IAccountRepository {
    IDepartmentRepository departmentRepositoryImpl;
    IPositionRepository positionRepositoryImpl;
    public AccountRepositoryImpl() {
        departmentRepositoryImpl=new DepartmentRepositoryImpl();
        positionRepositoryImpl=new PositionRepositoryImpl();
    }
    @Override
    public List<Account> getAccounts() {
        Connection con=null;
        List<Account> accounts = new ArrayList<>();
        try {
            con= JDBCUtils.getConnection();
            String sql="SELECT * FROM dtn2603_testing_system.account;";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while (rs.next()) {
                Account a=new Account();
                a.setAccountId(rs.getInt("account_id"));
                a.setEmail(rs.getString("email"));
                a.setUserName(rs.getString("username"));
                a.setDepartment(departmentRepositoryImpl.getDepartmentById(rs.getInt("department_id")));
                a.setFullName(rs.getString("fullname"));
                a.setPostion(positionRepositoryImpl.getPostionById(rs.getInt("position_id")));
                a.setCreateDate(rs.getObject("create_date", LocalDate.class));
                a.setGender(rs.getString("gender"));
                accounts.add(a);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {JDBCUtils.close(con);}
        return accounts;
    }

    @Override
    public boolean kiemTraTonTaiAccountId(Integer accountId) {
        Connection con=null;
        String sql="SELECT 1 FROM dtn2603_testing_system.account WHERE account_id=?;";
        try {
            con= JDBCUtils.getConnection();
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, accountId);
            ResultSet rs=st.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {JDBCUtils.close(con);}
    }

    @Override
    public boolean suaUsernameTheoId(Integer accountId, String userName) {
        Connection con=null;
        String sql="UPDATE account SET username=? WHERE account_id=?;";
        try {
            con= JDBCUtils.getConnection();
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1, userName);
            st.setInt(2, accountId);
            int i=st.executeUpdate();
            return i > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {JDBCUtils.close(con);}
    }

    @Override
    public boolean xoaAccountTheoId(Integer accountId) {
        String sql="DELETE FROM  account WHERE account_id=?;";
        Connection con=null;
        try {
            con=JDBCUtils.getConnection();
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, accountId);
            int i=st.executeUpdate();
            return i > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {JDBCUtils.close(con);}
    }





    @Override
    public boolean themAccount(Account account) {
        String sql="INSERT INTO account\n" +
                "    (email, username, fullname, department_id, position_id,gender)\n" +
                "VALUES\n" +
                "    (?,   ?,   ?,  ?, ?,?)";
        Connection con=null;
        try {
            con= JDBCUtils.getConnection();
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1, account.getEmail());
            st.setString(2, account.getUserName());
            st.setString(3, account.getFullName());
            st.setInt(4, account.getDepartment().getDepartmentId());
            st.setInt(5, account.getPostion().getPostionId());
            st.setString(6, account.getGender());
            int i=st.executeUpdate();
            return i > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {JDBCUtils.close(con);}
    }

    @Override
    public boolean checkTonTaiEmail(String email) {
        Connection con=null;
        String sql="SELECT 1 FROM dtn2603_testing_system.account WHERE email=?;";
        try {
            con= JDBCUtils.getConnection();
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1, email);
            ResultSet rs=st.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {JDBCUtils.close(con);}
    }

    @Override
    public boolean checkTonTaiUserNameThem(String userName) {
        Connection con=null;
        String sql="SELECT 1 FROM dtn2603_testing_system.account WHERE username=?;";
        try {
            con= JDBCUtils.getConnection();
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1, userName);
            ResultSet rs=st.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {JDBCUtils.close(con);}
    }

    @Override
    public boolean checkTonTaiUserNameSua(Integer accountId, String userName) {
        Connection con=null;
        String sql="SELECT 1 FROM dtn2603_testing_system.account WHERE username=? && account_id!=?;";
        try {
            con= JDBCUtils.getConnection();
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1, userName);
            st.setInt(2, accountId);
            ResultSet rs=st.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {JDBCUtils.close(con);}
    }

    @Override
    public boolean themListAccount(List<Account> accounts) {
        String sql="INSERT INTO account\n" +
                "    (email, username, fullname, department_id, position_id,gender)\n" +
                "VALUES\n" ;
        for(Account account:accounts){
            sql += "('" + account.getEmail() + "'," +
                    "'" + account.getUserName() + "'," +
                    "'" + account.getFullName() + "'," +
                    account.getDepartment().getDepartmentId() + "," +
                    account.getPostion().getPostionId() + "," +
                    "'" + account.getGender() + "'),";
        }

        sql = sql.substring(0, sql.length() - 1);
        Connection con=null;
        try {
            con= JDBCUtils.getConnection();
            Statement st=con.createStatement();
                        int i=st.executeUpdate(sql);
            return i > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {JDBCUtils.close(con);}
    }


}
