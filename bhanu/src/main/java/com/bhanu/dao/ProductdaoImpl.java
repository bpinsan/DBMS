package com.bhanu.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bhanu.model.Customer;
import com.bhanu.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductdaoImpl implements Productdao{
	@Autowired
	DataSource datasource;
	@Autowired
	JdbcTemplate jdbctemplate;
	public void SaveOrUpdate(Product product) {
		// TODO Auto-generated method stub
		String sql="insert into Product(Correspondence,Category,Brand,Type,Size,MRP,Discount,Price,Quantity) values(?,?,?,?,?,?,?,?,?)";
		jdbctemplate.update(sql,new Object[] {product.getCorrespondence(),product.getCategory(),product.getBrand(),product.getType(),product.getSize(),product.getMRP(),product.getDiscount(),product.getPrice(),product.getQuantity()});
	}
	public List<Product> GetAllProduct() {
		// TODO Auto-generated method stub
		String sql="select * from Product";
		List<Product> product=jdbctemplate.query(sql, new BeanPropertyRowMapper<Product>(Product.class));
		return product;
	}
	public Product GetProduct(int product_id) {
		// TODO Auto-generated method stub
		String sql="select * from Product where Product_id='"+product_id+"'";
		return jdbctemplate.query(sql,new ResultSetExtractor<Product>() {		
			public Product extractData(ResultSet rs) throws SQLException,DataAccessException{
				if(rs.next()) {
					Product product = new Product();
					product.setProduct_id(rs.getInt("Product_id"));
					product.setCorrespondence(rs.getString("Correspondence"));
					product.setCategory(rs.getString("Category"));
					product.setBrand(rs.getString("Brand"));
					product.setType(rs.getString("Type"));
					product.setSize(rs.getString("Size"));
					product.setDiscount(rs.getInt("Discount"));
					product.setQuantity(rs.getInt("Quantity"));
					product.setMRP(rs.getInt("MRP"));
					product.setPrice(rs.getInt("Price"));
					return product;
						}
					return null;
				}		
				});
	}
	public void Update(Product product) {
		// TODO Auto-generated method stub
		String sql="update Product set MRP="+product.getMRP()+", Discount="+product.getDiscount()+", Quantity="+product.getQuantity()+", Price ="+product.getPrice()+" where Product_id="+product.getProduct_id()+"";
		jdbctemplate.update(sql,new Object[] {});
		
	}
	public void UpdateQuantity(int Product_id, int Quantity) {
		// TODO Auto-generated method stub
		String sql="Update Product set Quantity=Quantity-"+Quantity+" where Product_id="+Product_id;
		jdbctemplate.update(sql);
	}
	
}
