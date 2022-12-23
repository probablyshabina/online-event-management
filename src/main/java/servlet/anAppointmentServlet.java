package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Appointment;
import util.DBFunctions;
import util.LockAnObject;
import util.manageCookies;

/**
 * Servlet implementation class anAppointmentServlet
 */
@WebServlet("/anAppointmentServlet")
public class anAppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public anAppointmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		manageCookies cookie = manageCookies.getInstance();
		try {
			Appointment app = (Appointment) LockAnObject.getObj();
			cookie.setCookie("appointmentID", app.getAppointmentID());

			if(request.getParameter("submit").equalsIgnoreCase("Request Change")) {
				
				response.sendRedirect(request.getContextPath() + "/updateAppointment.jsp");	
			}
			else if(request.getParameter("submit").equalsIgnoreCase("Accept")) {

				response.sendRedirect(request.getContextPath() + "/CusDashboard.jsp");	
			}
			else if(request.getParameter("submit").equalsIgnoreCase("Deny")) {

				response.sendRedirect(request.getContextPath() + "/CusDashboard.jsp");	
			}
			else if(request.getParameter("submit").equalsIgnoreCase("Cancel")) {

				StringBuilder where = new StringBuilder("appointmentID = " + cookie.getThisCookieValue("appointmentID"));
				DBFunctions dbc = new DBFunctions("Appointment", new Appointment());
				if(dbc.delete(where.toString())) {
						response.sendRedirect(request.getContextPath() + "/CusDashboard.jsp");
				}
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
