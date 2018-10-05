package com.bhanu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bhanu.model.Cart;

public interface Cartdao {
	@Autowired
	public void addToCart(Cart cart);
	public void removeFromCart(int Product_id,String Username);
	public List<Cart> getCartItems(String Username);
	public Boolean isIncart(int Product_id,String Username);
	public int getPrice(String Username);
}
