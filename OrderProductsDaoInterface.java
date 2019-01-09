package com.ats.dao;

import java.util.List;

import com.ats.model.OrderProducts;

public interface OrderProductsDaoInterface {
	
	public void add(OrderProducts op);
	public void deleteByOrderNo(int orderno);
	public void update(OrderProducts op);
	public boolean checkByOrderNo(int orderno);
	public OrderProducts getByOrderNo(int orderno);
	public double getTotalPriceById(int orderno);
	
}
