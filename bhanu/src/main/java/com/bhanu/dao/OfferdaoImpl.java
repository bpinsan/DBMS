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

import com.bhanu.model.Offer;
import com.bhanu.model.Product;

public class OfferdaoImpl implements Offerdao{

	@Autowired 
	DataSource datasource;
	@Autowired 
	JdbcTemplate jdbctemplate;
	public void SaveOrUpdate(Offer offer) {
		// TODO Auto-generated method stub
		String sql="insert into Offer(Name,Discount,Status) values(?,?,?)";
		jdbctemplate.update(sql,new Object[] {offer.getName(),offer.getDiscount(),offer.getStatus()});
		
	}
	public List<Offer> GetAllOffer() {
		// TODO Auto-generated method stub
		String sql="select * from Offer";
		List<Offer> offer=jdbctemplate.query(sql, new BeanPropertyRowMapper<Offer>(Offer.class));
		return offer;
	}
	public Offer GetOffer(final int offer_id) {
		// TODO Auto-generated method stub
		String sql="select * from Offer where Offer_id='"+offer_id+"'";
		return jdbctemplate.query(sql,new ResultSetExtractor<Offer>() {		
			public Offer extractData(ResultSet rs) throws SQLException,DataAccessException{
				if(rs.next()) {
					Offer offer = new Offer();
					offer.setOffer_id(offer_id);
					offer.setStatus(rs.getInt("Status"));
					offer.setDiscount(rs.getInt("Discount"));
					return offer;
						}
					return null;
				}		
				});
	}
	public void UpdateOffer(Offer offer) {
		// TODO Auto-generated method stub
		String sql="update Offer set Discount="+offer.getDiscount()+",Status="+offer.getStatus()+" where Offer_id="+offer.getOffer_id()+"";
		jdbctemplate.update(sql,new Object[] {});
	
		
	}

}
