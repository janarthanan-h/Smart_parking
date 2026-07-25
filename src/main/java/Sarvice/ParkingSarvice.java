package Sarvice;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import Entity.ParkingEntity;


public class ParkingSarvice{

	 public static ParkingEntity data() {
		
		ParkingEntity p=new  ParkingEntity();
		DateTimeFormatter format= DateTimeFormatter.ofPattern("H:mm");
		
		Scanner sc =new Scanner(System.in);
		
		System.out.print("Enter Slot No: ");
		p.setSloatNo(Integer.parseInt(sc.nextLine().trim()));	
		
		System.out.print("Enter Name: ");
		p.setDriverName(sc.nextLine().trim());
		
		System.out.print("Enter Car Number: ");
		p.setCarNumber(sc.nextLine().trim());
		
		System.out.print("Enter In-Time (H:mm, e.g. 2:30): ");
		LocalTime inTime = LocalTime.parse(sc.nextLine().trim(), format);
		p.setInTime(inTime);
		
		System.out.print("Enter Out-Time (H:mm, e.g. 4:30): ");
		LocalTime outTime = LocalTime.parse(sc.nextLine().trim(), format);
		p.setOutTime(outTime);
		
		return p;
	}
	 
	 
}
