package com.bhanu.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.bhanu.model.Product;

public interface Productdao {
	@Autowired
	public void SaveOrUpdate(Product product);
	public java.util.List<Product> GetAllProduct();
	public Product GetProduct(int product_id);
	public void Update(Product product);
}
