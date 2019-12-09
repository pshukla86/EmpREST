package com.emp.rest.controller;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.emp.rest.dao.EmployeeDAO;
import com.emp.rest.model.Employee;
import com.emp.rest.model.EmployeeData;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
	@Autowired
    private EmployeeDAO employeeDao;
     
    @GetMapping(path="", produces = "application/json")
    public EmployeeData getEmployees() 
    {
        return employeeDao.getAllEmployees();
    }
     
    @PostMapping(path= "/addEmployee", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) 
    {
       /*Integer id = employeeDao.getAllEmployees().getEmployeeList().size() + 1;
        employee.setId(id);*/
         
        employeeDao.addEmployee(employee);
         
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{firstName}")
                                    .buildAndExpand(employee.getFirstName())
                                    .toUri();
         
        return ResponseEntity.created(location).build();
    }

}
