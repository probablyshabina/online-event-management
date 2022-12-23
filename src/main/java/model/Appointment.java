package model;

public class Appointment {

	private String appointmentID;
	private String type; 
	private String Date; 
	private String CreatedDate; 
	private String Status; 
	private String MadeBy;
	private String MadeTo; 
	private String StartTime; 
	private String EndTime;
	private String eventID;
	private String venueID;


	public Appointment() {
		//System.out.println("Appointment created");
	}	
	
	public String getEventID() {
		return eventID;
	}

	public void setEventID(String eventID) {
		this.eventID = eventID;
	}

	public String getVenueID() {
		return venueID;
	}

	public void setVenueID(String venueID) {
		this.venueID = venueID;
	}

	public Appointment getObject() {
		return new Appointment();
	}

	public Appointment(String appointmentID, String type, String date, String createdDate, String status, String madeBy, String madeTo,
				String startTime, String endTime) {
		super();
		this.appointmentID = appointmentID;
		this.type = type;
		Date = date;
		CreatedDate = createdDate;
		Status = status;
		MadeBy = madeBy;
		MadeTo = madeTo;
		StartTime = startTime;
		EndTime = endTime;
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

}
