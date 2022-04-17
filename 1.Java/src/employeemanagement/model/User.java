package employeemanagement.model;

public class User {
	protected int id;
	protected String first_name;
	protected String last_name;
	protected String address;
	protected String contact;
	
	public User() {
	}
	
	public User(String first_name, String last_name, String address, String contact) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.contact = contact;
	}

	public User(int id, String first_name, String last_name, String address, String contact) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.contact = contact;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getfirst_name() {
		return first_name;
	}
	public void setfirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getlast_name() {
		return last_name;
	}
	public void setlast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getaddress() {
		return address;
	}
	public void setaddress(String address) {
		this.address = address;
	}
	public String getcontact() {
		return contact;
	}
	public void setcontact(String contact) {
		this.contact = contact;
	}
}
