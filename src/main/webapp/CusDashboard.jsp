<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="model.CusDash_events" %>
<%@page import="model.cusDash_eApp" %>
<%@page import="model.cusDash_vApp" %>
<%@page import="model.Customer" %>
<%@page import="util.DBFunctions" %>
<%@page import="util.DashboardDBFuncs" %>
<%@page import="util.LockAnObject" %>
<%@page import="util.DBConnect_SH" %>
<%@page import="java.lang.reflect.Method" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.TreeMap" %>
<%@page import="java.util.TreeMap" %>
<%@page import="java.util.Map" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.Statement" %>
<%@page import="java.lang.String" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Customer Dashboard</title>

    <link href="css/dashboardcss.css" rel="stylesheet">

    <link href="css/maincss.css" rel="stylesheet">

    <link href="css/bootstrap-icons.css" rel="stylesheet">

    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
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
<%
	LockAnObject loggedCustomer = LockAnObject.getInstance();
	Connection conn = DBConnect_SH.getConnection();
	Statement st = conn.createStatement();
	ResultSet rs = st.executeQuery("SELECT * FROM Customer WHERE cusID = 2000");
	
	DBFunctions dbFunc = new DBFunctions("Customer", rs, new Customer());
	String name = "hhello";
	String address = "hhello";
	String img = "hhello";
	while(rs.next()){
		name = rs.getString("name");
		address = rs.getString("address");
		img = rs.getString("image");
	}
	
	//System.out.println(name + "-"+address+"-"+img);
	pageContext.setAttribute("name", name); 
	pageContext.setAttribute("address", address); 
	pageContext.setAttribute("img", img); 
	
%>

<div class="container">
<div class="Left-Menu">
	    <div class="manage-events">
	    	<img src="images/manage-events.png">
	    	<!-- <a href="https://storyset.com/event">Event illustrations by Storyset</a> -->
	    	<p>Manage Events</p>
	    </div>
	    <div class="manage-appointments" onclick=managevAppointments()>
	    	<img src="images/manage-appointments.png" class="Left-Menu-img">
	    	<!-- <a href="https://storyset.com/people">People illustrations by Storyset</a> -->
	    	<p>Manage Venue Appointments</p>
	    </div>
	    <div class="manage-appointments" onclick=manageeAppointments()>
	    	<img src="images/manage-appointments.png" class="Left-Menu-img">
	    	<!-- <a href="https://storyset.com/people">People illustrations by Storyset</a> -->
	    	<p>Manage Event Appointments</p>
	    </div>
	</div>
  
  	
<div class="Main-Block-Menu">
	<div class="Profile">
  		
	    <div class="Picture">
	    	<img src="${img} class="Picture-img"> 
	    </div>
	 
	    <div class="profile-details-main">
	    <div class="profile-details">
	    	<label>${name}</label>
	    	<label>${address}</label>
	    </div>
	    </div>
	    
	    
	    <div class="Edit-profile">
	    	<button class="dashboard-button">Edit Profile</button>
	    </div>
	    <div class="Edit-profile">
	    	<button class="dashboard-button">Logout</button>
	    </div>
	    
  	</div>
	<div class="Main-block">
		<div class="events">
			<label>Upcoming Events</label>
			<div class="mainBlockTable">
				<div class="tableRow">
				<div class="TableColumnHead">	
					<div>
					<label class="TableHeaderLabel"> No. </label>
					</div>
					<div>
					<label class="TableHeaderLabel"> Type </label>
					</div>
					<div>
					<label class="TableHeaderLabel"> Venue</label>
					</div>
					<div>
					<label class="TableHeaderLabel"> Date </label>
					</div>
					<div>
					<label class="TableHeaderLabel"> Start Time</label>
					</div>
					<div>
					<label class="TableHeaderLabel"> End Time</label>
					</div>
					<div>
					<label class="TableHeaderLabel"> Approval Status</label>
					</div>
				</div>	
				<%
				List<String> events = new ArrayList<>();
				DBFunctions dbdash = new DashboardDBFuncs(new CusDash_events());
				pageContext.setAttribute("events", events); 
				
				int index = 1;
				for(Object ob : dbdash.setView("events")){
					events.clear();
					CusDash_events cusDashOb = (CusDash_events)ob;
					events.add("" + index + "");
					events.add(cusDashOb.getType());
					events.add(cusDashOb.getName());
					events.add(cusDashOb.getDate());
					events.add(cusDashOb.getStartTime());
					events.add(cusDashOb.getEndTime());
					events.add(cusDashOb.getApproval());
		        %>
		        <div class="tableColumn">
				<c:forEach var = "event" items="${events}" >
					<div>
					<label class="TableDataLabel"> ${event} </label>
					</div>
		      	</c:forEach>
				</div>
				<%
					index++; 
				}
				%>
				</div>
			</div>
		</div>
		
		<div class="venue-appointments">
			<label>Venue Appointments Status</label>
			<div class="venue-appointments-Table">
				<div class="tableRow">
				<div class="TableColumnHead">
					 <div class="TableHeader">
					<label  > No.</label>
					</div>
					 <div class="TableHeader">
					<label  > Date</label>
					</div>
					 <div class="TableHeader">
					<label  > Starting Time</label>
					</div>
					 <div class="TableHeader">
					<label  > Ending Time</label>
					</div>
					 <div class="TableHeader">
					<label  > Venue In-Charge</label>
					</div>
					 <div class="TableHeader">
					<label  > Venue</label>
					</div>
					 <div class="TableHeader">
					<label  > Approval Status</label>
					</div>
				</div>
				<%
				List<String> vApps = new ArrayList<>();
				dbdash.setObject(new cusDash_vApp());
				pageContext.setAttribute("vApps", vApps); 
				
				index = 1;
				for(Object ob : dbdash.setView("vApps")){
					vApps.clear();
					cusDash_vApp vApp = (cusDash_vApp)ob;
					vApps.add("" + index + "");
					vApps.add(vApp.getDate());
					vApps.add(vApp.getStartTime());
					vApps.add(vApp.getEndTime());
					vApps.add(vApp.getOrgName());
					vApps.add(vApp.getName());
					vApps.add(vApp.getStatus());
		        %>
				<div class="tableColumn">
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
				</div>
			</div>
		</div>
		
		<div class="event-appointments">
			<label>Event Appointments Status</label>
			<div class="event-appointments-Table">
				<div class="tableRow">
				<div class="TableColumnHead">
					<div class="TableHeader">
					<label > No.</label>
					</div>
					<div class="TableHeader">
					<label > Date</label>
					</div>
					<div class="TableHeader">
					<label > Starting Time</label>
					</div>
					<div class="TableHeader">
					<label > Ending Time</label>
					</div>
					<div class="TableHeader">
					<label > Event Date</label>
					</div>
					<div class="TableHeader">
					<label > Venue</label>
					</div>
					<div class="TableHeader">
					<label > Approval Status</label>
					</div>
				</div>
				<%
				List<String> eApps = new ArrayList<>();
				dbdash.setObject(new cusDash_eApp());
				pageContext.setAttribute("eApps", eApps); 
				
				index = 1;
				for(Object ob : dbdash.setView("eApps")){
					eApps.clear();
					cusDash_eApp eApp = (cusDash_eApp)ob;
					eApps.add("" + index + "");
					eApps.add(eApp.getaDate());
					eApps.add(eApp.getaStartTime());
					eApps.add(eApp.getaEndTime());
					eApps.add(eApp.geteDate());
					eApps.add(eApp.getvName());
					eApps.add(eApp.getStatus());
		        %>
				<div class="tableColumn">
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
				</div>
			</div>
		</div>
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
<script src="js/dashboardjs.js"></script>
        </footer>
</body>
</html>