package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import model.Organizer;

public class manageCookies {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private int organizerID = -1;
	private int customerID = -1;
	private boolean cus = false;
	private boolean org = false;
	static char whoLogged;
	static Customer customer = null;
	static Organizer organizer = null;
	private static manageCookies thisManageCookieObj;

	public void resetValues(){
		request = null;
		response = null;
		organizerID = -1;
		customerID = -1;
		cus = false;
		org = false;
		customer = null;
		organizer = null;
		thisManageCookieObj = null;
	}
	
	public static synchronized manageCookies getInstance() {
		if (thisManageCookieObj == null)
			 thisManageCookieObj = new manageCookies();
	        return thisManageCookieObj;
	}
	
	private manageCookies() {
		resetValues();
	}
	
	public void setRequestResponse(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}
	
	public String getThisCookieValue(String cookieName) {
		String value = null;
		if (request.getCookies() != null) {
     		Cookie[] cookies = request.getCookies();
     		for (Cookie cookie : cookies) {
     			if(cookie.getName().equalsIgnoreCase(cookieName)) {
     				value = cookie.getValue();
     				System.out.println("cookie - " + value);
     			}
     		}
		}
		return value;
	}

	public void setCookie(String cookieName, String cookieValue) {
		Cookie cookie = new Cookie(cookieName, cookieValue);
	    cookie.setMaxAge(86400 * 30 * 30);
	    System.out.println("cookie - " + cookieValue);
		response.addCookie(cookie);
	}
	
	public void getLogin() throws Exception{
		//get who logged in info from the cookie
      	if (request.getCookies() != null) {
      		 Cookie[] cookies = request.getCookies();
      		for (Cookie cookie : cookies) {
   				if (cookie.getName().equals("whologged")) {  
   					if(cookie.getValue().toLowerCase().contains("c")) {
   						cus = true;
   						org = false;
   						whoLogged = 'c';
   						break;
   					}
   					else if(cookie.getValue().toLowerCase().contains("o")) {
   						cus = false;
						org = true;
						whoLogged = 'o';
						break;
   					}//end if
      		    }//end if
      		}//end for
      		
      		//get log in id from the cookie
      		for (Cookie cookie : cookies) {
   				if (cookie.getName().equalsIgnoreCase("loginId")) {  
   					if(cus) {
   						customerID = Integer.parseInt(cookie.getValue());
						findCustomer();
   						break;
   					}
   					else if(org) {
   						organizerID = Integer.parseInt(cookie.getValue());
						findOrganizer();
						break;
   					}	
      		    }//end if
      		}//end for
      	}//end if
    }
	
	private void findCustomer(){
		Connection conn = DBConnect_SH.getConnection();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Customer WHERE cusID = " + customerID);
			
			DBFunctions dbFunc = new DBFunctions("Customer", rs, new Customer());
			customer = (Customer)dbFunc.readSingleRecord();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void findOrganizer(){
		Connection conn = DBConnect_SH.getConnection();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Organizer WHERE organizerID = " + organizerID);
			
			DBFunctions dbFunc = new DBFunctions("Organizer", rs, new Organizer());
			organizer = (Organizer)dbFunc.readSingleRecord();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	public int getOrganizerID() {
		return organizerID;
	}

	public void setOrganizerID(int organizerID) {
		this.organizerID = organizerID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public boolean isCus() {
		return cus;
	}

	public void setCus(boolean cus) {
		this.cus = cus;
	}

	public boolean isOrg() {
		return org;
	}

	public void setOrg(boolean org) {
		this.org = org;
	}
}
