package com.emp.rest.model;
 
public class Employee {

    public Employee() {

    }

    public Employee(String firstName, String lastName, String gender, String department, String dateOfBirth) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.department = department;
        this.dateOfBirth = dateOfBirth;
    }
 
    private String firstName;
    private String lastName;
    private String gender;
   	private String department;
    private String dateOfBirth;

    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    

    public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

    
    public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
    public String toString() {
        return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", department=" + department + ", gender" + gender + "]";
    }
}