package DAO;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Entity.ParkingEntity;
import Util.HibernateUtil;



public class ParkingDao{

	
		public static void getParkingData() {

		    SessionFactory sf = HibernateUtil.getSessionFactory();

		    try (Session s = sf.openSession()) {

		        String hql = "FROM ParkingEntity";

		        Query<ParkingEntity> query =
		                s.createQuery(hql, ParkingEntity.class);

		        List<ParkingEntity> parkingList =
		                query.getResultList();

		        for (ParkingEntity parking : parkingList) {

		            System.out.println("Slots Number: " + parking.getSloatNo());
		            System.out.println("Name: " + parking.getDriverName());
		            System.out.println("Car number: " + parking.getCarNumber());
		            System.out.println("Car In Time" + parking.getInTime());
		            System.out.println("Car out Time"+parking.getOutTime());
		            System.out.println("Amount" +parking.getAmount());
		            System.out.println("----------------");
		        }
		    }
		    
		}
		
		
		//*Print a Slats number in Entity if this Slats are Generated automatically*
		
//		public static void sloatNo() {
//			SessionFactory sf = HibernateUtil.getSessionFactory();
//
//		    try (Session s = sf.openSession()) {
//
//		        String hql = "FROM ParkingEntity";
//
//		        Query<ParkingEntity> query =
//		                s.createQuery(hql, ParkingEntity.class);
//
//		        List<ParkingEntity> park =
//		                query.getResultList();
//		        System.out.println("Sloat Number :" +((ParkingEntity) park).getSloatNo());
//		        
//		    }
//		}
		
		 public static void deleteData(int sloatno) {

		        SessionFactory sf = HibernateUtil.getSessionFactory();

		        try (Session session = sf.openSession()) {

		            Transaction tx = session.beginTransaction();

		            String hql = "DELETE FROM ParkingEntity WHERE SloatNo = :SloatNo";

		            Query<?> query = session.createQuery(hql);

		            query.setParameter("SloatNo",sloatno);

		            int deletedRows = query.executeUpdate();

		            tx.commit();

		            System.out.println(deletedRows + " row deleted");
		        
		    }
		}
	}


	
