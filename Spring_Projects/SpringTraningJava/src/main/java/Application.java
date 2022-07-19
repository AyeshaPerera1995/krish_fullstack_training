import com.ayesha.training.salesmanager.config.ApplicationConfiguration;
import com.ayesha.training.salesmanager.model.Employee;
import com.ayesha.training.salesmanager.service.EmployeeService;
import com.ayesha.training.salesmanager.service.EmployeeServiceImpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Application {

    public static void main(String[] args) {

//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        EmployeeService employeeService = applicationContext.getBean("employeeService", EmployeeService.class);
        System.out.println(employeeService.toString());

        EmployeeService employeeService2 = applicationContext.getBean("employeeService", EmployeeService.class);
        System.out.println(employeeService2.toString());

        List<Employee> employees = employeeService.getAllEmployees();

        for(Employee employee: employees){
            System.out.println(employee.getEmployeeName()+" at "+employee.getEmployeeLocation());
        }

    }
}
