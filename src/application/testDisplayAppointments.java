package application;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entities.Appointment;
import entities.Session;

public class testDisplayAppointments {

	public static void main(String[] args) {

				EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PhotographyJPA_Erickson");
				EntityManager em = emfactory.createEntityManager();
				em.getTransaction().begin();

				/*Scanner in = new Scanner(System.in);
				System.out.println("Enter an int: ");
				int selectedSession = Integer.parseInt(in.nextLine());*/
				
				
/*				TypedQuery<Appointment> selectedSessionQuery = em.createQuery("select appt from Appointment appt where appt.id = :selectedSession", Appointment.class);
				selectedSessionQuery.setParameter("selectedSession", selectedSession);
				List<Appointment> results = selectedSessionQuery.getResultList();
				
				for(Appointment a : results){
					System.out.println(a.getCustomerName());
				}*/
				TypedQuery<Appointment> selectedSessionQuery = em.createQuery("select appt from Appointment appt where appt.id = :selectedSession", Appointment.class);
				selectedSessionQuery.setParameter("selectedSession", 2);
				List<Appointment> results = selectedSessionQuery.getResultList();
				for(Appointment a : results){
					System.out.println(a.getCustomerName());
					int sessionInt = a.getSessionType();
					Session found = em.find(Session.class, sessionInt);
					System.out.println(found.getType());
					System.out.println(a.getAppointmentDate());
					System.out.println(a.getAppointmentTime());
				}
				//em.getTransaction().commit();
				em.close();
				emfactory.close();
	}

}
