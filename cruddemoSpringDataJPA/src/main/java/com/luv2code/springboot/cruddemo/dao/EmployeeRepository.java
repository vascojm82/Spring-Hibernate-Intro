package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

                                                         //Entity   //Primary-Key (Id of type Int in this case)
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
