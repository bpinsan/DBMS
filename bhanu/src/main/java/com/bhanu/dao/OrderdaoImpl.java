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
import com.bhanu.model.OrderItem;

public class OrderdaoImpl implements Orderdao{
	@Autowired
	DataSource datasource;
	@Autowired
	JdbcTemplate jdbctemplate;
	
	public OrderdaoImpl(DataSource datasource)
	{
		this.jdbctemplate=new JdbcTemplate(datasource);
	}
	
	public int placeOrder(String Username, int Total_price, int Grand_total, int Offer_id) {
		// TODO Auto-generated method stub
		String sql1="insert into Orders set Customer=?,Total_price=?,Grand_total=?,Offer=?";
		Object[] object= {Username,Total_price,Grand_total,Offer_id};
		jdbctemplate.update(sql1,object);
		String sql="select max(Order_id) from Orders where Customer='"+Username+"'";
		Order maxOrder=jdbctemplate.query(sql, new ResultSetExtractor<Order>() {
			public Order extractData(ResultSet rs) throws SQLException
			{
				if(rs.next())
				{
					Order order=new Order();
					order.setOrder_id(rs.getInt("max(Order_id)"));
					return order;
				}
				return null;
			}
		}
		);
		int x=maxOrder.getOrder_id();
		return x;
	}

	public List<Order> getOrders(String Username) {
		// TODO Auto-generated method stub
		String sql="select * from Orders where Customer =\""+Username+"\"";
		List<Order> list=jdbctemplate.query(sql, new BeanPropertyRowMapper<Order>(Order.class));
		return list;
	}

	public List<OrderItem> getOrderItems(int Order_Id) {
		// TODO Auto-generated method stub
		String sql="select * from Contains where Order_id=\""+Order_Id+"\"";
		return jdbctemplate.query(sql, new BeanPropertyRowMapper<OrderItem>(OrderItem.class));
	}

	public void addToOrder(int Order_Id, int Product_id, int Quantity) {
		// TODO Auto-generated method stub
		String sql="insert into Contains set Order_id=?,Product_id=?,Quantity=?"; 
		Object[] object= {Order_Id,Product_id,Quantity};
		jdbctemplate.update(sql,object);
		
	}

	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		String sql="select * from Orders";
		List<Order> list=jdbctemplate.query(sql, new BeanPropertyRowMapper<Order>(Order.class));
		return list;
	}

	public void assignEmployee(int Order_Id, int Employee_id) {
		// TODO Auto-generated method stub
		String sql="update Orders set Employee="+Employee_id+" where Order_id="+Order_Id;
		jdbctemplate.update(sql);
		
	}

	public Order getOrder(int Order_Id) {
		// TODO Auto-generated method stub
		String sql="select * from Orders where Order_id="+Order_Id;
		return jdbctemplate.query(sql, new ResultSetExtractor<Order>() {
			public Order extractData(ResultSet rs) throws SQLException
			{
				if(rs.next())
				{
					Order order = new Order();
					order.setTotal_price(rs.getInt("Total_price"));
					order.setGrand_total(rs.getInt("Grand_total"));
					order.setEmployee(rs.getInt("Employee"));
					order.setOrder_id(rs.getInt("Order_id"));
					order.setStatus(rs.getInt("Status"));
					return order;
				}
				return null;
			}
		});
	}

	public List<Order> getAllunassignedOrders() {
		// TODO Auto-generated method stub
		String sql="select * from Orders where Employee ="+5;
		List<Order> list=jdbctemplate.query(sql, new BeanPropertyRowMapper<Order>(Order.class));
		return list;
	}

	public List<Order> getAssignedOrders(int employee_id) {
		// TODO Auto-generated method stub
		String sql="select * from Orders where Employee="+employee_id;
		return jdbctemplate.query(sql, new BeanPropertyRowMapper<Order>(Order.class));

	}

}
