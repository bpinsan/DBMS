package com.bhanu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bhanu.model.Feedback;

public class FeedbackdaoImpl implements Feedbackdao{
	
	@Autowired
	DataSource datasource;
	@Autowired
	JdbcTemplate jdbcTemplate;
	public FeedbackdaoImpl(DataSource dataSource)
	{
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}

	public void addFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		String sql="insert into Feedback set Product=?,Customer=?,Details=?";
		Object[] object= {feedback.getProduct(),feedback.getCustomer(),feedback.getDetails()};
		jdbcTemplate.update(sql,object);
		
	}

	public Feedback getFeedback(int Product_id, int Feedback_id) {
		// TODO Auto-generated method stub
		String sql="select * from Feedback where Product="+Product_id+" and Feedback_id="+Feedback_id;
		return jdbcTemplate.query(sql,new ResultSetExtractor<Feedback>() {
		public Feedback extractData(ResultSet rs) throws SQLException
		{
			if(rs.next())
			{
				Feedback feedback=new Feedback();
				feedback.setDetails(rs.getString("Details"));
				feedback.setCustomer(rs.getString("Customer"));
				feedback.setProduct(rs.getInt("Product"));
//				feedback.setDate(rs.getDate("date"));
				return feedback;
			}
			
			return null;
		}
		});
	}

	public void deleteFeedback(int Product_id, int Feedback_id) {
		// TODO Auto-generated method stub
		String sql="delete from Feedback where Product=? and Feedback_id=?";
		Object[] object= {Product_id,Feedback_id};
		jdbcTemplate.update(sql,object);
		
	}

	public List<Feedback> getFeedbacks(int Product_id) {
		// TODO Auto-generated method stub
		String sql="select * from Feedback where Product="+Product_id;
		List<Feedback> list=jdbcTemplate.query(sql,new BeanPropertyRowMapper<Feedback>(Feedback.class));
		return list;
	}
		
	
}
