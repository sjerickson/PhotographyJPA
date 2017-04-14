package application;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

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
 * Servlet implementation class insertAppointment
 */
@WebServlet("/insertAppointment")
public class insertAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertAppointment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String actionToPerform = request.getParameter("doThisToItem");
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PhotographyJPA_Erickson");
		
		EntityManager em = emfactory.createEntityManager();
		
		em.getTransaction().begin();
		
	
		if (actionToPerform.equals("ADD")) {
			String customerName = request.getParameter("customerName");
			int sessionType = Integer.parseInt(request.getParameter("sessionType"));
			Date appointmentDate = java.sql.Date.valueOf(request.getParameter("date"));
			String appointmentTime = request.getParameter("time");
			Appointment toAdd = new Appointment(customerName, sessionType, appointmentDate, appointmentTime);
			em.persist(toAdd);
			em.getTransaction().commit();

			getServletContext().getRequestDispatcher("/viewSchedule.jsp").forward(request, response);
		} else if (actionToPerform.equals("Cancel")) {

			getServletContext().getRequestDispatcher("/viewSchedule.jsp").forward(request, response);
		}
		em.close();
		emfactory.close();
	}

}
