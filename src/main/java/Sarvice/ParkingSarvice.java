package Sarvice;

import java.util.Scanner;
import Entity.ParkingEntity;


public class ParkingSarvice{

	 public static ParkingEntity data() {
		
		ParkingEntity e=new  ParkingEntity();
		
		Scanner sc =new Scanner(System.in);
		
		System.out.println("Enter the Sloat number");
		e.setSloatNo(sc.nextInt());
		
		System.out.println("Enter the Coustermar Name");
		e.setName(sc.nextLine());
		sc.nextLine();
		
		System.out.println("Enter the Car Number");
		e.setCarNumber(sc.nextLine());
		
		System.out.println("Enter the Duuration");
		e.setDuration(sc.nextInt());
		
		System.out.println("Enter the Amount");
		e.setAmount(sc.nextInt());
		
		
		return e;
		
		
	}
}
