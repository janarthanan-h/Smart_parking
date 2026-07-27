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
		 DateTimeFormatter format= DateTimeFormatter.ofPattern("H:mm");
			
			String choice;

			  do {
				  
				  System.out.println("sloats");
				  System.out.println("in");
				  System.out.println("out");
				  System.out.println("exit");
		           choice = sc.next().toLowerCase(); 

		            switch (choice) {
		                case "sloats":{
		                	ParkingDao.getParkingData();
		                	break;
		                }
		                case "in":{
		                	
		                	System.out.print("Enter Slot No:");
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
		                	System.out.print("Enter Slot No: ");
		            		p.setSloatNo(Integer.parseInt(sc.next().trim()));	
		            		sc.nextLine();
		            		
		                	System.out.print("Enter Out-Time (H:mm, e.g. 4:30): ");
		            		LocalTime outTime = LocalTime.parse(sc.next().trim(), format);
		            		
		            		p.setOutTime(outTime);
		            		break;
		                }
		                    
		                case "exit":{
		                	int n =sc.nextInt();
		                	for(int i=0;i<=n;i++) {
		                		System.out.println("Enetr Sloat Number You wont to Delet");
			                	ParkingDao.deleteData(n);
		                	}
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
