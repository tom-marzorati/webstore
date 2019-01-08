package com.ats.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ats.model.ShopOrder;
import com.ats.model.ShopUser;
import com.ats.util.SessionUtil;

public class ShopUserDaoImplemented implements ShopUserDaoInterface {
	
	private Session currentSession;
	private Transaction currentTransaction;

	public void add(ShopUser u) {
		currentSession = SessionUtil.getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();	
		System.out.println("about to save some user");
		currentSession.save(u);
		System.out.println(u + "\nwas added successfully");		
		currentTransaction.commit();
		currentSession.close();
		
		
	}

	public boolean checkById(String id) {
		boolean ret = false;
		currentSession = SessionUtil.getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();	
		Query query =  currentSession.createQuery("from ShopUser where username = :id");
		query.setParameter("id", id);
		List<ShopUser> resultSet = query.list();		
		if (resultSet.size()>0) {
			System.out.println(resultSet.get(0));
			ret = true;
		}			
		currentTransaction.commit();
		currentSession.close();
		System.out.println(ret);
		return ret;
	}

	public ShopUser getById(String id) {
		ShopUser u = null;
		currentSession = SessionUtil.getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		// DO THINGS
		Query query =  currentSession.createQuery("from ShopUser where username = :id");
		query.setParameter("id", id);
		List<ShopUser> resultSet = query.list();
		u = resultSet.get(0);
		System.out.println("GOTCHA, " + u);
		currentTransaction.commit();
		currentSession.close();
		return u;
	}

	public void deleteById(String id) {		
		ShopUser u = getById(id);	
		currentSession = SessionUtil.getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();		
		currentSession.delete(u);		
		currentTransaction.commit();
		currentSession.close();
		System.out.println(u.getUsername() + " deleted");		
	}

	public void update(ShopUser u) {		
		deleteById(u.getUsername());
		add(u);
		System.out.println("--------------------\n"+u+"\n\nwas updated");
	}

	//Returns list of all orders made
	public Set<ShopOrder> getPastOrders(String id) {	
		ShopUser u = getById(id);
		if(u.getOrders().size()>0) {
			System.out.println(u.getUsername() + "'s last " + u.getOrders().size() + " orders:");
			//Prints out orders:
			for(ShopOrder o : u.getOrders()) {
				System.out.println(o);
			}	
		} else {
			System.out.println("No orders have been made yet");
		}		
		return u.getOrders();
	}

	public ShopOrder getLastOrder(String id) {
		//still have to do this one
		return null;
	}

}
