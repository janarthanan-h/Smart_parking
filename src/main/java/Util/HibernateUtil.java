package Util;

import Entity.ParkingEntity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
	
	private static final SessionFactory sf = buildSessionFactory(); 
	
	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration()
					.configure()
					.addAnnotatedClass(ParkingEntity.class)
					.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println( "Hibernate SessionFactory vreation Failed :"+ex);
			// TODO Auto-generated catch block
			throw new ExceptionInInitializerError(ex);
		}
		
	}
	
	public static SessionFactory getSessionFactory() {
		return sf;
		
	}
	public static void shutdown() {
		getSessionFactory();
	}


}
