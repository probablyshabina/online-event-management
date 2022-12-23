<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="model.venueAppointment" %>
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
<title>All Venue Appointments</title>

    <link href="css/dashboardcss.css" rel="stylesheet">
    <link href="css/appointmentscss.css" rel="stylesheet">
</head>
<body>
	<div class="containerApp">
		<label class="title">All Venue Appointments</label>
		<div class="venue-appointments">
			<div class="venue-appointments-Table">
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
					<label> Venue In-Charge</label>
					</div>
					 <div class="TableHeader">
					<label> Venue</label>
					</div>
					 <div class="TableHeader">
					<label> Approval Status</label>
					</div>
					 <div class="TableHeader">
					<label> Requested On</label>
					</div>
				</div>
				<form action="AllAppointmentServlet" method="POST" id="eventAppointmentsForm" name="eventAppointmentsForm">
				<%
				List<String> vApps = new ArrayList<>();
				DBFunctions dbApp = new AppointmentDBFuncs("venueAppointments", new venueAppointment());
				pageContext.setAttribute("vApps", vApps); 
				
				int index = 1;
				for(Object ob : dbApp.read()){
					vApps.clear();
					venueAppointment App = (venueAppointment)ob;
					
					vApps.add("" + index + "");
					vApps.add(App.getAppDate());
					vApps.add(App.getAppStartTime());
					vApps.add(App.getAppEndTime());

					vApps.add(App.getOrgName());
					vApps.add(App.getName());
					vApps.add(App.getStatus());
					vApps.add(App.getCreatedDate());
		        %>
				<div class="tableColumnApp" 
						id="<%=App.getAppointmentID()%>" 	
					 	data-id="<%=App.getAppointmentID()%>"
					 	onclick=showAnAppointment(this.id)>
				<c:forEach var = "vApp" items="${vApps}" >
					<div>
					<label class="TableDataLabel"> ${vApp} </label>
					</div>
		      	</c:forEach>
				</div>
				<%
					index++; 
				}
				%>
				<input type="hidden" name="requestSentFrom" value="venueAppointments">
				</form>
				</div>
			</div>
		</div>
	</div>
	<script src="js/appointmentsJs.js"></script>
</body>
</html>