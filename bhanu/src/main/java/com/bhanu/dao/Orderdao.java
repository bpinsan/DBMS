package com.bhanu.dao;

import java.util.List;

import com.bhanu.model.Order;
import com.bhanu.model.OrderItem;

public interface Orderdao {
	
	public int placeOrder(String Username,int Total_price,int Grand_total,int Offer_id);
	public List<Order> getOrders(String Username);
	public List<OrderItem> getOrderItems(int Order_Id);
	public void addToOrder(int Order_Id,int Product_id,int Quantity);
	public List<Order> getAllOrders();
	public void assignEmployee(int Order_Id,int Employee_id);
	public Order getOrder(int Order_Id);
	public List<Order> getAllunassignedOrders();
	public List<Order> getAssignedOrders(int employee_id);
}
