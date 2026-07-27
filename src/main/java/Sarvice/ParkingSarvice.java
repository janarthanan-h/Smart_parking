package Sarvice;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import DAO.ParkingDao;
import Entity.ParkingEntity;


public class ParkingSarvice{

	 public static ParkingEntity data() {
		 Scanner sc=new Scanner(System.in);
		 ParkingEntity p=new ParkingEntity(); 
		 DateTimeFormatter format= DateTimeFormatter.ofPattern("H:mm");
			
			String choice;

			  do {
				  
				  System.out.println("sloats");
				  System.out.println("in");
				  System.out.println("out");
				  System.out.println("exit");
		           choice = sc.next().toLowerCase(); 

		            switch (choice) {
		                case "Sloats":{
		                	ParkingDao.Sloat();
		                	break;
		                }
		                case "in":{
		                	
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
		            		
		            		break;
		                }
		                case "out":{
		                	
		                	System.out.println("Enter Sloat No");
		                	int slotNo = Integer.parseInt(sc.next().trim());
		                	p.setSloatNo(slotNo);
		                	
		                	System.out.print("Enter Out-Time (H:mm, e.g. 4:30): ");
		            		LocalTime outTime = LocalTime.parse(sc.next().trim(), format);
		            		
		            		p.setOutTime(outTime);
//		            		ParkingDao.delet(slotNo);
		            		
		            		break;
		                }
		                    
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
