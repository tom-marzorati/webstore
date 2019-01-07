package com.accenture.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.accenture.model.Order;
import com.accenture.utility.SessionUtil;





public class OrderDaoImplment implements OrderDaoInterface <Order, Serializable>{
	
		
		  private Session currentSession;

		  private Transaction currentTransaction;
		  private static StandardServiceRegistry registry;
		  private static SessionFactory sessionFactory ;
		  
		  public Session openCurrentSession() {

				Session currentSession = SessionUtil.getSessionFactory().openSession();
				return currentSession;
		 }
		 
		  
		  public Transaction openCurrentSessionwithTransaction() {
				
			Session session = SessionUtil.getSessionFactory().openSession();
			Transaction currentTransaction  =  session.beginTransaction();
			return currentTransaction;
		  }
		  
		  public void closeCurrentSession() {

		    currentSession.close();
		  }
		  
		  public void closeCurrentSessionwithTransaction() {

				currentTransaction.commit();
	            currentSession.close();
	      }
		  
		  public static SessionFactory getSessionFactory() {
			    if (sessionFactory == null) {
				      try {
				        // Create registry
				        registry = new StandardServiceRegistryBuilder().configure().build();
				            
				            

				        // Create MetadataSources
				        MetadataSources sources = new MetadataSources(registry);

				        // Create Metadata
				        Metadata metadata = sources.getMetadataBuilder().build();

				        // Create SessionFactory
				        sessionFactory = metadata.getSessionFactoryBuilder().build();

				      } catch (Exception e) {
				        e.printStackTrace();
				        if (registry != null) {
				          StandardServiceRegistryBuilder.destroy(registry);
				        }
				      }
				    }
				    return sessionFactory;
				  }
		  
		  public Session getCurrentSession() {

		     return currentSession = SessionUtil.getSessionFactory().getCurrentSession();
		  }
		  
		  
		  public void setCurrentSession(Session currentSession) {

				this.currentSession = currentSession;
	      }
		  
		  public Transaction getCurrentTransaction() {
		
				return currentTransaction;
		
		}
		  
		  
		  
	public boolean addOrder(Order order) {
		// TODO Auto-generated method stub
		return false;
	}

	public Order getById(String orderno) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateOrder(Order order) {
		// TODO Auto-generated method stub
		return false;
	}

}
