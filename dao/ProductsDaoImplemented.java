package com.ats.dao;

import java.util.ArrayList;
import java.util.List;

 

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ats.model.Products;
import com.ats.util.SessionUtil;


public class ProductsDaoImplemented implements ProductsDaoInterface{
	
	private Session currentSession;
	private Transaction currentTransaction;
	
	public boolean checkById(int id) {
		boolean ret = false;
		System.out.println(id);
		currentSession = SessionUtil.getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		Query query =  currentSession.createQuery("from Products where product_id = :id");
		query.setParameter("id", id);
		System.out.println(query);
		List<Products> resultSet = query.list();
		System.out.println("begin");
		System.out.println(resultSet);
		
		if (resultSet.size()>0) {
			//User exists: ok	
			System.out.println(id);
			ret = true;
		}		
		currentTransaction.commit();
		currentSession.close();
		System.out.println(ret);
		return ret;
	}

//Returns products with the specified id
	public Products getById(int id) {
		currentSession = SessionUtil.getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		List<Products> theProducts = new ArrayList<Products>();
		theProducts = currentSession.createQuery("from Products where productId = " + id).list();
		//currentSession.find(entityClass, primaryKey)
		
		
		//some prints
		System.out.println("STARTING TO PRINT");
		System.out.println("Length of array: " + theProducts.size());
		for (Products p : theProducts) {
			System.out.println("");
			System.out.println(p);
			System.out.println("");
		}
		System.out.println("DONE PRINTNING");
		System.out.println(theProducts.get(0) + " retrieved");
		currentTransaction.commit();
		currentSession.close();
		return theProducts.get(0);
	}
	
	public Products getByCategory(String cat) {
		currentSession = SessionUtil.getSessionFactory().getCurrentSession();
		currentTransaction = currentSession.beginTransaction();
		List<Products> theProducts = new ArrayList<Products>();
		theProducts = currentSession.createQuery("from Products where CATEGORY = '" + cat + "'").list();
		currentTransaction.commit();
		currentSession.close();
		
		//some prints
		System.out.println("STARTING TO PRINT");
		System.out.println("Length of array: " + theProducts.size());
		for (Products p : theProducts) {
			System.out.println("");
			System.out.println(p);
			System.out.println("");
		}
		System.out.println("DONE PRINTNING");
		System.out.println(theProducts.get(0) + " retrieved");
		
		return theProducts.get(0);
	}
	
	public void add(Products p) {
		currentSession = SessionUtil.getSessionFactory().getCurrentSession();
		currentTransaction = currentSession.beginTransaction();
		System.out.println("about to save some product");
		currentSession.save(p);
		System.out.println(p + "\nwas added successfully");
		currentTransaction.commit();
		currentSession.close();
	}

}// end
