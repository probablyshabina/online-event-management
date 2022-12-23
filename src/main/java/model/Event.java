package model;

public class Event {
	private String eventID;
	private String Date;
	private String Type;
	private String Noguest;
	private String Host;
	private String CusID;
	private String venue;
	private String approval;
	private String startTime;
	private String endTime;
	private String createdDate;
	
	public Event() {
		// TODO Auto-generated constructor stub
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

	public String getNoguest() {
		return Noguest;
	}

	public void setNoguest(String noguest) {
		Noguest = noguest;
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

}
