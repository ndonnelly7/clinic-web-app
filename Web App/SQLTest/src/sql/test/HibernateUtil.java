package sql.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static ServiceRegistry serviceRegistry;
	
	private static SessionFactory buildSessionFactory() {
		try {
			Configuration conf = new Configuration();
			conf.configure();
			conf.addAnnotatedClass(BookPart.class);
			conf.addAnnotatedClass(FilmPart.class);
			conf.addAnnotatedClass(Actor.class);
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
