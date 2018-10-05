package com.bhanu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bhanu.model.Customer;

public class CustomerdaoImpl implements Customerdao{

	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbctemplate;
	
	public CustomerdaoImpl(DataSource datasource)
	{
		this.jdbctemplate=new JdbcTemplate(datasource);
	}
	
	public void SaveOrUpdateUSERS(Customer customer) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO USERS(Username,Password) values(?,?)";
		jdbctemplate.update(sql,new Object[] {customer.getUsername(),customer.getmPassword()});
		sql = "INSERT INTO USERS_ROLES(user,role) VALUES(?,?)";
		jdbctemplate.update(sql,new Object[] {customer.getUsername(),"ROLE_USER"});
	}

	public void SaveOrUpdateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO Customer(Username,Name,Email,Gender,Details,Pincode,Contact) values(?,?,?,?,?,?,?)";
		jdbctemplate.update(sql,new Object[] {customer.getUsername(),customer.getName(),customer.getEmail(),customer.getGender(),customer.getDetails(),customer.getPincode(),customer.getContact()});
	}

	public Customer getUser(String username) {
		// TODO Auto-generated method stub
		String sql = "select * from USERS where Username='"+username+"'";
		return jdbctemplate.query(sql,new ResultSetExtractor<Customer>() {
			
			public Customer extractData(ResultSet rs) throws SQLException,DataAccessException{
				if(rs.next()) {
					Customer customer = new Customer();
					customer.setUsername(rs.getString("Username"));
					customer.setPassword(rs.getString("Password"));
					return customer;
				}
				return null;
			}
			
		});
	}

	public Customer getCustomer(String username) {
		// TODO Auto-generated method stub
		String sql = "select * from Customer where Username='"+username+"'";
		return jdbctemplate.query(sql,new ResultSetExtractor<Customer>() {
			
			public Customer extractData(ResultSet rs) throws SQLException,DataAccessException{
				if(rs.next()) {
					Customer customer = new Customer();
					customer.setUsername(rs.getString("Username"));
					customer.setName(rs.getString("Name"));
					customer.setEmail(rs.getString("Email"));
					customer.setDetails(rs.getString("Details"));
					customer.setPincode(rs.getInt("Pincode"));
					customer.setContact(rs.getString("Contact"));				
					return customer;
				}
				return null;
			}
			
		});
	}

	public void editProfile(Customer customer, String Username) {
		// TODO Auto-generated method stub
		String sql="update Customer set Name=?,Details=?,contact=?,Pincode=? where Username=?";
		Object[] object= {customer.getName(),customer.getDetails(),customer.getContact(),customer.getPincode(),Username};
		jdbctemplate.update(sql,object);
		
	}

	public List<Customer> Search(String Phoneno) {
		// TODO Auto-generated method stub
		String sql="select * from Customer where Contact="+Phoneno;
		List<Customer> list;
		list=jdbctemplate.query(sql, new BeanPropertyRowMapper<Customer>(Customer.class));
		return list;
	}

}
