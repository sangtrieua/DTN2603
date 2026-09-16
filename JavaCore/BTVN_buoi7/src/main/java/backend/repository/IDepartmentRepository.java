package backend.repository;

import entity.Department;

import java.util.List;

public interface IDepartmentRepository {
    boolean kiemTraTonTaiDepartmentId(Integer departmentId);

    Department getDepartmentById(int departmentId);

    List<Department> getDepartments();
}
