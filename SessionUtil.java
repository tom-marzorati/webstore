package com.ats.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class SessionUtil {
	

//singleton (?)
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory ;
	
	public static SessionFactory getSessionFactory() {
		/*
		 * HOW TO:
		 * 
		 * 	1) Initialize Registry
		 *  2) Create Metadata Source
		 *  3) Create Metadata
		 *  4) Create SessionFactory type object
		 *  
		 *  
		 */
		if (sessionFactory==null){
			try {
				// 1)
				registry = new StandardServiceRegistryBuilder().configure().build();
			
				// 2)
				MetadataSources source = new MetadataSources(registry);
				
				// 3)
				Metadata metadata = source.getMetadataBuilder().build();
				
				// 4)
				SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();			
				return sessionFactory;
			} catch (Exception e) {
				e.printStackTrace();
		        if (registry != null) {
		          StandardServiceRegistryBuilder.destroy(registry);
		        }
			}
		}			
		return sessionFactory;
	}//End of getSessionFactory
	
	//what's the use of this tho?
	public static void shutdown() {
	    if (registry != null ) {
	      StandardServiceRegistryBuilder.destroy(registry);
	      sessionFactory.close();
	    }
	}//end of method i don't really get
	
}
