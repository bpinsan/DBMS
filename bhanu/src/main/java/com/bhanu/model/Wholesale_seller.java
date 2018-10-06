package com.bhanu.model;

public class Wholesale_seller {
	
	int Seller_id;
	String Name;
	String Address;
	String Email;
	String Contact;
	
	public Wholesale_seller()
	{
		
	}
	
	public int getSeller_id() {
		return Seller_id;
	}
	public void setSeller_id(int seller_id) {
		Seller_id = seller_id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getContact() {
		return Contact;
	}
	public void setContact(String contact) {
		Contact = contact;
	}
	
}
