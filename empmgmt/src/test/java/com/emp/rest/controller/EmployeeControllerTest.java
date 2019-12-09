package com.emp.rest.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.emp.rest.dao.EmployeeDAO;
import com.emp.rest.model.Employee;
import com.emp.rest.model.EmployeeData;

public class EmployeeControllerTest {
	
	@InjectMocks
    private EmployeeController ec;
    
	@Mock
	private EmployeeDAO employeeDao;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

	@Test
	public void testGetEmployees() {
		// given
		List<Employee> eList = new ArrayList<Employee>();
		eList.add(new Employee("Suresh", "Patel", "Male", "IT", "28-02-1983"));
		eList.add(new Employee("Neha", "Sharma", "Female", "Finance", "16-03-1987"));
        
        EmployeeData eData = new EmployeeData();
        eData.setEmployeeList(eList);
        
 
        when(employeeDao.getAllEmployees()).thenReturn(eData);
 
        // when
        EmployeeData result = ec.getEmployees();
 
        // then
        assertThat(result.getEmployeeList().size()).isEqualTo(2);
         
        assertThat(result.getEmployeeList().get(0).getFirstName())
                        .isEqualTo(eList.get(0).getFirstName());
         
        assertThat(result.getEmployeeList().get(1).getFirstName())
                        .isEqualTo(eList.get(1).getFirstName());
	}

	@Test
	public void testAddEmployee() {
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        //when(employeeDao.addEmployee(any(Employee.class))).thenReturn(true);
        
		Employee newEmp = new Employee("Deepak", "Yadav", "Male", "Networks", "20-06-1982");
		ResponseEntity<Object> responseEntity = ec.addEmployee(newEmp);
		
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
		assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/Deepak");
        
		
	}

}
