package DAO;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Entity.ParkingEntity;
import Util.HibernateUtil;

public class ParkingDao{
	
	public static void Sloat() {
		
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		String hql = "SELECT slotNo FROM ParkingEntity";

		Query<Integer> q = s.createQuery(hql, Integer.class);

		List<Integer> slotNumbers = q.getResultList();

		for (Integer slot : slotNumbers) {
		    System.out.println(slot);
		}

		s.close();
		sf.close();
	}
	
	public static void delet(int slotNo) {
		Scanner sc = new Scanner(System.in);

		

		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();

		//HQL code for Select sloatNo in table
		String selecte = "FROM ParkingEntity WHERE slotNo = :slotNo";

		Query<ParkingEntity>sQ =
		        s.createQuery(selecte, ParkingEntity.class);

		sQ.setParameter("slotNo", slotNo);

		ParkingEntity p = sQ.uniqueResult();

		if (p != null) {

		    // Print the record before deleting
		    System.out.println("Record Found");
		    System.out.println("----------------------------");
		    System.out.println("Slot No    : " + p.getSloatNo());
		    System.out.println("Driver Name: " + p.getDriverName());
		    System.out.println("Car Number : " + p.getCarNumber());
		    System.out.println("In Time    : " + p.getInTime());
		    System.out.println("Out Time   : " + p.getOutTime());

		    // Step 2: Delete the record
		    String delete = "DELETE FROM ParkingEntity WHERE slotNo = :slotNo";

		    Query dQ = s.createQuery(delete);
		    dQ.setParameter("slotNo", slotNo);

		    int rows = dQ.executeUpdate();

		    System.out.println("Rows Deleted: " + rows);

		} else {
		    System.out.println("No record found with Slot No: " + slotNo);
		}

//		t.commit();
		s.close();
		sf.close();
		
	}
	
}