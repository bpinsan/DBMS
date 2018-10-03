package com.bhanu.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.bhanu.model.Cart;

public interface Cartdao {
	@Autowired
	public void SaveOrUpdate(Cart cart);
	
}
