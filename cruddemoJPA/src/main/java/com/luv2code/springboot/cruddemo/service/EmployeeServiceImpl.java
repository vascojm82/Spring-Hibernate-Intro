package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAO;        //Repository

    @Autowired                          //Bean ID (First letter lowercased) for the JPA version, before it didn't know which one to use, the hibernate or JPA one.
    public EmployeeServiceImpl(@Qualifier("employeeDAOJpaImpl") EmployeeDAO theEmployeeDAO){
        employeeDAO = theEmployeeDAO;
    }

    @Override
    @Transactional
    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }

    @Override
    @Transactional
    public Employee findById(int theId){
        return employeeDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(Employee theEmployee){
        employeeDAO.save(theEmployee);
    }

    @Override
    @Transactional
    public void deleteById(int theId){
        employeeDAO.deleteById(theId);
    }
}
