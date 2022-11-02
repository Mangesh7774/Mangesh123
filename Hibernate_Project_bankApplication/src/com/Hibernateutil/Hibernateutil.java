package com.Hibernateutil;

import java.util.HashMap;
import java.util.Map;


import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import com.model.Account;


public class Hibernateutil {

	private static StandardServiceRegistry registry;
	private static SessionFactory factory;
	
	public static SessionFactory getSessionFactory()
	{	
		
		if(factory==null)
		{	
			
			Map<String, Object> m=new HashMap<String, Object>();
			
			m.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
			m.put(Environment.URL, "jdbc:mysql://localhost:3306/tank");
			m.put(Environment.USER, "root");
			m.put(Environment.PASS, "");
			m.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
			m.put(Environment.HBM2DDL_AUTO, "update");
			//m.put(Environment.SHOW_SQL, "true");
			m.put(Environment.FORMAT_SQL, "true");
			
			
			registry = new StandardServiceRegistryBuilder().applySettings(m).build();
			
			MetadataSources mds = new MetadataSources(registry);
			 
			mds.addAnnotatedClass(Account.class); 
			
			Metadata md = mds.getMetadataBuilder().build();
			
			factory = md.getSessionFactoryBuilder().build();
											
									
		}						
		return factory;
				
	}	
	
}

