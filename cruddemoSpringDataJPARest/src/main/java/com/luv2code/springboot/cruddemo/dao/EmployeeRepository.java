package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//Instead of the path being "employees" which is the default, it will be "members"
@RepositoryRestResource(path="members")                   //Entity   //Primary-Key (Id of type Int in this case)
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
