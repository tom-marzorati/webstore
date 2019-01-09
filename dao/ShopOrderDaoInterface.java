package com.ats.dao;

import java.util.List;

import com.ats.model.ShopOrder;

public interface ShopOrderDaoInterface {
	
	/*
	 * 		METHODS TO ADD:
	 * 
	 * 		- Add
	 * 		- Delete
	 *    - Update
	 *    - Check by Id
	 *    - Get By Id (order number)
	 *    - Get By User ?
	 *    - Get By Date ? <--- OVERLOADED: BEFORE/AFTER/WITHIN SPECIFIED DATE (RANGE)
	 *    - Get By Address ?
	 *    
	 * 
	 * 
	 */

	public void add(ShopOrder o);
	public void deleteById(int id);	//"ORDERNO" is an integer!!
	public void update(ShopOrder o);
	public boolean checkById(int id);
	public ShopOrder getById(int id);
	public List<ShopOrder> getByUsername(String username);
	public ShopOrder getMostRecent(String username);
	
	
}
