package com.bhanu.model;


public class Salaryrecord {
	int Employee_id;
	int Month;
	int Year;
	int Salary;
	int Paid;
	
	public Salaryrecord()
	{
		
	}

	public int getEmployee_id() {
		return Employee_id;
	}

	public void setEmployee_id(int employee_id) {
		Employee_id = employee_id;
	}

	public int getMonth() {
		return Month;
	}

	public void setMonth(int month) {
		Month = month;
	}

	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		Year = year;
	}

	public int getSalary() {
		return Salary;
	}

	public void setSalary(int salary) {
		Salary = salary;
	}

	public int getPaid() {
		return Paid;
	}

	public void setPaid(int paid) {
		Paid = paid;
	}
	
}
