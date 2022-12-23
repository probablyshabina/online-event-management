package util;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Map;
import java.util.TreeMap;

import model.Appointment;
import model.eventAppointment;
import model.venueAppointment;

public class AppointmentDBFuncs extends DBFunctions{

	public AppointmentDBFuncs() {
		System.out.println("AppointmentDBFuncs created");
	}
	
	public AppointmentDBFuncs(Appointment ap) {
		super(ap);
	}
	
	public AppointmentDBFuncs(String tableName) {
		super(tableName);
	}
	
	public AppointmentDBFuncs(String tableName, Object ap) {
		super(tableName, ap);
	}
	
	public Object getAppObject(String requestFrom, String appID) throws Exception{
		Connection conn = DBConnect_SH.getConnection();
		Statement st = conn.createStatement();
		ob = null;
		
		if(requestFrom.contains("eventAppointments")) {
			tableName = "eventAppointments";
			eventAppointment eObj = new eventAppointment();
			ob = eObj;
		}
		else if(requestFrom.contains("venueAppointments")) {
			tableName = "venueAppointments";
			venueAppointment vObj = new venueAppointment();
			ob = vObj;
		}
		
		String sql ="SELECT * FROM " + tableName + " WHERE appointmentID = " + appID;
		resultSet= st.executeQuery(sql);

		return super.readSingleRecord();
	}
	
	public TreeMap<String, String> toShow() throws Exception{
		LockAnObject lockedAppoint = LockAnObject.getInstance();
		TreeMap<String, String> Mapp = lockedAppoint.ObjToMap();
		TreeMap<String, String> myMap= new TreeMap<>();

		try {
			if(LockAnObject.getObj().getClass().getName().contains("venueAppointment")){
				for(Map.Entry<String, String> entry : Mapp.entrySet()){
					switch(entry.getKey()){
						case("AppDate"):
							myMap.put("Appointment Date", entry.getValue());
							break;
						case("CreatedDate"):
							myMap.put("Requested Date", entry.getValue());
							break;
						case("Status"):
							myMap.put("Approval Status", entry.getValue());
							break;
						case("AppStartTime"):
							myMap.put("Appointment Start Time", entry.getValue());
							break;
						case("AppEndTime"):
							myMap.put("Appointment end Time", entry.getValue());
							break;
						case("Location"):
							myMap.put("Venue Location", entry.getValue());
							break;
						case("Name"):
							myMap.put("Venue", entry.getValue());
							break;	
						case("OrgName"):
							myMap.put("Venue In-Charge", entry.getValue());
							break;
						}
				}
			}
			else if(LockAnObject.getObj().getClass().getName().contains("eventAppointment")) {
				for(Map.Entry<String, String> entry : Mapp.entrySet()) {
					switch(entry.getKey()){
					case("AppDate"):
						myMap.put("Appointment Date", entry.getValue());
						break;
					case("CreatedDate"):
						myMap.put("Requested Date", entry.getValue());
						break;
					case("Status"):
						myMap.put("Approval Status", entry.getValue());
						break;
					case("AppStartTime"):
						myMap.put("Appointment Start Time", entry.getValue());
						break;
					case("AppEndTime"):
						myMap.put("Appointment end Time", entry.getValue());
						break;
					case("Location"):
						myMap.put("Venue Location", entry.getValue());
						break;
					case("Name"):
						myMap.put("Venue", entry.getValue());
						break;	
					case("OrgName"):
						myMap.put("Venue In-Charge", entry.getValue());
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
