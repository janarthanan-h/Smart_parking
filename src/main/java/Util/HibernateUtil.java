package Util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import Entity.ParkingEntity;

public class HibernateUtil {
	
	private static final SessionFactory sf=new Configuration()
			.configure().addAnnotatedClass(ParkingEntity.class)
			.buildSessionFactory();
	
	public static SessionFactory getSessionFactory() {
		return sf;
		
	}
}
