package com;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	
	private static SessionFactory factory=null;
	
	static {
		
		try {
			
				
		StandardServiceRegistry reg = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		
		Metadata metadata = new MetadataSources(reg).getMetadataBuilder().build();
		
		SessionFactory factory = metadata.getSessionFactoryBuilder().build();
		
	}catch (Exception e){
		e.printStackTrace();
	}
		
	}
	
	public static SessionFactory getSessionFactory() {
		return factory;
	}

}
