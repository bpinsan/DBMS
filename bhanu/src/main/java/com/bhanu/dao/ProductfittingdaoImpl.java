package com.bhanu.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bhanu.model.Productfitting;

public class ProductfittingdaoImpl implements Productfittingdao{
	@Autowired
	DataSource datasource;
	
	@Autowired
	JdbcTemplate jdbctemplate;
	
	public ProductfittingdaoImpl(DataSource datasource)
	{
		this.jdbctemplate=new JdbcTemplate(datasource);
	}
	
	public void Insert(Productfitting productfitting) {
		// TODO Auto-generated method stub
		String sql="insert into Productfitting values(?,?,?,?,?,?)";
		Object[] object= {productfitting.getCustomer(),productfitting.getProduct_id(),productfitting.getQuantity(),productfitting.getDeadline(),productfitting.getStatus(),productfitting.getDetails()};
		jdbctemplate.update(sql,object);
	}

	public void delete(String Customer, int Product_id) {
		// TODO Auto-generated method stub
		String sql="delete from Productfitting where Customer='"+Customer+"' and Product_id='"+Product_id+"'";
		jdbctemplate.update(sql);
	}
}
