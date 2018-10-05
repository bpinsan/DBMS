package com.bhanu.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bhanu.model.Mayreturn;

public class MayreturndaoImpl implements Mayreturndao{

	@Autowired
	DataSource datasource;
	
	@Autowired
	JdbcTemplate jdbctemplate;
	
	public MayreturndaoImpl(DataSource datasource)
	{
		this.jdbctemplate=new JdbcTemplate(datasource);
	}
	
	public void insert(Mayreturn mayreturn) {
		// TODO Auto-generated method stub
		String sql="insert into Mayreturn values(?,?,?,?,?)";
		Object[] object= {mayreturn.getCustomer(),mayreturn.getProduct_id(),mayreturn.getQuantity(),mayreturn.getPrice(),mayreturn.getDeadline()};
		jdbctemplate.update(sql,object);
	}

	public void delete(String Customer, int Product_id) {
		// TODO Auto-generated method stub
		String sql="delete from Mayreturn where Customer='"+Customer+"' and Product_id='"+Product_id+"'";
		jdbctemplate.update(sql);
	}

}
