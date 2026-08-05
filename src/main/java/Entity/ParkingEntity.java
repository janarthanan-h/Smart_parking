package Entity;


import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class ParkingEntity{
	
	@Id
	private int SloatNo;
	private String DriverName;
	private String carNumber;
	
	private LocalTime inTime;
	private LocalTime outTime;
	
	private float Duration;
	private float Amount;
	
	public ParkingEntity() {
		
	}
	
	public ParkingEntity(String DriverName,String carNumber, LocalTime inTime, LocalTime outTime,float Duration,float Amount){
		this.DriverName=DriverName;
		this.carNumber=carNumber;
		this.inTime= inTime;
		this.outTime=outTime;
		this.Duration=Duration;
		this.Amount=Amount;
	}
	






	public int getSloatNo() {
		return SloatNo;
	}
	public void setSloatNo(int sloatNo) {
		SloatNo = sloatNo;
	}
	public String getDriverName() {
		return DriverName;
	}
	public void setDriverName(String driverName) {
		DriverName = driverName;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public LocalTime getInTime() {
		return inTime;
	}
	public void setInTime(LocalTime inTime) {
		this.inTime = inTime;
	}
	public LocalTime getOutTime() {
		return outTime;
	}
	public void setOutTime(LocalTime outTime) {
		this.outTime = outTime;
	}
	public float getDuration() {
		return Duration;
	}
	public void setDuration(float duration) {
		this.Duration = duration;
	}
	public float getAmount() {
		return Amount;
	}
	public void setAmount(float amount) {
		this.Amount = amount;
	}
	
	@Override
    public String toString() {
        return "ParkingEntity =" +
                "SloatNo=" + SloatNo +
                "| DriverName='" + DriverName + '\'' +
                "| carNumber='" + carNumber + '\'' +
                "| inTime=" + inTime +
                "| outTime=" + outTime +
                "|duration=" + Duration +
                "| amount=" + Amount +"|"
                ;
    }
	



	


	
	

	
}