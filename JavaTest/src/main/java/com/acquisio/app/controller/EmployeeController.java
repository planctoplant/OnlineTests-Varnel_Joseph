package com.acquisio.app.controller;

import com.acquisio.app.domain.Department;
import com.acquisio.app.domain.Employee;
import com.acquisio.app.repository.DepartmentRepository;
import com.acquisio.app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private DepartmentRepository departmentRepository;

    @RequestMapping("/employees")
    public Map<Long, Employee> listEmployees() throws SQLException {
        return employeeRepository.findAll().stream()
                .collect(Collectors.toMap(Employee::getId, Function.identity()));
    }
    
    
    @RequestMapping(value="/employees/update", method = RequestMethod.PUT)
    public Map<Long, Employee> updateEmployee(HttpServletRequest request, @RequestBody String body) throws SQLException {
        //HashMap<String>, <Object> bodyRep = new HashMap(<String>, <Object>);
        Map<String, Object> bodyRep = new HashMap();
        for (String paramAttr : body.split("&")) {
            bodyRep.put(paramAttr.split("=")[0], paramAttr.split("=")[1]);
        }
        
        Long employeeId = Long.parseLong((String) bodyRep.get("id"));
        
        int employeeSalary  = Integer.parseInt((String) bodyRep.get("salary"));
        Long employeeDeptId = Long.parseLong((String) bodyRep.get("departmentId"));
        
        Employee employee = employeeRepository.findOne(employeeId);
        Department newDepartment = departmentRepository.findOne(employeeDeptId);
        if (employee != null) {    
            if (employeeSalary > 10000 && employeeSalary < 50000){
                employee.setSalary(employeeSalary);
            }
            if (newDepartment != null) {
                employee.setDepartment(newDepartment);
            }
            
            employeeRepository.saveAndFlush(employee);
        }
        
        return employeeRepository.findAll().stream()
                .collect(Collectors.toMap(Employee::getId, Function.identity()));
    }
}
