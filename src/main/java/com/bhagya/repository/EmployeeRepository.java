package com.bhagya.repository;

import com.bhagya.model.Employee;
import com.bhagya.model.EmployeeId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface EmployeeRepository extends CrudRepository<Employee,EmployeeId>{

    Employee findByEmployeeId(EmployeeId employeeId);
}
