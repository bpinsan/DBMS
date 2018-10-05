package com.bhanu.model;

public class Feedback {
	
	int Feedback_id;
	String Details;
	String Customer;
	int Product;
	public int getFeedback_id() {
		return Feedback_id;
	}
	public void setFeedback_id(int feedback_id) {
		Feedback_id = feedback_id;
	}
	public String getDetails() {
		return Details;
	}
	public void setDetails(String details) {
		Details = details;
	}
	public String getCustomer() {
		return Customer;
	}
	public void setCustomer(String customer) {
		Customer = customer;
	}
	public int getProduct() {
		return Product;
	}
	public void setProduct(int product) {
		Product = product;
	}
	
}
