package org.sps;


import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import Entity.ParkingEntity;
import Sarvice.ParkingSarvice;
import Util.HibernateUtil;


public class application {
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		 ParkingEntity e= ParkingSarvice.data();
			SessionFactory sf=HibernateUtil.getSessionFactory();
			Session s = sf.openSession();
			Transaction t = s.beginTransaction();
			ParkingSarvice.data();
		s.persist(e);
		t.commit();
	}
	

}
