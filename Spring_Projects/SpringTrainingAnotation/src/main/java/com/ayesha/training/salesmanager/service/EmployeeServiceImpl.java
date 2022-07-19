package com.ayesha.training.salesmanager.service;

import com.ayesha.training.salesmanager.model.Employee;
import com.ayesha.training.salesmanager.repository.EmployeeRepository;
import com.ayesha.training.salesmanager.repository.HibernateEmployeeRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

//    EmployeeRepository employeeRepository = new HibernateEmployeeRepositoryImpl();
    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeServiceImpl() {
    }

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    //    create setter for above reference
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
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
