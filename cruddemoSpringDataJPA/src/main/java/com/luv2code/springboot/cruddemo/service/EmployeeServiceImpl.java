package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;        //Repository

    @Autowired                          //Bean ID (First letter lowercased) for the JPA version, before it didn't know which one to use, the hibernate or JPA one.
    public EmployeeServiceImpl(@Qualifier("employeeRepository") EmployeeRepository theemployeeRepository){
        employeeRepository = theemployeeRepository;
    }

    @Override
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId){
        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee = null;

        if(result.isPresent()){
            theEmployee = result.get();
        }else{
            //Employee NOT found
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee){
        employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId){
        employeeRepository.deleteById(theId);
    }
}
