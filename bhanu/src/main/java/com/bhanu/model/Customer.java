package com.bhanu.model;

import javax.validation.constraints.NotEmpty;


public class Customer {
	@NotEmpty(message="Required")
	private String Username;
	@NotEmpty(message="Required")
	private String Password;
	@NotEmpty(message="Required")
	private String mPassword;
	@NotEmpty(message="Required")
	private String Name;
	@NotEmpty(message="Required")
	private String Email;
	@NotEmpty(message="Required")
	private String Contact;
	String Gender;
	String Details;
	int pincode;
	public Customer(String uname,String pass,String mpass) {
		this.Username=uname;
		this.Password=pass;
		this.mPassword=mpass;
	}
	public Customer(String uname,String pass) {
		this.Username=uname;
		this.Password=pass;
		
	}	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getmPassword() {
		return mPassword;
	}
	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
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
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getDetails() {
		return Details;
	}
	public void setDetails(String details) {
		Details = details;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
}
