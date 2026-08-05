package Sarvice;



import java.util.List;
import java.util.Scanner;

import DAO.ParkingDao;
import Entity.ParkingEntity;


public class ParkingSarvice{

	 public static ParkingEntity data(){
		 
		 Scanner sc=new Scanner(System.in);
		 ParkingEntity p=new ParkingEntity();
		 
			boolean Run = true;
			while (Run) {
				System.out.println("===========Smart Parking System==========");
				System.out.println("1------->All Booked Slot information's in database");
			    System.out.println("2------->Vehicle infromation's Insert in DB");
			    System.out.println("3------->Vehicle infromation's Out data Insert in DB");
			    System.out.println("4------->Delet the data After Vehicle exit ");
			    System.out.println("0------->Exit the program");
			    
			    
			    System.out.println("Enter Choice to Start");
			    int choice=sc.nextInt();
			    
			    switch (choice) {
                case 1:{
                	viewAllSloat();
                	break;
                }
                case 2:{
                	ParkingDao.EntryData();
                	break;
                	}
                case 3:{
                	ParkingDao.OutData();
            		break;
                }
                case 4:{
                	
                	ParkingDao.deleteData();
                	break;                
                  }
                case 0:{
                	Run= false;
                    System.out.println("Thank you for using ");
                    break;
                }
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
			    }
			}
			return p;
			
			
	 }
	 public static void viewAllSloat() {
		 
	        
	        List<ParkingEntity> park = ParkingDao.getAllSloatData();
	        System.out.println("List of Sloats ------------------------------> ");
	        if (park.isEmpty()) {
	            System.out.println("No donors found.");
	            return;
	        }
	        park.forEach(System.out::println);
	        System.out.println(" ");
	    }
	 
	}
