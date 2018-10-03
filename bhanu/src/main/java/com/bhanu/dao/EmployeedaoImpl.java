package com.bhanu.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bhanu.model.Employee;



public class EmployeedaoImpl implements Employeedao{

	@Autowired
	DataSource datasource;
	@Autowired
	JdbcTemplate jdbctemplate;
	
	
	public void Save(Employee employee) {
		// TODO Auto-generated method stub
		String sql="Insert into Employee(Name,Salary,Area,Type,Details,Pincode,Joining_date,Email) Values(?,?,?,?,?,?,?,?)";
		jdbctemplate.update(sql,new Object[] {employee.getName(),employee.getSalary(),employee.getArea(),employee.getType(),employee.getDetails(),employee.getPincode(),employee.getJoining_date(),employee.getEmail()});
	}


	public Employee getEmployee() {
		// TODO Auto-generated method stub
		
		return null;
	}
	
	
}