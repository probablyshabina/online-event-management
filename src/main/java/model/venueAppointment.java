package model;

public class venueAppointment  extends Appointment {

	private String appointmentID;
	private String type, appDate;
	private String CreatedDate;
	private String Status;
	private String MadeBy;
	private String MadeTo;
	private String appStartTime;
	private String appEndTime;
	private String venueID;
	private String Location;
	private String Name;
	private String cusName;
	private String orgName;
	
	public venueAppointment() {
		//System.out.println("venueAppointment created");
	}
	
	public venueAppointment getObject() {
		return new venueAppointment();
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
