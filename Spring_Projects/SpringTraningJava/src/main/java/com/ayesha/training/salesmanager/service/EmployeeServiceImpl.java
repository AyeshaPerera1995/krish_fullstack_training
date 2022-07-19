package com.ayesha.training.salesmanager.service;

import com.ayesha.training.salesmanager.model.Employee;
import com.ayesha.training.salesmanager.repository.EmployeeRepository;
import com.ayesha.training.salesmanager.repository.HibernateEmployeeRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

//    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl() {
        System.out.println("default constructor executed!");
    }

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        System.out.println("overload constructor executed!");
        this.employeeRepository = employeeRepository;
    }

    //    create setter for above reference
//    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        System.out.println("setter executed!");
        this.employeeRepository = employeeRepository;
    }

    //    create getter for above reference
    public EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }
}
