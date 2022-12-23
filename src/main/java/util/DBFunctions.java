package util;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DBFunctions {

	String tableName;
	ResultSet resultSet;
	Object ob = null;
	
	public List<Object> setView(String view) throws Exception{
		return new ArrayList<Object>();
	}
	
	protected DBFunctions(){
		this.tableName = null;
		this.resultSet = null;
	}
	
	public DBFunctions(Object ob){
		this.ob = ob;
	}
	
	public DBFunctions(String tableName, Object ob){
		System.out.println("DBFunctions");
		this.tableName = tableName;
		this.ob = ob;
	}
	
	public DBFunctions(String tableName, ResultSet rs, Object ob){
		this.tableName = tableName;
		this.ob = ob;
	}
	
	public void setObject(Object ob) {
		this.ob = ob;
	}
	
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	public void setResultSet(ResultSet rs) {
		this.resultSet = rs;
	}
	
	public boolean insert(String Columns, String values) throws Exception {
		Connection con = DBConnect_SH.getConnection();
		String sql = "INSERT INTO "+ tableName + "(" + Columns + ") VALUES(" +values +")";
		System.out.println(sql);
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

	
	public boolean update(Map<String, String> updateValues, String updateWhere) throws Exception {
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
				JOptionPane.showMessageDialog(new JFrame(),"successfully updated");
				return true;
			}
			else {
				JOptionPane.showMessageDialog(new JFrame(),"Update failed");
				System.out.println(sql);
				return false;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(sql);
			return false;
		}
	}
	
	public boolean delete(String deleteWhere) {
		Connection con = DBConnect_SH.getConnection();
		StringBuilder sql = new StringBuilder("DELETE from ");
		sql.append(tableName + " WHERE ");
		sql.append(deleteWhere);
		
		try {
			Statement st = con.createStatement();
			if(st.executeUpdate(sql.toString()) > 0) {
				JOptionPane.showMessageDialog(new JFrame(),"successfully cancelled");
				return true;
			}
			else {
				JOptionPane.showMessageDialog(new JFrame(),"Canxcellation failed");
				System.out.println(sql);
				return false;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(sql);
			return false;
		}
	}
	
	public List<Object> read() throws Exception{
		Connection con = DBConnect_SH.getConnection();
		String sql = new String("SELECT * From "+ tableName);
		System.out.println(sql);
		
		Method methods[] = ob.getClass().getDeclaredMethods();
		String attribute;
		
		Method getObjMethod = ob.getClass().getMethod("getObject");
		List<Object> objectCollection = new ArrayList<>();
		
		Statement st = con.createStatement();
		resultSet = st.executeQuery(sql);
		
		Object newObj;

		while(resultSet.next()) {
			newObj = getObjMethod.invoke(ob);
			for(Method method : methods) 
			{
				if(method.getName().contains("set")) {
					attribute = method.getName().substring(3);

					if(resultSet.getObject(attribute) != null) 
						method.invoke(newObj, resultSet.getObject(attribute).toString());
				}
			}
			objectCollection.add(newObj);
		}
		return objectCollection;
	}
	
	public Object readSingleRecord() throws Exception{
		Method methods[] = ob.getClass().getDeclaredMethods();
		String attribute;
		
		while(resultSet.next()) {
			for(Method method : methods) 
			{
				if(method.getName().contains("set")) {
					attribute = method.getName().substring(3);
					if(resultSet.getObject(attribute) != null)
						method.invoke(ob, resultSet.getObject(attribute).toString());
					else 
						method.invoke(ob, "");
				}
			}
		}
		return ob;
	}
}
