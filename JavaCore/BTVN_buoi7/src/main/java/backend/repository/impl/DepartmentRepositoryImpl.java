package backend.repository.impl;

import backend.repository.IDepartmentRepository;
import entity.Department;
import ultils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepositoryImpl implements IDepartmentRepository {
    @Override
    public boolean kiemTraTonTaiDepartmentId(Integer departmentId) {
        Connection con=null;
        String sql="SELECT 1 FROM dtn2603_testing_system.department WHERE department_id=?;";
        try {
            con= JDBCUtils.getConnection();
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, departmentId);
            ResultSet rs=st.executeQuery();
            if (rs.next()) {
                return true;
            }
            else {

                return  false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {JDBCUtils.close(con);}
    }

    @Override
    public Department getDepartmentById(int departmentId) {
        Department department = new Department();
        Connection con=null;
        try {
            con= JDBCUtils.getConnection();
            String sql="SELECT * FROM dtn2603_testing_system.department where department_id=?;";
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1,departmentId);
            ResultSet rs=st.executeQuery();
            while (rs.next()) {
                department.setDepartmentId(rs.getInt("department_id"));
                department.setDepartmentName(rs.getString("department_name"));
                department.setQuantityAccount(rs.getInt("quantity_account"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {JDBCUtils.close(con);}
        return  department;
    }

    @Override
    public List<Department> getDepartments() {
        List<Department> departments = new ArrayList<>();
        Connection con=null;
        try {
            con= JDBCUtils.getConnection();
            String sql="SELECT * FROM dtn2603_testing_system.department;";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while (rs.next()) {
                Department department = new Department();
                department.setDepartmentId(rs.getInt("department_id"));
                department.setDepartmentName(rs.getString("department_name"));
                department.setQuantityAccount(rs.getInt("quantity_account"));
                departments.add(department);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {JDBCUtils.close(con);}

        return departments;
    }
}
