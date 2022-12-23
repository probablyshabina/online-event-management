package model;

public class cusDash_eApp {
	private String appointmentID;
	private String atype;
	private String aDate;
	private String aCreatedDate;
	private String Status;
	private String MadeBy;
	private String MadeTo;
	private String aStartTime;
	private String aEndTime;
	private String aVenueID;
	private String aEventID;
	private String eDate;
	private String eType;
	private String Host;
	private String CusID;
	private String venueID;
	private String approval;
	private String eStartTime;
	private String eEndTime;
	private String eCreatedDate;
	private String vVenueID;
	private String vName;
	
	public cusDash_eApp() {
		//System.out.println("cusDash_eApp created");
	}
	
	public cusDash_eApp getObject() {
		return new cusDash_eApp();
	}

	public String getAppointmentID() {
		return appointmentID;
	}

	public void setAppointmentID(String appointmentID) {
		this.appointmentID = appointmentID;
	}

	public String getAtype() {
		return atype;
	}

	public void setAtype(String atype) {
		this.atype = atype;
	}

	public String getaDate() {
		return aDate;
	}

	public void setaDate(String aDate) {
		this.aDate = aDate;
	}

	public String getaCreatedDate() {
		return aCreatedDate;
	}

	public void setaCreatedDate(String aCreatedDate) {
		this.aCreatedDate = aCreatedDate;
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

	public String getaStartTime() {
		return aStartTime;
	}

	public void setaStartTime(String aStartTime) {
		this.aStartTime = aStartTime;
	}

	public String getaEndTime() {
		return aEndTime;
	}

	public void setaEndTime(String aEndTime) {
		this.aEndTime = aEndTime;
	}

	public String getaVenueID() {
		return aVenueID;
	}

	public void setaVenueID(String aVenueID) {
		this.aVenueID = aVenueID;
	}

	public String getaEventID() {
		return aEventID;
	}

	public void setaEventID(String aEventID) {
		this.aEventID = aEventID;
	}

	public String geteDate() {
		return eDate;
	}

	public void seteDate(String eDate) {
		this.eDate = eDate;
	}

	public String geteType() {
		return eType;
	}

	public void seteType(String eType) {
		this.eType = eType;
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

	public String getVenueID() {
		return venueID;
	}

	public void setVenueID(String venueID) {
		this.venueID = venueID;
	}

	public String getApproval() {
		return approval;
	}

	public void setApproval(String approval) {
		this.approval = approval;
	}

	public String geteStartTime() {
		return eStartTime;
	}

	public void seteStartTime(String eStartTime) {
		this.eStartTime = eStartTime;
	}

	public String geteEndTime() {
		return eEndTime;
	}

	public void seteEndTime(String eEndTime) {
		this.eEndTime = eEndTime;
	}

	public String geteCreatedDate() {
		return eCreatedDate;
	}

	public void seteCreatedDate(String eCreatedDate) {
		this.eCreatedDate = eCreatedDate;
	}

	public String getvVenueID() {
		return vVenueID;
	}

	public void setvVenueID(String vVenueID) {
		this.vVenueID = vVenueID;
	}

	public String getvName() {
		return vName;
	}

	public void setvName(String vName) {
		this.vName = vName;
	}

}
