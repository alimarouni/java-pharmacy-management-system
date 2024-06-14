public class Pharmacy {
	private Address address;
	private Manager manager;
	private String phname;
	
	public Pharmacy(Address address,Manager manager,String phname) {
		this.address=address;
		this.manager=manager;
		this.phname=phname;
	}
	public void setAddress(Address address) {
		this.address=address;
	}
	public Address getAddress() {
		return address;
	}
	public void setManager(Manager manager) {
		this.manager=manager;
	}
	public Manager getManager() {
		return manager;
	}
	public void setPhname(String phname) {
		this.phname=phname;
	}
	public String getPhname() {
		return phname;
	}
	public String toString() {
		return "_Pharmacy_   pharmacy name: " +phname +"   | address: " + address + "   | manager: "+ manager;
	}
	public String toString2() {
		return "_pharmacy_ address: "+address;
	}
}
