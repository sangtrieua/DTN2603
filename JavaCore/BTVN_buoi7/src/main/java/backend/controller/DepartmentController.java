package backend.controller;

import backend.service.IDepartmentService;
import backend.service.impl.DepartmentServiceImpl;
import entity.Department;

import java.util.List;

public class DepartmentController {
    IDepartmentService departmentService = new DepartmentServiceImpl();
    public DepartmentController() {
        this.departmentService =  new DepartmentServiceImpl();
    }
    public boolean kiemTraTonTaiDepartmentId(Integer departmentId) {
        return departmentService.kiemTraTonTaiDepartmentId(departmentId);
    }
    public Department getDepartmentById(int departmentId) {
        return departmentService.getDepartmentById(departmentId);
    }

    public List<Department> getDepartments() {
        return departmentService.getDepartments();
    }
}
