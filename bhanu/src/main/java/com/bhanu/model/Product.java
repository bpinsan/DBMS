package com.bhanu.model;

import javax.validation.constraints.NotEmpty;

public class Product {
	int Product_id;
	String Correspondence;
	String Category;
	String Brand;
	String Type;
	String Size;
	int MRP;
	int Discount;
	int Price;
	int Quantity;
	
	public Product()
	{
		
	}
	
	
	public int getProduct_id() {
		return Product_id;
	}


	public void setProduct_id(int product_id) {
		Product_id = product_id;
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
	public int getMRP() {
		return MRP;
	}
	public void setMRP(int mRP) {
		MRP = mRP;
	}
	public int getDiscount() {
		return Discount;
	}
	public void setDiscount(int discount) {
		Discount = discount;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
}
