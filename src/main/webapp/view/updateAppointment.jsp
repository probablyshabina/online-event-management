<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
<title>Make Appointment - </title>
</head>
	<body>
		<form action="AppointmentServlet" method="post" style="display:flex; flex-direction:column; width:80%; align-items:center">
			
			Date <input type="date" id ="date" name="date" max="2022-12-31" min="2022-10-31" required>
			Start Time <input type="time" id="StartTime" name="StartTime" min="09:00" max="18:00" value="09:00" required>
			End Time <input type="time" id="Endtime" name="Endtime" min="09:00" max="18:00" value="09:30" required>
			<input type="submit" name="submit" id="submit" value="Change">
		</form>
		
	</body>
</html>