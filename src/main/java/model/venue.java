package model;

public class venue {
	private String venueID;
	private String Location;
	private String Name;
	private String Capacity;
	private String ACstatus;
	private String indoor_outdoor;
	private String Description;
	private String Owner;
	private String Hotline;
	private String Email;
	private String Website;
	private String Incharge;
	
	public venue() {
		// TODO Auto-generated constructor stub
	}

	public Object getObject() {
		return new venue();
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

	public String getCapacity() {
		return Capacity;
	}

	public void setCapacity(String capacity) {
		Capacity = capacity;
	}

	public String getACstatus() {
		return ACstatus;
	}

	public void setACstatus(String aCstatus) {
		ACstatus = aCstatus;
	}

	public String getIndoor_outdoor() {
		return indoor_outdoor;
	}

	public void setIndoor_outdoor(String indoor_outdoor) {
		this.indoor_outdoor = indoor_outdoor;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getOwner() {
		return Owner;
	}

	public void setOwner(String owner) {
		Owner = owner;
	}

	public String getHotline() {
		return Hotline;
	}

	public void setHotline(String hotline) {
		Hotline = hotline;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getWebsite() {
		return Website;
	}

	public void setWebsite(String website) {
		Website = website;
	}

	public String getIncharge() {
		return Incharge;
	}

	public void setIncharge(String incharge) {
		Incharge = incharge;
	}
}
