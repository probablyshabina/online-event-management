<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@page import="java.time.LocalDateTime"%>
	<%@page import="java.time.format.DateTimeFormatter" %>
	<meta charset="UTF-8">
<title>Make Appointment - </title>
</head>
	<body>
		<form action="AppointmentServlet" method="post" style="display:flex; flex-direction:column; width:80%; align-items:center">
			<%  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
			   LocalDateTime now = LocalDateTime.now();  
			   System.out.println(dtf.format(now));   %>
			   
			Date <input type="date" id ="date" name="date" max="2022-12-31" 
					min="<%=now%>" required>
			Start Time <input type="time" id="StartTime" name="StartTime" min="09:00" max="18:00" value="09:00" required>
			End Time <input type="time" id="Endtime" name="Endtime" min="09:00" max="18:00" value="09:30" required>
			<input type="submit" name="submit" id="submit" value="Request">
		</form>
		
	</body>
</html>