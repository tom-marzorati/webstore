package com.ats.dao;

import java.util.Set;

import com.ats.model.*;

public interface ShopUserDaoInterface {

	public void add(ShopUser u);
	public boolean checkById(String id);
	public ShopUser getById(String id);
	public void deleteById(String id);
	public void update(ShopUser u);
	public Set<ShopOrder> getPastOrders(String id);
	public ShopOrder getLastOrder(String id); //    <---- WAITING FOR IMPLEMENTATION
	
}
