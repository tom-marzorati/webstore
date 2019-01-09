package com.ats.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ats.model.ShopOrder;
import com.ats.util.SessionUtil;

public class ShopOrderDaoImplemented implements ShopOrderDaoInterface {

	private Session currentSession;
	private Transaction currentTransaction;
	private Date date = new Date();

	public void add(ShopOrder o) {
		currentSession = SessionUtil.getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();	
		System.out.println("----\nabout to save some order to the database");
		currentSession.save(o);
		System.out.println("Order no°" + o.getOrderno() + " was performed by " + o.getUserid().getUsername() + " at " + date.toString());
		System.out.println("Data about the transaction were stored in the database\n----");
		currentTransaction.commit();
		currentSession.close();
	}

	public void deleteById(int id) {
		ShopOrder o = getById(id);	
		if(o!=null) {
			currentSession = SessionUtil.getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		currentSession.delete(o);		
		currentTransaction.commit();
		currentSession.close();
		System.out.println("order no°" + id + " was removed from the database at " + date);	
		} else {
			System.out.println("No such order exists");
		}	
	}

	public void update(ShopOrder o) {
		System.out.println("Updating data about order no°" + o.getOrderno());
		deleteById(o.getOrderno());
		add(o);		
	}

	public boolean checkById(int id) {
		boolean ret = false;
		currentSession = SessionUtil.getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();	
		Query query =  currentSession.createQuery("from ShopOrder where orderno = :id");
		query.setParameter("id", id);
		List<ShopOrder> resultSet = query.list();		
		if (resultSet.size()>0) {
			System.out.println(resultSet.get(0));
			ret = true;
		}			
		currentTransaction.commit();
		currentSession.close();
		System.out.println(ret);
		return ret;
	}

	public ShopOrder getById(int id) {
		ShopOrder o = null;
		currentSession = SessionUtil.getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		Query query =  currentSession.createQuery("from ShopOrder where orderno = :id");
		query.setParameter("id", id);
		List<ShopOrder> resultSet = query.list();
		if(resultSet.size()>0) {
			o = resultSet.get(0);
			System.out.println("Selected Order no°" + id + " at " + date.getTime());
		}				
		currentTransaction.commit();
		currentSession.close();
		return o;
	}

	public List<ShopOrder> getByUsername(String username) {
		currentSession = SessionUtil.getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		Query query =  currentSession.createQuery("from ShopOrder where username = :username"); //"username" or "userid"??? let's check it out
		query.setParameter("username", username);
		List<ShopOrder> resultSet  = query.list();
//		System.out.println("List of " + username + "'s last "+ resultSet.size() + " orders");
//		for (ShopOrder o : resultSet) {
//			System.out.println(o);
//		}
		currentTransaction.commit();
		currentSession.close();
		return resultSet;
	}

	public ShopOrder getMostRecent(String username) {
		currentSession = SessionUtil.getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		Query query =  currentSession.createQuery("from ShopOrder where orderno = (select max(orderno) from ShopOrder) and username = :username");
		query.setParameter("username", username);
		List<ShopOrder> resultSet = query.list();
		currentTransaction.commit();
		currentSession.close();
		return resultSet.get(0);
	}

}
