package com.bhanu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bhanu.model.Wholesale_seller;

public interface Wholesale_sellerdao {
	
	@Autowired
	public void Addorupdate(Wholesale_seller wholesale_seller);
	public List<Wholesale_seller> Allseller();
	public Wholesale_seller Getseller(int seller_id);
	public void Update(Wholesale_seller seller);
}
