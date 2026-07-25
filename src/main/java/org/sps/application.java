package org.sps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Entity.ParkingEntity;
import Sarvice.ParkingSarvice;
import Util.HibernateUtil;

public class application {
	
	public static void main(String[] args) {
		
		ParkingEntity e= ParkingSarvice.data();
		
		
		SessionFactory sf=HibernateUtil.getSessionFactory();
		
		Session s = sf.openSession();
		
		Transaction t = s.beginTransaction();
		
		ParkingEntity ex= s.get(ParkingEntity.class, e.getSloatNo());
		
		if(ex != null) {
			System.out.println("Data already Exists try other sloats");
		}else {
			System.out.println("Data inserted Successdfully.");
		}
		
		
		s.persist(e);
		t.commit();
		
		s.close();
		sf.close();
		
		
	}

}
