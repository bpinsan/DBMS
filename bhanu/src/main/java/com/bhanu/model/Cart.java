package com.bhanu.model;

import javax.validation.constraints.NotEmpty;

public class Cart {

	@NotEmpty
	private int Product_id;
	@NotEmpty
	private String Customer;
	int Quantity;
	
	public Cart()
	{
		
	}
	public int getProduct_id() {
		return Product_id;
	}
	public void setProduct_id(int product_id) {
		Product_id = product_id;
	}
	public String getCustomer() {
		return Customer;
	}
	public void setCustomer(String customer) {
		Customer = customer;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
}
