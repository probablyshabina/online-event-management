package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DBFunctionsClass {

	
	public boolean insert(String Columns, String values, String tableName) throws Exception {
		Connection con = DBConnect_SH.getConnection();
		String sql = "INSERT INTO "+ tableName + "(" + Columns + ") VALUES(" +values +")";
  	  	
		try {
			Statement st;
			st = con.createStatement();
			
			if(st.executeUpdate(sql) > 0) {
				JOptionPane.showMessageDialog(new JFrame(),"successfully inserted");
				return true;
			}
			else {
				JOptionPane.showMessageDialog(new JFrame(),"Insertion failed");
				System.out.println(sql);
				return false;
			}
	  	  	
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(sql);
			return false;
		}
	}

	
	public boolean update(Map<String, String> updateValues, String tableName, String updateWhere) throws Exception {
		Connection con = DBConnect_SH.getConnection();

		StringBuilder sql = new StringBuilder("UPDATE " + tableName +" SET ");

		for(Entry<String, String> entry : updateValues.entrySet()) {
			sql.append(" " + entry.getKey() + " = " + "'" + entry.getValue() + "',");
		}
		sql.deleteCharAt((sql.length() -1));
		sql.append(" WHERE " + updateWhere);
		
		try {
			Statement st = con.createStatement();
			if(st.executeUpdate(sql.toString()) > 0) {
				JOptionPane.showMessageDialog(new JFrame(),"successfully inserted");
				return true;
			}
			else {
				JOptionPane.showMessageDialog(new JFrame(),"Insertion failed");
				System.out.println(sql);
				return false;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(sql);
			return false;
		}
	}
	
	public boolean delete(String tableName, String updateWhere) {
		Connection con = DBConnect_SH.getConnection();
		StringBuilder sql = new StringBuilder("DELETE from ");
		sql.append(tableName + " WHERE ");
		sql.append(updateWhere);
		
		try {
			Statement st = con.createStatement();
			if(st.executeUpdate(sql.toString()) > 0) {
				JOptionPane.showMessageDialog(new JFrame(),"successfully inserted");
				return true;
			}
			else {
				JOptionPane.showMessageDialog(new JFrame(),"Insertion failed");
				System.out.println(sql);
				return false;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(sql);
			return false;
		}
	}


}
