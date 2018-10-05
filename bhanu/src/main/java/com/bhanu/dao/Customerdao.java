package com.bhanu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bhanu.model.Customer;

public interface Customerdao {
	@Autowired
	public void SaveOrUpdateUSERS(Customer customer);
	public void SaveOrUpdateCustomer(Customer customer);
	public Customer getUser(String username);
	public Customer getCustomer(String username);
	public void editProfile(Customer customer, String Username);
	public List<Customer> Search(String Phoneno);

}
