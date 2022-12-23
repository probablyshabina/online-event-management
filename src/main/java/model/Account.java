package model;

public class Account {

	private String accid;
	private String uuname;
	private String pwd;
	private String email;
	private String Id;
	private String type;
	
	public Account() {
		System.out.println("account created");
	}
	
	public String getAccid() {
		return accid;
	}

	public void setAccid(String accid) {
		this.accid = accid;
	}

	public String getUuname() {
		return uuname;
	}

	public void setUuname(String uuname) {
		this.uuname = uuname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
