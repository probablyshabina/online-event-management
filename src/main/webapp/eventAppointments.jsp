<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="model.eventAppointment" %>
<%@page import="model.Event" %>
<%@page import="model.cusDash_vApp" %>
<%@page import="util.DBFunctions" %>
<%@page import="util.AppointmentDBFuncs" %>
<%@page import="java.lang.reflect.Method" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.lang.String" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Event Appointments</title>

    <link href="css/dashboardcss.css" rel="stylesheet">
    <link href="css/appointmentscss.css" rel="stylesheet">
</head>
<body>
		<div class="containerApp">
			<label class="title">All Event Appointments</label>
			<div class="event-appointments">
			<div class="event-appointments-Table">
				<div class="tableRow">
				<div class="TableColumnHead">
					<div class="TableHeader">
					<label> No.</label>
					</div>
					 <div class="TableHeader">
					<label> Date</label>
					</div>
					 <div class="TableHeader">
					<label> Starting Time</label>
					</div>
					 <div class="TableHeader">
					<label> Ending Time</label>
					</div>
					 <div class="TableHeader">
					<label> Event Date</label>
					</div>
					 <div class="TableHeader">
					<label> Event Start Time</label>
					</div>
					 <div class="TableHeader">
					<label> Event End Time</label>
					</div>
					 <div class="TableHeader">
					<label>Venue</label>
					</div>
					 <div class="TableHeader">
					<label> Approval Status</label>
					</div>
					 <div class="TableHeader">
					<label> Requested on</label>
					</div>
				</div>
				
				<form action="AllAppointmentServlet" method="POST" id="eventAppointmentsForm" name="eventAppointmentsForm">
				<%
				List<String> eApps = new ArrayList<>();
				DBFunctions dbApp = new AppointmentDBFuncs("eventAppointments", new eventAppointment());
				pageContext.setAttribute("eApps", eApps); 
				
				int index = 1;
				for(Object ob : dbApp.read()){
					eApps.clear();
					eventAppointment App = (eventAppointment)ob;
					
					eApps.add("" + index + "");
					eApps.add(App.getAppDate());
					eApps.add(App.getAppStartTime());
					eApps.add(App.getAppEndTime());

					eApps.add(App.getEventDate());
					eApps.add(App.getEventstartTime());
					eApps.add(App.getEventEndTime());
					eApps.add(App.getVenueName());
					eApps.add(App.getStatus());
					eApps.add(App.getCreatedDate());
					
		        %>
				<div class="tableColumnApp"
					 id="<%=App.getAppointmentID()%>"
					 data-id="<%=App.getAppointmentID()%>"
					 onclick=showAnAppointment(this.id)>
				<c:forEach var = "eApp" items="${eApps}" >
					<div>
					<label class="TableDataLabel"> ${eApp} </label>
					</div>
		      	</c:forEach>
				</div>
				<%
					index++; 
				}
				%>
				<input type="hidden" name="requestSentFrom" value="eventAppointments">
				</form>
				</div>
			</div>
			</div>
		</div>
		<script src="js/appointmentsJs.js"></script>
</body>
</html>