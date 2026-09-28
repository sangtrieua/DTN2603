package backend.service.impl;

import backend.repository.IDepartmentRepository;
import backend.repository.impl.DepartmentRepositoryImpl;
import backend.service.IDepartmentService;
import backend.service.ImportFileCSV;
import context.DepartmentContext;
import entity.Department;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DepartmentServiceImpl implements IDepartmentService, ImportFileCSV<Department, DepartmentContext> {
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

    @Override
    public String importDepartmentCSV(String url) {
        List<Department> departments = departmentRepository.getDepartments();
        Set<String> setDepartmentId = departments.stream().map(Department::getDepartmentName).collect(Collectors.toSet());
        DepartmentContext  departmentContext = new DepartmentContext(setDepartmentId);
        String pathErrorsFile="D:\\FITHOU_23\\VTI Academy\\java_core\\csv\\input_department_error.csv";
        return this.importCSV(url,departmentContext,pathErrorsFile);

    }

    @Override
    public void validation(String line, List<Department> entities, List<String> listErrors, DepartmentContext context) {
        String[] values=line.split(",");
        List<String> errors=new ArrayList<>();
        String departmentName=values[0];
        if(departmentName.length()<6 || departmentName.length()>100) {
            errors.add("DepartmentName có độ dài từ 6 đến 100 kí tự");
        }
        else {
            if(context.getSetDepartmentName().contains(departmentName))  {
                errors.add("departmentName đã tồn tại");
            }
        }
        if(errors.isEmpty()) {
            context.getSetDepartmentName().add(departmentName);
            entities.add(new Department(departmentName));
        }
        else  {
            String error = String.join(",",errors);
            line=line+", "+error;
            listErrors.add(line);
        }
    }

    @Override
    public void saveAll(List<Department> entities) {
    departmentRepository.themListDepartment(entities);
    }

    @Override
    public void exportErrors(String header, List<String> listErrors, String pathErrorFile) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(pathErrorFile));
            bw.write(header + "error_message");
            bw.newLine();
            for (String error : listErrors) {
                bw.write(error);
                bw.newLine();
            }
            bw.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
