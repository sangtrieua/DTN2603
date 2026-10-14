package org.example.btvnbuoi2.repository;

import org.example.btvnbuoi2.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmentRepository extends JpaRepository<Department,Integer> {
    boolean existsDepartmentByDepartmentName(String departmentName);

    Department findDepartmentByDepartmentName(String departmentName);
}
