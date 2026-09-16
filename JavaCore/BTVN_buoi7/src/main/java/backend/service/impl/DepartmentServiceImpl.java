package backend.service.impl;

import backend.repository.IDepartmentRepository;
import backend.repository.impl.DepartmentRepositoryImpl;
import backend.service.IDepartmentService;
import entity.Department;

import java.util.List;

public class DepartmentServiceImpl implements IDepartmentService {
    IDepartmentRepository departmentRepository;
    public DepartmentServiceImpl() {
        departmentRepository = new DepartmentRepositoryImpl();
    }
    @Override
    public boolean kiemTraTonTaiDepartmentId(Integer departmentId) {
        return departmentRepository.kiemTraTonTaiDepartmentId(departmentId);
    }

    @Override
    public Department getDepartmentById(int departmentId) {
        return departmentRepository.getDepartmentById(departmentId);
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.getDepartments();
    }
}
