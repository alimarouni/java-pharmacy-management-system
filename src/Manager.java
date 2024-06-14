public class Manager {
	private String managerfname,managerlname;
	private int managerage;
	private Address address;
	public Manager(String managerfname, String managerlname, int managerage, Address address) {
		this.managerfname = managerfname;
		this.managerlname = managerlname;
		this.managerage = managerage;
		this.address = address;
	}
	public void setManagerfname(String manfname) {
		this.managerfname=manfname;
	}
	public String getManagerfname() {
		return managerfname;
	}
	public void setManagerlname(String manlname) {
		this.managerlname=manlname;
	}
	public String getManagerlname() {
		return managerlname;
	}
	public void setManagerage(int manage) {
		this.managerage=manage;
	}
	public int getManagerage() {
		return managerage;
	}
	public void setAddress(Address address) {
		this.address=address;
	}
	public Address getAddress() {
		return address;
	}
	public String toString() {
		return "_Manager_   managerfname: " + managerfname + "   | managerlname: " + managerlname + "   | managerage: " + managerage
				+ "   | address: " + address;
	}
	
}
