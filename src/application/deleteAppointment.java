package application;

import java.io.IOException;

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
 * Servlet implementation class deleteAppointment
 */
@WebServlet("/deleteAppointment")
public class deleteAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteAppointment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PhotographyJPA_Erickson");
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		int sessionTypeIndex = Integer.parseInt(request.getParameter("appointmentToDelete"));
		Appointment toRemove = em.find(Appointment.class, sessionTypeIndex);
		em.remove(toRemove);
		em.getTransaction().commit();
		em.close();
		emfactory.close();
		getServletContext().getRequestDispatcher("/viewSchedule.jsp").forward(request, response);
	}

}
