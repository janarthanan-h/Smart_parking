package DAO;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

		            System.out.println(parking);
		        }
		    }
		}
	}


	
