package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Appointment;
import util.DBFunctions;
import util.manageCookies;

/**
 * Servlet implementation class AppointmentServlet
 */
@WebServlet("/AppointmentServlet")
public class AppointmentServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
    /**
     * Default constructor. 
     */
    public AppointmentServlet() {
        System.out.println("AppointmentServlet created");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		this.request = request;
		this.response = response;
		
		
		try {
			
			DBFunctions dbc = new DBFunctions("Appointment", new Appointment());
			
			if(request.getParameter("submit").equals("Request")) {
				ifRequest(dbc, "Appointment");
			}
			else if(request.getParameter("submit").contains("Request Change")) {
				manageCookies cookie = manageCookies.getInstance();
				//System.out.println("co - " + cookie.getThisCookieValue("appointmentID"));
				StringBuilder where = new StringBuilder("appointmentID = " + cookie.getThisCookieValue("appointmentID"));
				ifUpdate(dbc, "Appointment", where.toString());
			}
			else {
				
			}
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	//if the user request an appointment
	void ifRequest(DBFunctions dbc, String tablename) throws Exception
	{
		manageCookies cookie = manageCookies.getInstance();
		//unique strings of Appointment
		StringBuilder columns = new StringBuilder("Type,CreatedDate, Status, venueID ");
		StringBuilder values = new StringBuilder("'venue'" + ", curdate() , 'pending', " + cookie.getThisCookieValue("venueID") );
		
		
		for(Entry<String, String[]> entry : request.getParameterMap().entrySet()) {
			if(!(entry.getKey().contains("submit"))) {
				values.append(", '" + entry.getValue()[0] + "' ");
				columns.append(", " + entry.getKey());
			}
		}
		
		//creare db connection class
		dbc = new DBFunctions(tablename, new Appointment());
		try {
			if(dbc.insert(columns.toString(), values.toString())) {
				response.sendRedirect(request.getContextPath() + "/CusDashboard.jsp");	
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	//if the user tries to change the appointment details
	void ifUpdate(DBFunctions dbc, String tablename, String where) throws Exception 
	{
		
		Map<String, String> setValues = new HashMap<String, String>();
		
		for(Entry<String, String[]> entry : request.getParameterMap().entrySet()) {
			if(!(entry.getKey().contains("submit"))) {
				setValues.put(entry.getKey(), entry.getValue()[0]);
			}
		}

		dbc = new DBFunctions(tablename, new Appointment());
		try {
			if(dbc.update(setValues, where)) {
				response.sendRedirect(request.getContextPath() + "/CusDashboard.jsp");	
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}

