import java.text.*;
public class Prescriptionmedication extends Medicines {
	private String doctorname,timing;
	NumberFormat fmt= NumberFormat.getCurrencyInstance();
	public Prescriptionmedication (String doctorname,String timing,String medicineName,double medicinePrice) {
		super( medicineName,medicinePrice);
		this.doctorname=doctorname;
		this.timing=timing;
		}
	
	public String toString() {
		return "doctor name: " + doctorname + "\ntiming: " + timing + "\nmedicine name: "+MedicineName+"\nmedicine price: "+fmt.format(MedicinePrice);
	}
	
}
