package com.bhanu.model;

import javax.validation.constraints.NotEmpty;

public class Employee {
	@NotEmpty(message="Required")
	int Employee_id;
	private String Name;
	int Salary;
	String Area;
	String Type;
	String Details;
	int pincode;
	String Joining_date;
	String Worked_till;
	String Email;
	
	public Employee()
	{
		
	}
	
	public int getEmployee_id() {
		return Employee_id;
	}

	public void setEmployee_id(int employee_id) {
		Employee_id = employee_id;
	}

	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getSalary() {
		return Salary;
	}
	public void setSalary(int salary) {
		Salary = salary;
	}
	public String getArea() {
		return Area;
	}
	public void setArea(String area) {
		Area = area;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getDetails() {
		return Details;
	}
	public void setDetails(String details) {
		Details = details;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	public String getJoining_date() {
		return Joining_date;
	}
	public void setJoining_date(String joining_date) {
		Joining_date = joining_date;
	}
	public String getWorked_till() {
		return Worked_till;
	}
	public void setWorked_till(String worked_till) {
		Worked_till = worked_till;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
}
