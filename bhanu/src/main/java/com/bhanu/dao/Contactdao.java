package com.bhanu.dao;

import java.util.List;

import com.bhanu.model.Contact;
import com.bhanu.model.Customer;

public interface Contactdao {

	public void Addcontact(Contact contact);
	public void deletecontact(int contact_id);
	public void updatecontact(int contact_id);
	public List<Contact> Allcontact(String username);
}
