package model;

public class Organizer {
	private String organizerID;
	private String Name;
	private String Address;
	private String Phone;
	private String Email;
	private String image;
	
	public Organizer() {
	}

	public String getOrganizerID() {
		return organizerID;
	}

	public void setOrganizerID(String organizerID) {
		this.organizerID = organizerID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
