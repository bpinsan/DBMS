package com.bhanu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bhanu.model.Cart;

public class CartdaoImpl implements Cartdao {

	@Autowired
	DataSource datasource;
	@Autowired
	JdbcTemplate jdbctemplate;
	
	@Autowired
	Productdao productdao;
	
    public CartdaoImpl(DataSource datasource) {
		// TODO Auto-generated constructor stub
    	this.jdbctemplate = new JdbcTemplate(datasource);
	}

	public void addToCart(Cart cart) {
		// TODO Auto-generated method stub
		String sql="insert into Cart set Customer=?,Product_id=?,Quantity=?";
		Object[] object= {cart.getCustomer(),cart.getProduct_id(),cart.getQuantity()};
		jdbctemplate.update(sql,object);
		
	}

	public void removeFromCart(int Product_id, String Username) {
		// TODO Auto-generated method stub
		String sql="delete from Cart where Product_id=? and Customer=?";
		Object[] object= {Product_id,Username};
		jdbctemplate.update(sql,object);
		
	}

	public List<Cart> getCartItems(String Username) {
		// TODO Auto-generated method stub
		String sql="select * from Cart  where Customer=\""+Username+"\"";
		List<Cart> list=jdbctemplate.query(sql, new BeanPropertyRowMapper<Cart>(Cart.class));
		return list;
	}

	public Boolean isIncart(int Product_id, String Username) {
		// TODO Auto-generated method stub
		String sql="select * from Cart where Product_id=\""+Product_id+"\" and Customer=\""+Username+"\"";
		return jdbctemplate.query(sql,new ResultSetExtractor<Cart>() {
			public Cart extractData(ResultSet rs) throws SQLException
			{
				if(rs.next())
				{
					Cart cart=new Cart();
					cart.setProduct_id(rs.getInt("Product_id"));
					return cart;
				}
				return null;
			}
		}		
		)!=null;

	}

	public int getPrice(String Username) {
		// TODO Auto-generated method stub
		String sql="select * from Cart  where Cart.Customer=\""+Username+"\"";
		List<Cart> list=jdbctemplate.query(sql, new BeanPropertyRowMapper<Cart>(Cart.class));
		Iterator<Cart> itr=list.iterator();
		int amount=0;
		while(itr.hasNext())
		{
			Cart cart=itr.next();
			amount+=cart.getQuantity()*productdao.GetProduct(cart.getProduct_id()).getPrice();
		}
		return amount;
	}
	
}
