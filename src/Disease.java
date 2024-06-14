import java.util.ArrayList;
public class Disease implements Dose{
	private ArrayList<String> diseasename;
	private Medicines medicine;
	private int MedicineDose;
	public Disease( Medicines medicine) {
		this.medicine = medicine;
		MedicineDose =1;
		diseasename = new ArrayList<String>();
		diseasename.add("headache");
		diseasename.add("stomachache");
		diseasename.add("flu");
		diseasename.add("joint pain");
		diseasename.add("allergy");
		diseasename.add("covid-19");
		diseasename.add("muscle pear");
		diseasename.add("fever");
		diseasename.add("skin rash");
		diseasename.add("malaria");
	}
	public ArrayList<String> getDiseaseName() {
		return diseasename;
	}
	public void setMedicine(Medicines medicine) {
		this.medicine = medicine;
	}
	public Medicines getMedicine() {
		return medicine;
	}
	public void setDose(int dose) {
		MedicineDose=dose;
	}
	public int getDose() {
		return MedicineDose;
	}
	public String toString() {
		return "_Disease_ diseaseName: " + diseasename + "   | Medicine: " + medicine + "    | MedicineDose: "
				+ MedicineDose;
	}
	
}
