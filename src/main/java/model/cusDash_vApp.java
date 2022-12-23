package model;

public class cusDash_vApp {
	private String appointmentID; 
	private String type; 
	private String Date; 
	private String CreatedDate; 
	private String Status; 
	private String MadeBy; 
	private String MadeTo; 
	private String StartTime; 
	private String EndTime; 
	private String venueID; 
	private String eventID; 
	private String Location; 
	private String Name; 
	private String Incharge; 
	private String organizerID; 
	private String orgName;
	
	public cusDash_vApp() {
		//System.out.println("cusDash_vApp is created");
	}
	
	public cusDash_vApp getObject() {
		return new cusDash_vApp();
	}
	
	public String getAppointmentID() {
		return appointmentID;
	}

	public void setAppointmentID(String appointmentID) {
		this.appointmentID = appointmentID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getCreatedDate() {
		return CreatedDate;
	}

	public void setCreatedDate(String createdDate) {
		CreatedDate = createdDate;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getMadeBy() {
		return MadeBy;
	}

	public void setMadeBy(String madeBy) {
		MadeBy = madeBy;
	}

	public String getMadeTo() {
		return MadeTo;
	}

	public void setMadeTo(String madeTo) {
		MadeTo = madeTo;
	}

	public String getStartTime() {
		return StartTime;
	}

	public void setStartTime(String startTime) {
		StartTime = startTime;
	}

	public String getEndTime() {
		return EndTime;
	}

	public void setEndTime(String endTime) {
		EndTime = endTime;
	}

	public String getVenueID() {
		return venueID;
	}

	public void setVenueID(String venueID) {
		this.venueID = venueID;
	}

	public String getEventID() {
		return eventID;
	}

	public void setEventID(String eventID) {
		this.eventID = eventID;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getIncharge() {
		return Incharge;
	}

	public void setIncharge(String incharge) {
		Incharge = incharge;
	}

	public String getOrganizerID() {
		return organizerID;
	}

	public void setOrganizerID(String organizerID) {
		this.organizerID = organizerID;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

}
