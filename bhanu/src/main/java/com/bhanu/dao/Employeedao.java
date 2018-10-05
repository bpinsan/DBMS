package com.bhanu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bhanu.model.Employee;

public interface Employeedao {
	@Autowired
	public void Save(Employee employee);
	public List<Employee> getAllEmployee();
	public Employee getEmployee(int employee_id);
}
