package backend.service;

import entity.Department;

import java.util.List;

public interface IDepartmentService {
    boolean kiemTraTonTaiDepartmentId(Integer departmentId);
    Department getDepartmentById(int departmentId);

    List<Department> getDepartments();
}
