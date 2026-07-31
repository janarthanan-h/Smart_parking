package Sarvice;


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import DAO.ParkingDao;
import Entity.ParkingEntity;


public class ParkingSarvice{

	 public static  ParkingEntity data() {
		 Scanner sc=new Scanner(System.in);
		 ParkingEntity p=new ParkingEntity();
		 
			
			String choice;

			  do {
				  
				  System.out.println("sloats");
				  System.out.println("in");
				  System.out.println("out");
				  System.out.println("delet");
				  System.out.println("exit");
				  
		           choice = sc.next().toLowerCase(); 

		            switch (choice) {
		                case "sloats":{
		                	ParkingDao.getSloatData();;
		                	break;
		                }
		                case "in":{
		                	ParkingDao.EntryData();
		                	return p;
		                	
		                	}
		                case "out":{
		                	ParkingDao.OutData();
		            		break;
		                }
		                
		                case "delet":{
		                	
		                	ParkingDao.deleteData();
		                	
		                  break;                }
		                    
		                case "exit":{
		                    System.out.println("Thank you for using ");
		                    
		                    break;
		                }
		                default:
		                    System.out.println("Invalid choice! Please try again.");
		                    break;
		            }

		        } while (!choice.equals("exit"));
			  
			  return p;
	}
	 
	 
}
