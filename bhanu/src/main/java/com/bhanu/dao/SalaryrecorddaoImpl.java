package com.bhanu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bhanu.model.Salaryrecord;

public class SalaryrecorddaoImpl implements Salaryrecorddao{
	
	@Autowired
	DataSource datasource;
	
	@Autowired
	JdbcTemplate jdbctemplate;
	
	public SalaryrecorddaoImpl(DataSource datasource)
	{
		this.jdbctemplate=new JdbcTemplate(datasource);
	}

	public void addRecord(Salaryrecord record) {
		// TODO Auto-generated method stub
		String sql="insert into Salaryrecord set Employee_id=?,Month=?,Year=?,Salary=?,Paid=?";
		Object[] object= {record.getEmployee_id(),record.getMonth(),record.getYear(),record.getSalary(),record.getPaid()};
		jdbctemplate.update(sql,object);
	}

	public List<Salaryrecord> getAllRecords() {
		// TODO Auto-generated method stub
		String sql="select * from Salaryrecord order by Year, Month desc";
		List<Salaryrecord> list=jdbctemplate.query(sql, new BeanPropertyRowMapper<Salaryrecord>(Salaryrecord.class));
		return list;
	}

	public List<Salaryrecord> getRecords(int Employee_id) {
		// TODO Auto-generated method stub
		String sql="select * from Salaryrecord where Employee_id="+Employee_id;
		return jdbctemplate.query(sql,new BeanPropertyRowMapper<Salaryrecord>(Salaryrecord.class));
	
	}

	public Boolean isPaid(int Employee_id, int Month, int Year) {
		// TODO Auto-generated method stub
		String sql="select * from Salaryrecord where Employee_id="+Employee_id+" and Month="+Month+" and Year="+Year;
		return jdbctemplate.query(sql, new ResultSetExtractor<Salaryrecord>() {
		public Salaryrecord extractData(ResultSet rs) throws SQLException
		{
			if(rs.next())
			{
				Salaryrecord record=new Salaryrecord();
				return record;
			}
			return null;
		}
		})!=null;
	}

	
}
