package com.bhagya;

import com.bhagya.model.Department;
import com.bhagya.model.DepartmentId;
import com.bhagya.model.Employee;
import com.bhagya.model.EmployeeId;
import com.bhagya.repository.DepartmentRepository;
import com.bhagya.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiceMain implements CommandLineRunner {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(ServiceMain.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        DepartmentId departmentId = new DepartmentId();
        departmentId.setLocation("loc2");
        departmentId.setName("name2");

        Department department = new Department();
        department.setDepartmentId(departmentId);
        department.setEmpNumber(1);

        Employee employee = new Employee();
        employee.setDesignation("ddd");
        employee.setSalary(2.0);

        EmployeeId employeeId = new EmployeeId();
        employeeId.setDepartmentId(departmentId);
        employeeId.setName("spieler2");

        employee.setEmployeeId(employeeId);
        //department.getEmployees().add(employee);
        departmentRepository.save(department);
        employeeRepository.save(employee);
        Department department1 = departmentRepository.findByDepartmentId(departmentId);
        System.out.println(department1.getDepartmentId());
        System.out.println("size: " + department1.getEmployees().size());
        department1.getEmployees().forEach(a -> System.out.println("-: " + a.getEmployeeId().getName()));
        employeeRepository.findAll().forEach(a -> System.out.println("------------: " + a.getEmployeeId().getName()));
    }
}
