package com.acquisio.app;

import com.acquisio.app.domain.Department;
import com.acquisio.app.domain.Employee;
import com.acquisio.app.repository.DepartmentRepository;
import com.acquisio.app.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

/**
 * Main Spring-Boot app.
 */
@SpringBootApplication
public class FullStackApp {

    public static void main(String[] args) {
        SpringApplication.run(FullStackApp.class, args);
    }

    @Bean
    CommandLineRunner initializeDatabase(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        return (evt) -> {
            Department d1 = new Department("Reporting");
            Department d2 = new Department("Engineering");
            Department d3 = new Department("Marketing");
            departmentRepository.save(d1);
            departmentRepository.save(d2);
            departmentRepository.save(d3);
            employeeRepository.save(Arrays.asList(
                    new Employee("John", "Smith", 20000, d1),
                    new Employee("Ava", "Muffinson", 10000, d3),
                    new Employee("Cailin", "Ninson", 30000, d3),
                    new Employee("Mike", "Peterson", 20000, d1),
                    new Employee("Ian", "Peterson", 80000, d2),
                    new Employee("John", "Mills", 50000, d3)
            ));
        };
    }
}
