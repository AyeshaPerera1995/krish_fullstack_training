package com.ayesha.training.salesmanager.repository;

import com.ayesha.training.salesmanager.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class HibernateEmployeeRepositoryImpl implements EmployeeRepository {

    @Override
    public List<Employee> getAllEmployees(){
        List<Employee> employees = new ArrayList<>();

        Employee employee = new Employee();
        employee.setEmployeeName("Ayesha");
        employee.setEmployeeLocation("Negombo");
        employees.add(employee);

        return employees;

    }

}
