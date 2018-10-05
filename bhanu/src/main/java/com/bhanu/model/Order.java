package com.bhanu.model;

import java.sql.Date;

public class Order {
	
	int Order_id;
	String Username;
	Date Booking_date;
	String Details;
	int Pincode;
	int Employee;
	int status;
	int Total_price;
	int Grand_total;
	String Customer;
	public Order()
	{
		
	}
	
	public int getOrder_id() {
		return Order_id;
	}

	public void setOrder_id(int order_id) {
		Order_id = order_id;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public Date getBooking_date() {
		return Booking_date;
	}
	public void setBooking_date(Date booking_date) {
		Booking_date = booking_date;
	}
	public String getDetails() {
		return Details;
	}
	public void setDetails(String details) {
		Details = details;
	}
	public int getPincode() {
		return Pincode;
	}
	public void setPincode(int pincode) {
		Pincode = pincode;
	}
	public int getEmployee() {
		return Employee;
	}
	public void setEmployee(int employee) {
		Employee = employee;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getTotal_price() {
		return Total_price;
	}
	public void setTotal_price(int total_price) {
		Total_price = total_price;
	}
	public int getGrand_total() {
		return Grand_total;
	}
	public void setGrand_total(int grand_total) {
		Grand_total = grand_total;
	}
	public String getCustomer() {
		return Customer;
	}
	public void setCustomer(String customer) {
		Customer = customer;
	}
	
}
