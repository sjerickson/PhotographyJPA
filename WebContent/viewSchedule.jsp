<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Styles.css">
<title>Appointments</title>
<%@ page
	import="entities.Appointment,entities.Session,javax.persistence.EntityManager,javax.persistence.EntityManagerFactory,javax.persistence.Persistence,javax.persistence.TypedQuery,java.util.List"%>
</head>
<body>
	<%
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PhotographyJPA_Erickson");
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Appointment> selectedSessionQuery = em.createQuery("select appt from Appointment appt",
				Appointment.class);
		List<Appointment> results = selectedSessionQuery.getResultList();
	%>
	<table>
		<tr>
			<th>Customer Name</th>
			<th>Session Type</th>
			<th>Date</th>
			<th>Time</th>
			<th>Update</th>
			<th>Cancel</th>
		</tr>
		<%
			for (Appointment a : results) {
				int sessionInt = a.getSessionType();
				Session sessionID = em.find(Session.class, sessionInt);
				System.out.println(a.getAppointmentTime());
		%>

		<tr>
			<td><%=a.getCustomerName()%></td>
			<td><%=sessionID.getType()%></td>
			<td><%=a.getAppointmentDate()%></td>
			<td><%=a.getAppointmentTime()%></td>
			<td><form method="get" action="updateAppointment">
					<input type="hidden" value=<%=a.getID()%> name="appointmentToUpdate" />
					<input type="submit" class="updateButton" value="Update" /> 
				</form>
			</td>
			<td style="padding: 0; text-align: center;">
				<form method="post" action="deleteAppointment">
					<input type="hidden" value=<%=a.getID()%>
						name="appointmentToDelete"/>
					<input type="submit" id="deleteButton" value="X"/>
				</form></td>
		</tr>

		<%
			}
			em.close();
			emfactory.close();
		%>
	</table>
	<div class="center">
		<form method="post" action="addAppointment">
			<input type="submit" class="button" value="Add New Appointment">
		</form>
	</div>
</body>
</html>