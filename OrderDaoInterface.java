package com.accenture.dao;

import com.accenture.model.Order;


public interface OrderDaoInterface {
	
	
	public boolean addOrder(Order order);
	public Order getById (String orderno);
	public boolean updateOrder(Order order);
	

}
