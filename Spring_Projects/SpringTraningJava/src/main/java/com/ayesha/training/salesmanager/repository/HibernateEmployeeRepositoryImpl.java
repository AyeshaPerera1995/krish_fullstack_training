package com.ayesha.training.salesmanager.repository;

import com.ayesha.training.salesmanager.model.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository("employeeRepository")
public class HibernateEmployeeRepositoryImpl implements EmployeeRepository {

    @Value(value="${name}")
    private String employeeName;
    @Value(value="${city}")
    private String employeeCity;

    @Override
    public List<Employee> getAllEmployees(){
        List<Employee> employees = new ArrayList<>();

        Employee employee = new Employee();
//        employee.setEmployeeName("Ayesha");
//        employee.setEmployeeLocation("Negombo");
        employee.setEmployeeName(employeeName);
        employee.setEmployeeLocation(employeeCity);
        employees.add(employee);

        return employees;

    }

}
