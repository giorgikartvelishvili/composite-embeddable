package com.bhagya.repository;

import com.bhagya.model.Department;
import com.bhagya.model.DepartmentId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface DepartmentRepository extends CrudRepository<Department, DepartmentId> {

    Department findByDepartmentId(DepartmentId departmentId);
}
