package util;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Map;
import java.util.TreeMap;

import model.Appointment;
import model.venue;

public class VenueDBFunctions extends DBFunctions {

	public VenueDBFunctions() {
	}
	
	public VenueDBFunctions(Appointment ap) {
		super(ap);
	}
	
	public VenueDBFunctions(String tableName) {
		super(tableName);
	}
	
	public VenueDBFunctions(String tableName, Object ap) {
		super(tableName, ap);
	}
	
	public Object getAppObject(String requestFrom, String appID) throws Exception{
		Connection conn = DBConnect_SH.getConnection();
		Statement st = conn.createStatement();
		ob = null;
		
		if(requestFrom.contains("venue")) {
			tableName = "venue";
			venue eObj = new venue();
			ob = eObj;
		}
		
		String sql ="SELECT * FROM " + tableName + " WHERE venueID = " + appID;
		resultSet= st.executeQuery(sql);

		return super.readSingleRecord();
	}
	
	public TreeMap<String, String> toShow() throws Exception{
		LockAnObject lockedAppoint = LockAnObject.getInstance();
		TreeMap<String, String> Mapp = lockedAppoint.ObjToMap();
		TreeMap<String, String> myMap= new TreeMap<>();

		try {
			if(LockAnObject.getObj().getClass().getName().contains("venue")){
				for(Map.Entry<String, String> entry : Mapp.entrySet()){
					switch(entry.getKey()){
						case("Location"):
							myMap.put("Location", entry.getValue());
							break;
						case("Name"):
							myMap.put("Venue Name", entry.getValue());
							break;
						case("Capacity"):
							myMap.put("Capacity", entry.getValue());
							break;
						case("ACstatus"):
							myMap.put("AC Available", entry.getValue());
							break;
						case("indoor_outdoor"):
							myMap.put("Indoor Or Outdoor", entry.getValue());
							break;
						case("Description"):
							myMap.put("Venue Description", entry.getValue());
							break;	
						case("Owner"):
							myMap.put("Owner", entry.getValue());
							break;	
						case("Hotline"):
							myMap.put("Hotline", entry.getValue());
							break;	
						case("Email"):
							myMap.put("Email", entry.getValue());
							break;	
						case("Website"):
							myMap.put("Website", entry.getValue());
							break;
						}
				}
			}
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return myMap;
	}

}
