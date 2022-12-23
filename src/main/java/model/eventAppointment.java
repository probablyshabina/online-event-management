package model;

public class eventAppointment extends Appointment {
	
	private String appointmentID;
	private String type;
	private String appDate;
	private String CreatedDate;
	private String Status;
	private String MadeBy;
	private String MadeTo;
	private String appStartTime;
	private String appEndTime;
	private String venueID;
	private String eventDate;
	private String eventstartTime;
	private String eventEndTime;
	private String venueName;
	private String cusName;
	private String orgName;
	
	public eventAppointment() {
		//System.out.println("eventAppointment created");
	}

	public eventAppointment getObject(){
		return new eventAppointment();
	}
	
	public String getAppointmentID() {
		return appointmentID;
	}

	public void setAppointmentID(String appointmentID) {
		this.appointmentID = appointmentID;
		super.setAppointmentID(appointmentID);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAppDate() {
		return appDate;
	}

	public void setAppDate(String appDate) {
		this.appDate = appDate;
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

	public String getAppStartTime() {
		return appStartTime;
	}

	public void setAppStartTime(String appStartTime) {
		this.appStartTime = appStartTime;
	}

	public String getAppEndTime() {
		return appEndTime;
	}

	public void setAppEndTime(String appEndTime) {
		this.appEndTime = appEndTime;
	}

	public String getVenueID() {
		return venueID;
	}

	public void setVenueID(String venueID) {
		this.venueID = venueID;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public String getEventstartTime() {
		return eventstartTime;
	}

	public void setEventstartTime(String eventstartTime) {
		this.eventstartTime = eventstartTime;
	}

	public String getEventEndTime() {
		return eventEndTime;
	}

	public void setEventEndTime(String eventEndTime) {
		this.eventEndTime = eventEndTime;
	}

	public String getVenueName() {
		return venueName;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

}
