package org.sps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class application {

	public static void main(String[] args) {
		
		SPSEntitys e= SPSfuction.data() ;
		
		Configuration con=new Configuration();
		
		con.configure().addAnnotatedClass(SPSEntitys.class);
		
		SessionFactory sf = con.buildSessionFactory();
		
		Session s = sf.openSession();
		
		Transaction t = s.beginTransaction();
		
		SPSEntitys ex= s.get(SPSEntitys.class, e.getSloatNo());
		
		if(ex != null) {
			System.out.println("Data already Exists");
		}else {
			System.out.println("Data inserted Successdfully.");
		}
		
		s.persist(e);
		
		t.commit();
		
		s.clear();
		sf.close();
		

	}

}
