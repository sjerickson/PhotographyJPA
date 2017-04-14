package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sessions")
public class Session {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="TYPE")
	private String type;
	@Column(name="PRICEPERHOUR")
	private int pricePerHour;
	@Column(name="AVGTIMEHOURS")
	private double avgTimeHours;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPricePerHour() {
		return pricePerHour;
	}
	public void setPricePerHour(int pricePerHour) {
		this.pricePerHour = pricePerHour;
	}
	public double getAvgTimeHours() {
		return avgTimeHours;
	}
	public void setAvgTimeHours(double avgTimeHours) {
		this.avgTimeHours = avgTimeHours;
	}
	
}
