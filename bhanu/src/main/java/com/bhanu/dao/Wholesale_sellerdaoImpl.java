package com.bhanu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bhanu.model.Order;
import com.bhanu.model.Wholesale_seller;

public class Wholesale_sellerdaoImpl implements Wholesale_sellerdao{
	
	@Autowired
	DataSource datsource;
	
	@Autowired
	JdbcTemplate jdbctemplate;
	
	public Wholesale_sellerdaoImpl(DataSource datasource)
	{
		this.jdbctemplate=new JdbcTemplate(datasource);
	}

	public void Addorupdate(Wholesale_seller ws) {
		// TODO Auto-generated method stub
		String sql="insert into Wholesale_seller values(?,?,?,?,?)";
		Object[] object= {ws.getSeller_id(),ws.getName(),ws.getEmail(),ws.getContact(),ws.getAddress()};
		jdbctemplate.update(sql,object);
		
	}

	public List<Wholesale_seller> Allseller() {
		// TODO Auto-generated method stub
		String sql="select * from Wholesale_seller";
		List<Wholesale_seller> list;
		list=jdbctemplate.query(sql,new BeanPropertyRowMapper<Wholesale_seller>(Wholesale_seller.class));
		return list;
	}

	public Wholesale_seller Getseller(int seller_id) {
		// TODO Auto-generated method stub
		String sql="select * from Wholesale_seller where Seller_id="+seller_id;
		return jdbctemplate.query(sql, new ResultSetExtractor<Wholesale_seller>() {
			public Wholesale_seller extractData(ResultSet rs) throws SQLException
			{
				if(rs.next())
				{
					Wholesale_seller seller = new Wholesale_seller();
					seller.setAddress(rs.getString("Address"));
					seller.setSeller_id(rs.getInt("Seller_id"));
					seller.setName(rs.getString("Name"));
					seller.setEmail(rs.getString("Email"));
					seller.setContact(rs.getString("Contact"));
					return seller;
				}
				return null;
			}
		});
	}

	public void Update(Wholesale_seller seller) {
		// TODO Auto-generated method stub
		String sql="update Wholesale_seller set Name=?,Address=?,Contact=?,Email=? where Seller_id="+seller.getSeller_id();
		Object[] object= {seller.getName(),seller.getAddress(),seller.getContact(),seller.getEmail()};
		jdbctemplate.update(sql,object);
		
	}

}
