package com.ats.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ats.model.OrderProducts;
import com.ats.util.SessionUtil;

public class OrderProductsDaoImplemented implements OrderProductsDaoInterface{
	
	private Session currentSession;
	private Transaction currentTransaction;
	private Date date = new Date();

	public void add(OrderProducts op) {
		currentSession = SessionUtil.getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();	
		System.out.println("----\nabout to save some order to the database");
		currentSession.save(op);
		System.out.println("Data about order no°" + op.getOrderno().getOrderno() + " were stored in the database at " + date + "\n----");
		currentTransaction.commit();
		currentSession.close();
	}

	public void deleteByOrderNo(int orderno) {
		// TODO Auto-generated method stub
		
	}

	public void update(OrderProducts op) {
		// TODO Auto-generated method stub
		
	}

	public boolean checkByOrderNo(int orderno) {
		// TODO Auto-generated method stub
		return false;
	}

	public OrderProducts getByOrderNo(int orderno) {
		// TODO Auto-generated method stub
		return null;
	}

	public double getTotalPriceById(int orderno) {
		currentSession = SessionUtil.getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		Query query =  currentSession.createNativeQuery("select sum(price) " + 
					                                          "from products inner join orderproducts " + 
				                                            "on productid = product_id " + 
				                                            "where orderno = '" + orderno + "'");
	  List resultSet = query.list();
		currentTransaction.commit();
		currentSession.close();
		return Double.parseDouble(resultSet.get(0).toString());
	}

}
