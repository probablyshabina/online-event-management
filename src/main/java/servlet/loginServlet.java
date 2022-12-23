package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBConnect_SH;
import util.manageCookies;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		manageCookies mngCook = manageCookies.getInstance();
		mngCook.setRequestResponse(request, response);
		Connection conn = DBConnect_SH.getConnection();
		try {
			Statement st = conn.createStatement();
			String sql = "SELECT * FROM account WHERE uuname = '" + request.getParameter("uname") + "' AND pwd = '" + request.getParameter("pwd")+"'";
			ResultSet rs = st.executeQuery(sql);
			
			String id = "", type = ""; 
			while(rs.next()){
				id = rs.getString("id");
				type = rs.getString("type");
			}
			
			mngCook.setCookie("whologged", type);
			mngCook.setCookie("loginId", id);
			
			if(type.equals("cus"))
				response.sendRedirect(request.getContextPath() + "/CusDashboard.jsp");
			else if(type.equals("org"))
				response.sendRedirect(request.getContextPath() + "/orgDashboard.jsp");

			
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
