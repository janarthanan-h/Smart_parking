package Entity;

import java.time.Duration;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ParkingEntity{
	
	@Id
	private int slno;
	private int SloatNo;
	private String DriverName;
	private String carNumber;
	
	private LocalTime inTime;
	private LocalTime outTime;
	
	private float duration;
	private float amount;
	
	// slno 
	public int getSlno() {
		return slno;
	}
	public void setSlno(int slno) {
		this.slno = slno;
	}
	// SloatNumber
	public int getSloatNo() {
		return SloatNo;
	}
	public void setSloatNo(int sloatNo) {
		SloatNo = sloatNo;
	}
	//Driver Name
	public String getDriverName() {
		return DriverName;
	}
	public void setDriverName(String driverName) {
		DriverName = driverName;
	}
	//Car Number
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public void setInTime(LocalTime inTime) {
		this.inTime = inTime;
	}

	//In Time 
	public LocalTime getInTime() {
		return inTime;
	}
	public String getCarNumber() {
		return carNumber;
	}
	//Out Time
	public LocalTime getOutTime() {
		return outTime;
	}
	public void setOutTime(LocalTime outTime) {
		this.outTime = outTime;
//		calcutation();
	}
	//time Duration
	public float getDuration() {
		return duration;
	}
	public void setDuration(float duration) {
		this.duration = duration;
	}
	//Amount =Duration *40
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount2) {
		this.amount = amount2;
	}
	
	
//	private void calcutation() {
//		if (inTime != null && outTime != null) {
//			Duration D = Duration.between(inTime, outTime);
//			
//			long Min = D.toMinutes();
//			
//			this.duration =Min/60f;
//			this.amount = Math.round(this.duration*40);
//			System.out.println(amount);
//		}
//		
//	}
	


	
	

	
}