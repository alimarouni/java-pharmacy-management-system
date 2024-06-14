import java.util.*;
public class Employee {
	private String Fname,Lname,id;
	private Address address;
	int a;
	Random rad=new Random();
	public Employee(String fname, String lname,Address address) { 
		Fname = fname;
		Lname = lname;
		this.address = address;
		a=rad.nextInt(9000)+1000;
		id="2023-"+Fname.substring(0,2).toUpperCase()+"_"+Lname.substring(Lname.length()-2,Lname.length()).toLowerCase()+"@"+a;
	}
	public void setFname(String fname) {
		this.Fname=fname;
	}
	public String getFname() {
		return Fname;
	}
	public void setLname(String lname) {
		this.Lname=lname;
	}
	public String getLname() {
		return Lname;
	}
	public String getId() {
		return id;
	}
	public void setAddress(Address address) {
		this.address=address;
	}
	public Address getAddress() {
		return address;
	}
	public String toString() {
		return " Fname: " + Fname + "   | Lname: " + Lname + "   | id: " + id + "   | address: " + address;
	}
	
}
