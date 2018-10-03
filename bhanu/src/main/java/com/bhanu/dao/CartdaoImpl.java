package com.bhanu.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bhanu.model.Cart;

public class CartdaoImpl implements Cartdao {

	@Autowired
	DataSource datasource;
	@Autowired
	JdbcTemplate jdbctemplate;
	
    public CartdaoImpl(DataSource datasource) {
		// TODO Auto-generated constructor stub
    	this.jdbctemplate = new JdbcTemplate(datasource);
	}
	public void SaveOrUpdate(Cart cart) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO Cart(Product_id,Customer) values(?,?)";
		jdbctemplate.update(sql,new Object[] {cart.getProduct_id(),cart.getCustomer()});
	}
}
