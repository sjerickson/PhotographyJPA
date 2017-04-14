<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Appointment</title>
<link rel="stylesheet" type="text/css" href="Styles.css">
</head>
<%@ page
	import="entities.Appointment,entities.Session,javax.persistence.EntityManager,javax.persistence.EntityManagerFactory,javax.persistence.Persistence,javax.persistence.TypedQuery,java.util.List,java.sql.Date,java.sql.Time"%>
<body>
<% 
int apptID = (Integer)request.getAttribute("apptID");
//int apptIDint = Integer.parseInt(apptID);
EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PhotographyJPA_Erickson");
EntityManager em = emfactory.createEntityManager();
em.getTransaction().begin();
TypedQuery<Session> query = em.createQuery("select sessionType from Session sessionType",
		Session.class);
List<Session> results = query.getResultList();
Appointment apptToUpdate = em.find(Appointment.class, apptID);
String tempCustomer = apptToUpdate.getCustomerName();
int tempSessionType = apptToUpdate.getSessionType();
Date tempDate = apptToUpdate.getAppointmentDate();
Time tempTime = apptToUpdate.getAppointmentTime();
/* String tempCustomer = (String)request.getAttribute("oldName"); 
String tempSessionType = (String)request.getAttribute("oldSessionType");
int sessionTypeInt = Integer.parseInt(tempSessionType);
String tempDate = (String)request.getAttribute("oldDate");
String tempTime = (String)request.getAttribute("oldTime"); */


%>
<div id="updateAppointmentForm">
<form action = "updateAppointment" method = "post">
<label for="newName">Customer Name</label><input type = "text" name = "newName" value = "<%=tempCustomer%>"><br/>
<label for="newSessionType">Session Type</label> 
<select name = "newSessionType" id="sessionType">
			<%
			int index = 0;
			for (Session a : results){ 
				String optionValue = a.getType();
				index++;
				%>
			<option value=<%=index%> <%if (index == tempSessionType){ %> selected = "selected"<%} %> > <%=optionValue %></option>
			
			<%} %>
			</select>

<br/>
<label for="newDate">Date</label><input type = "text" name = "newDate" value = "<%=tempDate%>"><br/>
<label for="newTime">Time</label><input type = "text" name = "newTime" value = "<%=tempTime%>"><br/>
<input type = "submit" class="button" value = "Save Changes">

<input type = "hidden" name="apptID" value = "<%=apptID%>">
</form>
</div>
</body>
</html>