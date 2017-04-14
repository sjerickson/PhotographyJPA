package entities;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="appointments")

public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="CUSTOMERNAME")
	private String customerName;
	@Column(name="SESSIONTYPE")
	private int SessionType;
	@Column(name="DATE")
	private Date appointmentDate;
	@Column(name="TIME")
	private Time appointmentTime;
	
	public Appointment() {
		super();
	}
	public Appointment(String customerName, int sessionType, Date appointmentDate, String appointmentTime) {
		this.customerName = customerName;
		this.SessionType = sessionType;
		this.appointmentDate = appointmentDate;
		this.appointmentTime = java.sql.Time.valueOf(appointmentTime);
	}
	public int getID() {
		return id;
	}
	public void setID(int id) {
		id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getSessionType() {
		return SessionType;
	}
	public void setSessionType(int sessionType) {
		SessionType = sessionType;
	}
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public Time getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(Time appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
}
