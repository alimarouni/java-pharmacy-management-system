public class Address {
	private String streetAddress,city,St;
	public Address(String street,String city,String St) {
		this.streetAddress=street;
		this.city=city;
		this.St=St;
	}
	public void setStreetaddress(String street) {
		streetAddress=street;
	}
	public String getStreetaddress() {
		return streetAddress;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return city;
	}
	public void setSt(String st) {
		St = st;
	}
	public String getSt() {
		return St;
	}
	public String toString() {
		return " streetAddress: " + streetAddress + "   | city: " + city + "   | State: " + St ;
	}
	
	
}
