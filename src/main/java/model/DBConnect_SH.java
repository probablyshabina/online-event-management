package model;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DBConnect_SH {
	private static Connection con = null;
	
	public DBConnect_SH() {
		
	}
	
	public static Connection getConnection(){
		final String url = "jdbc:mysql://localhost:3306/planeezy";
		final String user = "root";
	    final String password = "happyFamily@123";

	    try {
	    	Class.forName("com.mysql.jdbc.Driver");
	        con = DriverManager.getConnection(url, user, password);
	          
	        System.out.println("Congratulations, JDBC connection is established successfully.\n");
	        
	    } catch(Exception ex) {
	    	 JOptionPane.showMessageDialog(new JFrame(),"Unable to connect to database!","Alert",JOptionPane.WARNING_MESSAGE);  
	    }
		return con;
	}

}
