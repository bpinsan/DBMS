package com.bhanu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bhanu.model.Employee;



public class EmployeedaoImpl implements Employeedao{

	@Autowired
	DataSource datasource;
	@Autowired
	JdbcTemplate jdbctemplate;
	
	
	public void Save(Employee employee) {
		// TODO Auto-generated method stub
		String sql="Insert into Employee(Name,Salary,Area,Type,Details,Pincode,Joining_date,Email,Contact) Values(?,?,?,?,?,?,?,?,?)";
		jdbctemplate.update(sql,new Object[] {employee.getName(),employee.getSalary(),employee.getArea(),employee.getType(),employee.getDetails(),employee.getPincode(),employee.getJoining_date(),employee.getEmail(),employee.getContact()});
	}



	public List<Employee> getAllEmployee() {
		String sql="select * from Employee";
		List<Employee> list;
		list=jdbctemplate.query(sql, new BeanPropertyRowMapper<Employee>(Employee.class));
		return list;
	}


	public Employee getEmployee(int employee_id) {
		// TODO Auto-generated method stub
		String sql="select * from Employee where employee_id="+employee_id;
		return jdbctemplate.query(sql, new ResultSetExtractor<Employee>(){
			public Employee extractData(ResultSet rs) throws SQLException
			{
				if(rs.next())
				{
					Employee employee=new Employee();
					employee.setEmployee_id(rs.getInt("employee_id"));
					employee.setContact(rs.getString("Contact"));
					employee.setName(rs.getString("Name"));
					employee.setSalary(rs.getInt("Salary"));
					employee.setArea(rs.getString("Area"));
					employee.setJoining_date(rs.getString("Joining_date"));
					employee.setType(rs.getString("Type"));
					return employee;
				}
				return null;
			}	
		});
	}
	
	
}
