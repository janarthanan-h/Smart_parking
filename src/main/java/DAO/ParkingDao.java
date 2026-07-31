package DAO;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Entity.ParkingEntity;
import Sarvice.ParkingSarvice;
import Util.HibernateUtil;



public class ParkingDao{
	
		public static void getSloatData()  {

			SessionFactory sf =HibernateUtil.getSessionFactory();
			Scanner sc =new Scanner(System.in);
			try (Session s= sf.openSession()){
				Transaction t = s.beginTransaction();
				
				try {
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
			catch (Exception e) {
				if(t.getStatus().canRollback()) {
					t.rollback();
					}
				System.out.println("Failed to save record: " + e.getMessage());
				 }
				}
		   
		     
		}
		
		public static void EntryData() {
			
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Scanner sc = new Scanner(System.in);

			try (Session s = sf.openSession()) {
			    Transaction t = s.beginTransaction();
			    try {
			        ParkingEntity p = new ParkingEntity();
			        DateTimeFormatter format = DateTimeFormatter.ofPattern("H:mm");

			        System.out.print("Enter Slot No: ");
			        p.setSloatNo(Integer.parseInt(sc.next().trim()));
			        sc.nextLine();

			        System.out.print("Enter Name: ");
			        p.setDriverName(sc.next().trim());
			        sc.nextLine();

			        System.out.print("Enter Car Number: ");
			        p.setCarNumber(sc.next().trim());
			        sc.nextLine();

			        System.out.print("Enter In-Time (H:mm, e.g. 2:30): ");
			        LocalTime inTime = LocalTime.parse(sc.next().trim(), format);
			        p.setInTime(inTime);

			        s.persist(p);   // registers the entity for insert
			        t.commit();     // actually writes it to the DB

			        System.out.println("Parking record saved successfully.");

			    } catch (Exception e) {
			        if (t.getStatus().canRollback()) {
			            t.rollback();
			        }
			        System.out.println("Failed to save record: " + e.getMessage());
			    }
			}
    		
    		
		}
		
		public static void OutData() {

			    SessionFactory sf = HibernateUtil.getSessionFactory();
			    Scanner sc = new Scanner(System.in);

			    try (Session s = sf.openSession()) {
			        Transaction t = s.beginTransaction();
			        try {
			            DateTimeFormatter format = DateTimeFormatter.ofPattern("H:mm");

			            System.out.print("Enter Slot Number: ");
			            int slotNo = Integer.parseInt(sc.next().trim());

			            ParkingEntity p = s.createQuery(
			                    "FROM ParkingEntity WHERE SloatNo = :slot AND outTime IS NULL",
			                    ParkingEntity.class)
			                    .setParameter("slot", slotNo)
			                    .setMaxResults(1)
			                    .uniqueResult();

			            if (p == null) {
			                System.out.println("No active parking found for slot " + slotNo);
			                t.rollback();
			                return;
			            }

			            LocalTime inTime = p.getInTime();
			            System.out.println("In Time : " + inTime);

			            System.out.print("Enter Out Time: ");
			            LocalTime outTime = LocalTime.parse(sc.next().trim(), format);

			            Duration duration = Duration.between(inTime, outTime);
			            if (duration.isNegative()) {
			                duration = duration.plusHours(24); // crossed midnight
			            }

			            float hours = duration.toMinutes() / 60f;
			            float amount = hours * 40;

			            p.setOutTime(outTime);
			            p.setDuration(hours);
			            p.setAmount(amount);

			            // p is already managed by session s (loaded via query) —
			            // no need to call persist(); dirty checking saves it on commit.
			            t.commit();

			            System.out.println("Hours  : " + hours);
			            System.out.println("Amount : Rs." + amount);

			        } catch (Exception e) {
			            if (t.getStatus().canRollback()) {
			                t.rollback();
			            }
			            System.out.println("Failed to check out: " + e.getMessage());
			        }
			    }
					
}
		
		 public static  void deleteData() {
			 ParkingEntity p=new ParkingEntity();
			 
		        SessionFactory sf = HibernateUtil.getSessionFactory();

		        try (Session session = sf.openSession()) {

		            Transaction tx = session.beginTransaction();
		           
		            Scanner sc=new Scanner(System.in);
		            int slno= sc.nextInt();

		            String hql = "DELETE FROM ParkingEntity WHERE SloatNo = :SloatNo";

		            Query<?> query = session.createQuery(hql);

		            query.setParameter("SloatNo",slno);

		            int deletedRows = query.executeUpdate();

		            tx.commit();

		            System.out.println(deletedRows + " row deleted" +p.getSloatNo());
		            
		            System.out.println( slno +" Sloat Deleted Successfully ");
		        
		    }
		         
		}
		 
		 


	}


	
