package com.bhanu.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bhanu.model.Contact;

public class ContactdaoImpl implements Contactdao{

	@Autowired
	DataSource datasource;
	
	@Autowired
	JdbcTemplate jdbctemplate;
	
	public ContactdaoImpl(DataSource datasource)
	{
		this.jdbctemplate=new JdbcTemplate(datasource);
	}
	
	public void Addcontact(Contact contact) {
		// TODO Auto-generated method stub
		String sql="insert into Contact(customer,contact) values(?,?)";
		Object[] object = {contact.getCustomer(),contact.getContact()};
		jdbctemplate.update(sql,object);
	}

	public void deletecontact(int contact_id) {
		// TODO Auto-generated method stub
		String sql="delete from Contact where Contact_id="+contact_id;
		jdbctemplate.update(sql);
		
	}

	public void updatecontact(int contact_id) {
		// TODO Auto-generated method stub
		
	}

	public List<Contact> Allcontact(String username) {
		// TODO Auto-generated method stub
		String sql="select * from Contact where Customer='"+username+"'";
		List<Contact> list=jdbctemplate.query(sql, new BeanPropertyRowMapper<Contact>(Contact.class));
		return list;
	}

}
