package com.ayesha.training.salesmanager.repository;

import com.ayesha.training.salesmanager.model.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> getAllEmployees();
}
