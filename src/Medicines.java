import java.text.NumberFormat;
import java.util.*;
public class Medicines {
	protected String MedicineName;
	protected int MedicineBarCode;
	private int MedicineQuantity;
	protected double MedicinePrice;
	Random rad=new Random();
	NumberFormat fmt=NumberFormat.getCurrencyInstance();
	public Medicines(String medicineName,double medicinePrice) {
		MedicineName = medicineName;
		MedicinePrice = medicinePrice;
		MedicineBarCode=rad.nextInt(9000000)+1000000;
	}
	public Medicines(String medicineName, int medicineQuantity, double medicinePrice) {
		MedicineName = medicineName;
		MedicineQuantity = medicineQuantity;
		MedicinePrice = medicinePrice;
		MedicineBarCode=rad.nextInt(9000000)+1000000;
	}
	public void setMedicineName(String medicineName) {
		MedicineName = medicineName;
	}
	public String getMedicineName() {
		return MedicineName;
	}
	public int getMedicineBarCode() {
		return MedicineBarCode;
	}
	public void setMedicineQuantity(int medicineQuantity) {
		MedicineQuantity = medicineQuantity;
	}
	public int getMedicineQuantity() {
		return MedicineQuantity;
	}
	public void setMedicinePrice(double medicinePrice) {
		MedicinePrice = medicinePrice;
	}
	public double getMedicinePrice() {
		return MedicinePrice;
	}
	public String toString() {
		return "_Medicines_   MedicineName: " + MedicineName + "   |  MedicineBarCode: " + MedicineBarCode
				+ "   |  MedicineQuantity: " + MedicineQuantity + "   |  MedicinePrice: " + fmt.format(MedicinePrice);
	}
	
}
