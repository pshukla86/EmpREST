package com.emp.rest.dao;
import org.springframework.stereotype.Repository;

import com.emp.rest.model.Employee;
import com.emp.rest.model.EmployeeData;
 
@Repository
public class EmployeeDAO 
{
    private static EmployeeData empList = new EmployeeData();
     
    static
    {
    	empList.getEmployeeList().add(new Employee("Praveen", "Shukla", "Male", "Accounts", "23/04/1986"));
    	empList.getEmployeeList().add(new Employee("Ram", "Kumar", "Male", "Finance", "13/05/1984"));
    	empList.getEmployeeList().add(new Employee("Ankita", "Dixit", "Female", "HR", "04/08/1990"));
    }
     
    public EmployeeData getAllEmployees() 
    {
        return empList;
    }
     
    public void addEmployee(Employee employee) {
    	empList.getEmployeeList().add(employee);
    }
}