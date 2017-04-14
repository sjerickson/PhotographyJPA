package application;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Appointment;

/**
 * Servlet implementation class updateAppointment
 */
@WebServlet("/updateAppointment")
public class updateAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateAppointment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int apptToUpdate = Integer.parseInt(request.getParameter("appointmentToUpdate"));
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PhotographyJPA_Erickson");
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Appointment originalAppt = em.find(Appointment.class, apptToUpdate);
		System.out.println("Index of appt to update is: "+apptToUpdate);
/*		request.setAttribute("oldName", originalAppt.getCustomerName());
		request.setAttribute("oldSessionType", originalAppt.getSessionType());
		request.setAttribute("oldDate", originalAppt.getAppointmentDate());
		request.setAttribute("oldTime", originalAppt.getAppointmentTime());*/
		request.setAttribute("apptID", originalAppt.getID());
		em.close();
		emfactory.close();
		getServletContext().getRequestDispatcher("/updateAppointment.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String apptID = request.getParameter("apptID");
		int apptIDint = Integer.parseInt(apptID);
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PhotographyJPA_Erickson");
		EntityManager em = emfactory.createEntityManager();
		Appointment apptToUpdate = em.find(Appointment.class, apptIDint);
		em.getTransaction().begin();		
		
		String newName = request.getParameter("newName");
		int newSessionType = Integer.parseInt(request.getParameter("newSessionType"));
		//int sessionTypeInt = Integer.parseInt(newSessionType);
		String newDate = request.getParameter("newDate");
		Date appointmentDate = java.sql.Date.valueOf(newDate);
		String newTime = request.getParameter("newTime");
		Time appointmentTime = java.sql.Time.valueOf(newTime);
		apptToUpdate.setSessionType(newSessionType);
		apptToUpdate.setCustomerName(newName);
		apptToUpdate.setAppointmentDate(appointmentDate);
		apptToUpdate.setAppointmentTime(appointmentTime);
		em.getTransaction().commit();
		em.close();
		emfactory.close();
		getServletContext().getRequestDispatcher("/viewSchedule.jsp").forward(request, response);
	}

}
