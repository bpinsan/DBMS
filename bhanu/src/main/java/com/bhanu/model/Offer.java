package com.bhanu.model;

import javax.validation.constraints.*;

public class Offer {
	
	int Offer_id;
	@Size(min=1,max=25)
	String Name;
	@Min(0)
	@Max(100)
	int Discount;
	int status;
	
	public Offer()
	{
		
	}
	
	public int getOffer_id() {
		return Offer_id;
	}

	public void setOffer_id(int offer_id) {
		Offer_id = offer_id;
	}

	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getDiscount() {
		return Discount;
	}
	public void setDiscount(int discount) {
		Discount = discount;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
