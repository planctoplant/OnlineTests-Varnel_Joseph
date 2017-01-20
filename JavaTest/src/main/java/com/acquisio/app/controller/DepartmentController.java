package com.acquisio.app.controller;

import com.acquisio.app.domain.Department;
import com.acquisio.app.repository.DepartmentRepository;
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
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @RequestMapping("/departments")
    public Map<Long, Department> listDepartments() throws SQLException {
        return departmentRepository.findAll().stream()
                .collect(Collectors.toMap(Department::getId, Function.identity()));
    }
    
    
    @RequestMapping(value="/departments/create", method = RequestMethod.POST)
    public Map<Long, Department> addDepartments(HttpServletRequest request, @RequestBody String body) throws SQLException {
        HashMap bodyRep = new HashMap();
        for (String paramAttr : body.split(";")) {
            bodyRep.put(paramAttr.split("=")[0], paramAttr.split("=")[1]);
        }
        
        String name = (String) bodyRep.get("name");
        if (name != null) {
            Department dept = new Department(name);
            departmentRepository.saveAndFlush(dept);
        }
        
        return departmentRepository.findAll().stream()
                .collect(Collectors.toMap(Department::getId, Function.identity()));
    }
}
