package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.AppointmentDBFuncs;
import util.LockAnObject;
import util.VenueDBFunctions;
import util.manageCookies;

/**
 * Servlet implementation class VenueServlet
 */
@WebServlet("/VenueServlet")
public class VenueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VenueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		manageCookies manageCookie = manageCookies.getInstance();
		manageCookie.setRequestResponse(request, response);
		String venueID = manageCookie.getThisCookieValue("venueID");
		String reqFrom = request.getParameter("requestSentFrom");

		VenueDBFunctions dbAppFunc = new VenueDBFunctions("reqFrom");
		
		try {
			manageCookie.getLogin();
			String POV = null;
			if(manageCookie.isCus()) 
				POV = "cus";
			else if(manageCookie.isOrg()) {
				POV = "org";
			}
			else {
				//logout
			}
			Object ob = dbAppFunc.getAppObject(reqFrom, venueID);
			LockAnObject lockthisAppoint = LockAnObject.getInstance();
			lockthisAppoint.setObj(ob);
			lockthisAppoint.setPOV(POV);
			response.sendRedirect(request.getContextPath() + "/createAppointment.jsp");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		doGet(request, response);
	}

}
