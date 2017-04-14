<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Styles.css">
<title>Add New Appointment</title>
<%@ page
	import="entities.Appointment,entities.Session,javax.persistence.EntityManager,javax.persistence.EntityManagerFactory,javax.persistence.Persistence,javax.persistence.TypedQuery,java.util.List"%>
</head>
<% 
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PhotographyJPA_Erickson");
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Session> query = em.createQuery("select sessionType from Session sessionType",
				Session.class);
		List<Session> results = query.getResultList();
		%>
<body>
	<div id="newAppointmentForm">
		<form method="post" action="insertAppointment">
			<label for="customerName">Customer Name</label> <input type="text"
				name="customerName" id="customerName"><br/> <label for="sessionType">Session Type</label>
			<select name = "sessionType" id="sessionType">
			<%
			int index = 0;
			for (Session a : results){ 
				String optionValue = a.getType();
				index++;
				%>
			<option value=<%=index%> > <%=optionValue %></option>
			
			<%} %>
			</select><br/> 
			<label for="date">Date</label> <input type="date" name="date"
				id="date"><br/> <label for="time">Time</label> <input
				type="text" name="time" id="time">

			<div class="center">
				<input class="button" type="submit" name="doThisToItem" value="ADD">
				<input class="button" type="submit" name="doThisToItem"
					value="Cancel">
			</div>
		</form>
	</div>
</body>
</html>