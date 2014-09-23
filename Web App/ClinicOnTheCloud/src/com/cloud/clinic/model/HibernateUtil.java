package com.cloud.clinic.model;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/*
 * 
 * Builds sessions for Hibernate
 * 
 */

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static ServiceRegistry serviceRegistry;
	
	private static SessionFactory buildSessionFactory() {
		try {
			Configuration conf = new Configuration();
			conf.configure();
			serviceRegistry = new ServiceRegistryBuilder().applySettings(
		            conf.getProperties()).buildServiceRegistry();
			SessionFactory sessF = conf.buildSessionFactory(serviceRegistry);
			return sessF;
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed: " + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static void shutdown() {
		getSessionFactory().close();
	}
}

