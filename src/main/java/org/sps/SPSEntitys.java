package org.sps;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SPSEntitys {
	@Id
	private int sloatNo;
	private String Name;
	private String carNumber;
	private int Duration;
	private int amount;
	
	public int getSloatNo() {
		return sloatNo;
	}
	public void setSloatNo(int sloatNo) {
		this.sloatNo = sloatNo;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public int getDuration() {
		return Duration;
	}
	public void setDuration(int duration) {
		Duration = duration;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

	
	


	
	
	
}
