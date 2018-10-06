package com.bhanu.model;

import javax.validation.constraints.*;

public class Cart {

	@NotEmpty
	private int Product_id;
	@NotEmpty
	private String Customer;
	@Min(1)
	@Max(5)
	int Quantity;
	int Offer_id;
	String Correspondence;
	String Category;
	String Brand;
	String Type;
	String Size;
	int Price;
	
	
	public Cart()
	{
		
	}
	public int getProduct_id() {
		return Product_id;
	}
	public void setProduct_id(int product_id) {
		Product_id = product_id;
	}
	public String getCustomer() {
		return Customer;
	}
	public void setCustomer(String customer) {
		Customer = customer;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public int getOffer_id() {
		return Offer_id;
	}
	public void setOffer_id(int offer_id) {
		Offer_id = offer_id;
	}
	public String getCorrespondence() {
		return Correspondence;
	}
	public void setCorrespondence(String correspondence) {
		Correspondence = correspondence;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getSize() {
		return Size;
	}
	public void setSize(String size) {
		Size = size;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	
}
