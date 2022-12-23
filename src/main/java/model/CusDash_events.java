package model;

public class CusDash_events {
	private String eventID; 
	private String Date; 
	private String Type; 
	private String Host; 
	private String CusID; 
	private String venue; 
	private String approval; 
	private String startTime; 
	private String endTime; 
	private String createdDate; 
	private String venueID; 
	private String Location; 
	private String Name; 
	private String Incharge;

	public CusDash_events getObject() {
		return new CusDash_events();
	}
	
	public CusDash_events() {
		//System.out.println("CusDash_events created");
	}

	CusDash_events(String eventID, String date, String type, String host, String cusID, String venue, String approval,
			String startTime, String endTime, String createdDate, String venueID, String location, String name,
			String incharge) {
		super();
		this.eventID = eventID;
		this.Date = date;
		this.Type = type;
		this.Host = host;
		this.CusID = cusID;
		this.venue = venue;
		this.approval = approval;
		this.startTime = startTime;
		this.endTime = endTime;
		this.createdDate = createdDate;
		this.venueID = venueID;
		this.Location = location;
		this.Name = name;
		this.Incharge = incharge;
	}

	public String getEventID() {
		return eventID;
	}

	public void setEventID(String eventID) {
		this.eventID = eventID;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getHost() {
		return Host;
	}

	public void setHost(String host) {
		Host = host;
	}

	public String getCusID() {
		return CusID;
	}

	public void setCusID(String cusID) {
		CusID = cusID;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getApproval() {
		return approval;
	}

	public void setApproval(String approval) {
		this.approval = approval;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
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

	public String getIncharge() {
		return Incharge;
	}

	public void setIncharge(String incharge) {
		Incharge = incharge;
	}

}
