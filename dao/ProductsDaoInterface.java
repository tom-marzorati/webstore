package com.ats.dao;

import com.ats.model.Products;

public interface ProductsDaoInterface {
	
	public Products getById(int id);
	public void add(Products p);
	public boolean checkById(int id);

}
