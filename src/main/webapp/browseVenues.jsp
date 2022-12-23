<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@page import="util.DBConnect_SH" %>
<%@page import="util.DBFunctions" %>
<%@page import="model.eventAppointment" %>
<%@page import="model.venueAppointment" %>
<%@page import="model.venue" %>
<%@page import="util.manageCookies" %>
<%@page import="util.AppointmentDBFuncs" %>

<%@page import="util.LockAnObject" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.TreeMap" %>
<%@page import="java.util.Map" %>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement" %>
	<%@page import="java.time.LocalDateTime"%>
	<%@page import="java.time.format.DateTimeFormatter" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Venue</title>

    <link href="css/dashboardcss.css" rel="stylesheet">

    <link href="css/appointmentcss.css" rel="stylesheet">

    <link href="css/anAppointmentcss.css" rel="stylesheet">

    <link href="css/maincss.css" rel="stylesheet">

    <link href="css/bootstrap-icons.css" rel="stylesheet">

    <link href="css/bootstrap.min.css" rel="stylesheet">

    <link href="css/venuecss.css" rel="stylesheet">
</head>
<body>
</body>
		<nav class="navbar navbar-expand-lg bg-light shadow-lg">
            <div class="container">
                <a class="navbar-brand" href="home.jsp">
                    <img src="images/logo.png" class="logo img-fluid">
                    <span> Planeezy
                        <small>Event Management</small>
                    </span>
                </a>

                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item">
                            <a class="nav-link " href="home.jsp">Home</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link " href="browsePackages.jsp">Packages</a>
                        </li>

                        <li class="nav-item dropdown">
                             <a class="nav-link " href="browseVenues.jsp">Venues</a>
                        </li>
						<li class="nav-item ms-3">
							<a class="nav-link custom-btn custom-border-btn btn" href="orgDashboard.jsp">Dashboard</a>
						</li>	
									
                    </ul>
                </div>
            </div>
        </nav>

	<div class="containerVen">
	<label class= "title">Venues</label>
		<div class="venue-appointments">
			<div class="venue-appointments-Table">
				<div class="tableRow">
				<div class="TableColumnHead">
					<div class="TableHeader">
					<label> No.</label>
					</div>
					 <div class="TableHeader">
					<label> Venue In-Charge</label>
					</div>
					 <div class="TableHeader">
					<label> Venue</label>
					</div>
					 <div class="TableHeader">
					<label>Location </label>
					</div>
					</div>
				</div>
				<form action="VenueServlet" method="POST" id="venuesForm" name="eventAppointmentsForm">
				<%
				List<String> vApps = new ArrayList<>();
				DBFunctions dbApp = new DBFunctions("venue", new venue());
				pageContext.setAttribute("vApps", vApps); 
				int index = 1;
				for(Object ob : dbApp.read()){
					vApps.clear();
					venue App = (venue)ob;
					
					vApps.add("" + index + "");
					vApps.add(App.getOwner());
					vApps.add(App.getName());
					vApps.add(App.getLocation());
		        %>
				<div class="tableColumnVen" 
						id="<%=App.getVenueID()%>" 	
					 	data-id="<%=App.getVenueID()%>"
					 	onclick=showAnVenue(this.id)>
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
				<input type="hidden" name="requestSentFrom" value="venue">
				</form>
				</div>
			</div>
		</div>
			
 		<footer class="site-footer">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3 col-12 mb-4">
                        <img src="view/images/logo1.png" class="logo img-fluid" alt="">
                    </div>

                    <div class="col-lg-4 col-md-6 col-12 mb-4">
                        <h5 class="site-footer-title mb-3">Quick Links</h5>

                        <ul class="footer-menu">
                            <li class="footer-menu-item"><a href="#" class="footer-menu-link">Home</a></li>

                            <li class="footer-menu-item"><a href="#" class="footer-menu-link">Venues</a></li>

                            <li class="footer-menu-item"><a href="#" class="footer-menu-link">Services</a></li>

                            <li class="footer-menu-item"><a href="#" class="footer-menu-link">Register Your Venue</a></li>

                            <li class="footer-menu-item"><a href="#" class="footer-menu-link">Register Your Service</a></li>
                        </ul>
                    </div>

                    <div class="col-lg-4 col-md-6 col-12 mx-auto">
                        <h5 class="site-footer-title mb-3">Contact Infomation</h5>

                        <p class="text-white d-flex mb-2">
                            <i class="bi-telephone me-2"></i>

                            <a href="tel: +94 77 112 2334" class="site-footer-link">
                                +94 77 112 2334
                            </a>
                        </p>

                        <p class="text-white d-flex">
                            <i class="bi-envelope me-2"></i>

                            <a href="mailto:info@yplaneezy.com.com" class="site-footer-link">
                                info@planeezy.com
                            </a>
                        </p>

                    </div>
                </div>
            </div>
            <script src="js/venuejs.js"></script>
        </footer>

</html>