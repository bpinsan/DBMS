package com.bhanu.model;

public class Productfitting {
	
	String Customer;
	int Product_id;
	int Quantity;
	String Deadline;
	int Status;
	String Details;
	
	public Productfitting()
	{
		
	}
	public String getCustomer() {
		return Customer;
	}
	public void setCustomer(String customer) {
		Customer = customer;
	}
	public int getProduct_id() {
		return Product_id;
	}
	public void setProduct_id(int product_id) {
		Product_id = product_id;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public String getDeadline() {
		return Deadline;
	}
	public void setDeadline(String deadline) {
		Deadline = deadline;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public String getDetails() {
		return Details;
	}
	public void setDetails(String details) {
		Details = details;
	}
	
}
