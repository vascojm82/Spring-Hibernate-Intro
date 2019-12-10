package com.luv2code.springboot.thymeleafdemo.dao;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//Free CRUD operations thanks to JPA.             <table, PK type>
public interface EmployeeDAO extends JpaRepository<Employee, Integer> {
                        //JPA parses the function name and creates the appropriate query for us, automagically.
    public List<Employee> findAllByOrderByLastNameAsc();
}