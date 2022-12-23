package model;

public class Customer {
	private String CusID;
	private String Name;
	private String Address;
	private String PhoneNum;
	private String Email;
	private String image;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public String getCusID() {
		return CusID;
	}

	public void setCusID(String cusID) {
		CusID = cusID;
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

	public String getPhoneNum() {
		return PhoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		PhoneNum = phoneNum;
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
