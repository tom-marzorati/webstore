package com.accenture.dao;

import java.io.Serializable;

import com.accenture.model.Order;


public interface OrderDaoInterface <Order, Id extends Serializable>{
	
	
	public boolean addOrder(Order order);
	public Order getById (String orderno);
	public boolean updateOrder(Order order);
	

}
