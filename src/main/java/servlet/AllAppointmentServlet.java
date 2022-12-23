package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.AppointmentDBFuncs;
import util.LockAnObject;
import util.manageCookies;

/**
 * Servlet implementation class AllAppointmentServlet
 */
@WebServlet("/AllAppointmentServlet")
public class AllAppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AllAppointmentServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		manageCookies manageCookie = manageCookies.getInstance();
		manageCookie.setRequestResponse(request, response);
		String appointmentID = manageCookie.getThisCookieValue("appointmentID");
		String reqFrom = request.getParameter("requestSentFrom");

		AppointmentDBFuncs dbAppFunc = new AppointmentDBFuncs("reqFrom");
		
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
			Object ob = dbAppFunc.getAppObject(reqFrom, appointmentID);
			LockAnObject lockthisAppoint = LockAnObject.getInstance();
			lockthisAppoint.setObj(ob);
			lockthisAppoint.setPOV(POV);
			
			response.sendRedirect(request.getContextPath() + "/anAppointment.jsp");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		doGet(request, response);
	}

}
