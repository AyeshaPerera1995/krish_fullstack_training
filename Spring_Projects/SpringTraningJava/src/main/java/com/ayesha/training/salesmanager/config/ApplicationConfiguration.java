package com.ayesha.training.salesmanager.config;

import com.ayesha.training.salesmanager.repository.EmployeeRepository;
import com.ayesha.training.salesmanager.repository.HibernateEmployeeRepositoryImpl;
import com.ayesha.training.salesmanager.service.EmployeeService;
import com.ayesha.training.salesmanager.service.EmployeeServiceImpl;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.ayesha")
@PropertySource("application.properties")
public class ApplicationConfiguration {

    @Bean(name = "employeeService")
//    @Scope("singleton")
//    @Scope("prototype")
    EmployeeService getEmployeeService(){
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        employeeService.setEmployeeRepository(getEmployeeRepository());
        return employeeService;
    }

    @Bean(name = "employeeRepository")
    EmployeeRepository getEmployeeRepository(){
        return new HibernateEmployeeRepositoryImpl();
    }



}
