import java.util.*;
import java.text.*;
import java.io.FileWriter;
import java.io.IOException;
public class PharmacyTester {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		NumberFormat fmt=NumberFormat.getCurrencyInstance();
		String StreetAddress;
		String City;
		String state;
		String fname;
		String lname;
		int n;
		Employee[] employees=new Employee[100];
		System.out.println("enter the number of employees:");
		n=in.nextInt();
		in.nextLine();
		for(int i=0;i<n;i++) {
			System.out.println("enter the fname of employee "+(i+1)+" :");
			fname=in.nextLine();
			System.out.println("enter the Lname of employee "+(i+1)+" :");
			lname=in.nextLine();
			System.out.println("enter the street address of employee "+(i+1)+" :");
			StreetAddress=in.nextLine();
			System.out.println("enter the city of employee "+(i+1)+" :");
			City=in.nextLine();
			System.out.println("enter the state of employee "+(i+1)+" :");
			state=in.nextLine();
			Address c1=new Address(StreetAddress,City,state);
			Employee c2=new Employee(fname,lname,c1);
			employees[i]=c2;
		}
		
		String txt1File = "employee.txt";
		try (FileWriter writer = new FileWriter(txt1File)){
			writer.append("Employees Details:\n\n");
			for(int i=0;i<n;i++) {
		      writer.append("employee "+(i+1)+": "+"fname: "+employees[i].getFname()+"\nlname: "+employees[i].getLname()
		    		  +"\nId: "+employees[i].getId()+"\nAddress:\n"+employees[i].getAddress()
		    		  +"\n_________________________________________________________________________\n");
			}
		}catch (IOException e) {
		      System.err.println("Error writing to TXT file: " + e.getMessage());
	    }
		System.out.println("_________________________________________________________________________");
		String Managerfname;
		String Managerlname;
		int Managerage;
		String manStreetAddress;
		String manCity;
		String manState;
		System.out.println("enter the fname of the manager: ");
		Managerfname=in.nextLine();
		System.out.println("enter the lname of the manager: ");
		Managerlname=in.nextLine();
		System.out.println("enter the age of the manager (25-65): ");
		do {
		Managerage=in.nextInt();
		if(Managerage<25 || Managerage>65) {
			System.out.println("Invalid age re enter (25-65):");
		}
		}while(Managerage<25 || Managerage>65);
		in.nextLine();
		System.out.println("enter the street address of manager: ");
		manStreetAddress=in.nextLine();
		System.out.println("enter the city of manager: ");
		manCity=in.nextLine();
		System.out.println("enter the state of manager: ");
		manState=in.nextLine();
		Address c3=new Address(manStreetAddress,manCity,manState);
		Manager c4=new Manager(Managerfname,Managerlname,Managerage,c3);
		
		String txt2File = "manager.txt";
		try (FileWriter writer = new FileWriter(txt2File)){
		      writer.append("Manager Details:\n\n"+"fname: "+c4.getManagerfname()+"\nlname: "+c4.getManagerlname()
		      +"\nage: "+c4.getManagerage()+"\nAddress:\n"+c4.getAddress());
		}catch (IOException e) {
		      System.err.println("Error writing to TXT file: " + e.getMessage());
	    }
		System.out.println("_________________________________________________________________________");
		String Medicinename;
		int Medicinequantity;
		double Medicineprice;
		int m;
		Medicines[] medicines=new Medicines[100];
		System.out.println("enter the number of medicines you want to add to your pharmacy: ");
		m=in.nextInt();
		for(int i=0;i<m;i++) {
			in.nextLine();
			System.out.println("enter the name of medicine "+(i+1)+": ");
			Medicinename=in.nextLine();
			System.out.println("enter the quantity of medicine "+(i+1)+" (1-2000): ");
			do {
			Medicinequantity=in.nextInt();
			if(Medicinequantity<1 || Medicinequantity>2000) {
				System.out.println("invalid quantity re enter (1-2000)");
			}
			}while(Medicinequantity<1 || Medicinequantity>2000);
			System.out.println("enter the price of medicine "+(i+1)+" (0-1000): ");
			do {
			Medicineprice=in.nextDouble();
			if(Medicineprice<=0 || Medicineprice>1000) {
				System.out.println("invalid price re enter (0-1000)");
			}
			}while(Medicineprice<=0 || Medicineprice>1000);
			Medicines c5=new Medicines(Medicinename,Medicinequantity,Medicineprice);
			medicines[i]=c5;
		}
		
		String txt3File = "medicines.txt";
        try (FileWriter writer = new FileWriter(txt3File)) {
        	writer.append("Mdicines details:\n\n");
            for (int i=0;i<m;i++) {
            	writer.append("medicine "+(i+1)+": "+"name: "+medicines[i].getMedicineName()+"\nquantity: "
                      +medicines[i].getMedicineQuantity()+"\nprice: "+fmt.format(medicines[i].getMedicinePrice())+"\nbarcode:"
            			+medicines[i].getMedicineBarCode()+"\n_________________________________________________________________________\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing to TXT file: " + e.getMessage());
        }
		System.out.println("_________________________________________________________________________");
		String phname;
		String phaddress;
		String phcity;
		String phstate;
		in.nextLine();
		System.out.println("enter the pharmacy name: ");
		phname=in.nextLine();
		System.out.println("enter the street address of the pharmacy: ");
		phaddress=in.nextLine();
		System.out.println("enter the city of the pharmacy: ");
		phcity=in.nextLine();
		System.out.println("enter the state of the pharmacy: ");
		phstate=in.nextLine();
		Address c6=new Address(phaddress,phcity,phstate);
		Pharmacy c7=new Pharmacy(c6,c4,phname);
		
		String txt4File = "pharmacy.txt";
		try (FileWriter writer = new FileWriter(txt4File)){
		      writer.append("Pharmacy detials:\n\n"+"name: "+c7.getPhname()+"\nAddress:\n"+c7.getAddress());
		}catch (IOException e) {
		      System.err.println("Error writing to TXT file: " + e.getMessage());
	    }
		System.out.println("_________________________________________________________________________");
		int choice=0;
		while(choice !=6) {
			System.out.println("Choose which menu you want to adjust: ");
			System.out.println("1-Employee");
			System.out.println("2-Manager");
			System.out.println("3-Pharmacy");
			System.out.println("4-Medicines");
			System.out.println("5-patient diseases");
			System.out.println("6-Exit!");
			do {
			choice=in.nextInt();
			if(choice<1 ||choice>6) {
				System.out.println("Invalid choice");
			}
			}while(choice<1 ||choice>6);
			switch(choice) {
			case 1: 
				int choice1=0;
				while(choice1 !=6) {
					System.out.println("Adjusting employee menu: ");
					System.out.println("1-display all employee details");
					System.out.println("2-Search an employee");
					System.out.println("3-remove employee");
					System.out.println("4-register employee");
					System.out.println("5-display a specific employee address");
					System.out.println("6-Exit employee menu");
					
					do {
						choice1=in.nextInt();
						if(choice1<1 ||choice1>6) {
							System.out.println("Invalid choice");
						}
						}while(choice1<1 ||choice1>6);
					
					switch(choice1) {
					case 1:
						for(int i=0;i<n;i++) {
							 System.out.println("Employee " + (i+1) + ": " + employees[i].toString());
						}
						break;
					case 2:
						boolean found=false;
						System.out.println("enter the fname of the employee: ");
						in.nextLine();
						fname=in.nextLine();
						System.out.println("enter the lname of the employee: ");
						lname=in.nextLine();
						for(int i=0;i<n;i++) {
							if(employees[i].getFname().toLowerCase().equals(fname.toLowerCase()) && 
									employees[i].getLname().toLowerCase().equals(lname.toLowerCase())) {
								System.out.println("Employee " + (i+1) + ": " + employees[i].toString());
								found=true;
							}
						}
						if(found==false) {
							System.out.println("emlpoyee not found");
						}
						break;
					case 3:
						boolean found1=false;
						int foundindex=0;
						System.out.println("enter the fname of the employee: ");
						in.nextLine();
						fname=in.nextLine();
						System.out.println("enter the lname of the employee: ");
						lname=in.nextLine();
						for(int i=0;i<n;i++) {
							if(employees[i].getFname().toLowerCase().equals(fname.toLowerCase()) && 
									employees[i].getLname().toLowerCase().equals(lname.toLowerCase())) {
								foundindex=i;
								found1=true;
							}
						}
						if(found1==true) {
							for(int i=foundindex; i<(n-1); i++){
							employees[i]=employees[i+1];
							}
							n--;
							System.out.println("employee deleted!");
							}
						else {
							System.out.println("employee not found");
						}
						break;
					case 4:
						String fnamen,lnamen,StreetAddressn,Cityn,staten;
						in.nextLine();
						System.out.println("enter the fname of the new employee: ");
						fnamen=in.nextLine();
						System.out.println("enter the Lname of new employee: ");
						lnamen=in.nextLine();
						System.out.println("enter the street address of new employee: ");
						StreetAddressn=in.nextLine();
						System.out.println("enter the city of new employee: ");
						Cityn=in.nextLine();
						System.out.println("enter the state of new employee: ");
						staten=in.nextLine();
							Address c8=new Address(StreetAddressn,Cityn,staten);
							Employee c9=new Employee(fnamen,lnamen,c8);
							employees[n]=c9;
							n++;
							System.out.println("employee added");
							break;
					case 5:
						boolean found2=false;
						System.out.println("enter the fname of the employee: ");
						in.nextLine();
						fname=in.nextLine();
						System.out.println("enter the lname of the employee: ");
						lname=in.nextLine();
						for(int i=0;i<n;i++) {
							if(employees[i].getFname().toLowerCase().equals(fname.toLowerCase()) && 
									employees[i].getLname().toLowerCase().equals(lname.toLowerCase())) {
								System.out.println("address of employee "+(i+1)+": "+employees[i].getAddress());
								found2=true;
							}
						}
						if(found2==false) {
							System.out.println("employee not found");
						}
						break;
					case 6:
						System.out.println("Exiting employee menu...");
						break;
					}
					System.out.println("_________________________________________________________________________");
				}
				break;
			case 2:
				int choice2=0;
				while(choice2 !=4) {
					System.out.println("Adjusting manager menu: ");
					System.out.println("1-display manager details");
					System.out.println("2-display manager address");
					System.out.println("3-replace manager");
					System.out.println("4-Exit manager menu");
					
					do {
						choice2=in.nextInt();
						if(choice2<1 ||choice2>4) {
							System.out.println("Invalid choice");
						}
						}while(choice2<1 ||choice2>4);
					switch(choice2) {
					case 1:
						System.out.println(c4.toString());
						break;
					case 2:
						System.out.println("manager address: "+c4.getAddress());
						break;
					case 3:
						in.nextLine();
						System.out.println("enter the fname of the new manager: ");
						Managerfname=in.nextLine();
						c4.setManagerfname(Managerfname);
						System.out.println("enter the lname of the new manager: ");
						Managerlname=in.nextLine();
						c4.setManagerlname(Managerlname);
						System.out.println("enter the age of the new manager (25-65): ");
						do {
							Managerage=in.nextInt();
							c4.setManagerage(Managerage);
							if(Managerage<25 || Managerage>65) {
								System.out.println("Invalid age re enter (25-65):");
							}
							}while(Managerage<25 || Managerage>65);
						in.nextLine();
						System.out.println("enter the street address of new manager: ");
						manStreetAddress=in.nextLine();
						c3.setStreetaddress(manStreetAddress);
						System.out.println("enter the city of new manager: ");
						manCity=in.nextLine();
						c3.setCity(manCity);
						System.out.println("enter the state of new manager: ");
						manState=in.nextLine();
						c3.setSt(manState);
						System.out.println("the new manager info: "+c4.toString());
						break;
					case 4:
						System.out.println("Exiting manager menu...");
						break;
					}
					System.out.println("_________________________________________________________________________");
				}
				break;
			case 3:
				int choice3=0;
				while(choice3 !=4) {
					System.out.println("Adjusting pharmacy menu: ");
					System.out.println("1-display pharmacy  address information");
					System.out.println("2-change the current pharmacy address");
					System.out.println("3-display employee and manager information");
					System.out.println("4-Exit pharmacy menu");
					
					do {
						choice3=in.nextInt();
						if(choice3<1 ||choice3>4) {
							System.out.println("Invalid choice");
						}
						}while(choice3<1 ||choice3>4);
					
					in.nextLine();
					switch(choice3) {
					case 1:
						System.out.println(c7.toString2());
						break;
					case 2:
						System.out.println("enter the new name of pharmacy: ");
						phname=in.nextLine();
						c7.setPhname(phname);
						System.out.println("enter the new street address of the pharmacy: ");
						phaddress=in.nextLine();
						c6.setStreetaddress(phaddress);
						System.out.println("enter the new city of the pharmacy: ");
						phcity=in.nextLine();
						c6.setCity(phcity);
						System.out.println("enter the new state of the pharmacy: ");
						phstate=in.nextLine();
						c6.setSt(phstate);
						System.out.println("the pharmacy new address: "+c7.toString2());
						break;
					case 3:
						System.out.println("the manager and employee info:\n"+c4.toString());
						for(int i=0;i<n;i++) {
							System.out.println("employee "+(i+1)+": "+employees[i].toString());
						}
						break;
					case 4:
						System.out.println("Exiting pharmacy menu...");
						break;
					}
					System.out.println("_________________________________________________________________________");
				}
				break;
			case 4:
				int choice4=0;
				while(choice4 !=7) {
					System.out.println("Adjusting medicines menu:");
					System.out.println("1-display the availabe medicines in the pharmacy");
					System.out.println("2-display the medicines price");
					System.out.println("3-display all medicine info");
					System.out.println("4-Add medicine");
					System.out.println("5-remove medicine");
					System.out.println("6-change medicine price");
					System.out.println("7-Exit medicine menu");
					
					do {
						choice4=in.nextInt();
						if(choice4<1 ||choice4>7) {
							System.out.println("Invalid choice");
						}
						}while(choice4<1 ||choice4>7);
					
					switch(choice4) {
					case 1:
						for(int i=0;i<m;i++) {
							System.out.println("medicine "+(i+1)+": "+medicines[i].getMedicineName());
						}
						break;
					case 2:
						for(int i=0;i<m;i++) {
							System.out.println("medicine "+(i+1)+": "+fmt.format(medicines[i].getMedicinePrice()));
						}
						break;
					case 3:
						for(int i=0;i<m;i++) {
							System.out.println("medicine "+(i+1)+": "+medicines[i].toString());
						}
						break;
					case 4:
						String Medicinenamen;
						int Medicinequantityn;
						double Medicinepricen;
						in.nextLine();
						System.out.println("enter the name of medicine: ");
						Medicinenamen=in.nextLine();
						System.out.println("enter the quantity of medicine(1-2000): ");
						do {
							Medicinequantityn=in.nextInt();
							if(Medicinequantityn<1 || Medicinequantityn>2000) {
								System.out.println("invalid quantity re enter (1-2000): ");
							}
							}while(Medicinequantityn<1 || Medicinequantityn>2000);
						System.out.println("enter the price of medicine (0-1000): ");
						do {
							Medicinepricen=in.nextDouble();
							if(Medicinepricen<=0 || Medicinepricen>1000) {
								System.out.println("invalid price re enter (0-100): ");
							}
							}while(Medicinepricen<=0 || Medicinepricen>1000);
						Medicines c14=new Medicines( Medicinenamen,Medicinequantityn,Medicinepricen);
						medicines[m]=c14;
						m++;
						System.out.println("medicine added");
						break;
					case 5:
						boolean found3=false;
						int foundindex1=0;
						System.out.println("enter medicine name you want to remove: ");
						Medicinename=in.nextLine();
						for(int i=0;i<n;i++) {
							if(medicines[i].getMedicineName().toLowerCase().equals(Medicinename)) {
								foundindex1=i;
								found3=true;
							}
						}
						if(found3==true) {
							for(int i=foundindex1; i<(m-1); i++){
							medicines[i]=medicines[i+1];
							}
							m--;
							System.out.println("medicine deleted!");
							}
						else {
							System.out.println("medicine not found");
						}
						break;
					case 6:
						System.out.println("enter the name of the medicine");
						Medicinename=in.nextLine();
						boolean found4=false;
						double pricen;
						for(int i=0;i<m;i++) {
							if(medicines[i].getMedicineName().toLowerCase().equals(Medicinename)) {
								System.out.println("enter the new price (0-1000): ");
								do {
								   pricen=in.nextDouble();
									if(pricen<=0 || pricen>1000) {
										System.out.println("invalid price re enter (0-100): ");
									}
									}while(pricen<=0 || pricen>1000);
								medicines[i].setMedicinePrice(pricen);
								found4=true;
								System.out.println("medicine price has been updated");
							}
						}
						if( found4==false) {
							System.out.println("medicine not found");
						}
						break;
					case 7:
						System.out.println("Exiting medicines menu...");
						break;
					}
					System.out.println("_________________________________________________________________________");
				}
				break;
			case 5:
				int choice5=0;
				String patientfname;
				String patientlname;
				int patientage;
				
				String medname="null";
				String disname;
				int meddose;
				double medprice=0;
				in.nextLine();
				System.out.println("enter the patient fname: ");
				patientfname=in.nextLine();
				System.out.println("enter the patient lname: ");
				patientlname=in.nextLine();
				System.out.println("enter the patient age (0-150): ");
				do {
				patientage=in.nextInt();
				if(patientage<=0 || patientage>150) {
					System.out.println("invalid age re enter (0-150):");
				}
				}while(patientage<=0 ||patientage>150);
				
					System.out.println("what is the patient suffering from:\n"
							+"1-headache\n"
							+"2-stomachache\n"
							+"3-flu\n"
							+"4-joint pain\n"
							+"5-allergy\n"
							+"6-covid-19\n"
							+"7-muscle pear\n"
							+"8-fever\n"
							+"9-skin rash\n"
						    +"10-malaria"
							);
					do {
						choice5=in.nextInt();
						if(choice5<1 ||choice5>10) {
							System.out.println("Invalid choice");
						}
						}while(choice5<1 ||choice5>10);
					
					boolean foundmed=false;
					for(int i=0;i<m;i++) {
						Disease c15=new Disease(medicines[i]);
						ArrayList<String> c16 = c15.getDiseaseName();
						if(choice5==1) {
							disname=c16.get(0);
							System.out.println("the patient is suffering from: "+disname);
							if(medicines[i].getMedicineName().equalsIgnoreCase("panadol")||medicines[i].getMedicineName().equalsIgnoreCase("adol")) {
								medname=medicines[i].getMedicineName();
								System.out.println("medicine suggestion: "+medname);
								medprice=medicines[i].getMedicinePrice();
								foundmed=true;
								if(patientage>=18 && patientage<=65) {
									c15.setDose(1000);
									meddose=c15.getDose();
									System.out.println("the suggested dose: "+meddose);
								}
								else if(patientage>0 && patientage<18 || patientage>65){
									c15.setDose(500);
									meddose=c15.getDose();
									System.out.println("the suggested dose: "+meddose);
								}
							}
							else {
								System.out.println("Sorry there is no available medicine right now");
							}
							break;
						}
						if(choice5==2) {
							disname=c16.get(1);
							System.out.println("patient is suffering from: "+disname);
							if(medicines[i].getMedicineName().equalsIgnoreCase("panadol") || medicines[i].getMedicineName().equalsIgnoreCase("antiacids")) {
								medname=medicines[i].getMedicineName();
								System.out.println("medicine suggestion: "+medname);
								medprice=medicines[i].getMedicinePrice();
								foundmed=true;
								if(patientage>=18 && patientage<=65) {
									c15.setDose(900);
									meddose=c15.getDose();
									System.out.println("the suggested dose: "+meddose);
								}
								else if(patientage>0 && patientage<18 || patientage>65){
									c15.setDose(300);
									meddose=c15.getDose();
									System.out.println("the suggested dose: "+meddose);
								}
							}
							else {
								System.out.println("Sorry there is no available medicine right now");
							}
							break;
						}
						if(choice5==3) {
							disname=c16.get(2);
							System.out.println("patient is suffering from: "+disname);
							if(medicines[i].getMedicineName().equalsIgnoreCase("zanamavir") || medicines[i].getMedicineName().equalsIgnoreCase("vitamin c")) {
								medname=medicines[i].getMedicineName();
								System.out.println("medicine suggestion: "+medname);
								medprice=medicines[i].getMedicinePrice();
								foundmed=true;
								if(patientage>=18 && patientage<=65) {
									c15.setDose(500);
									meddose=c15.getDose();
									System.out.println("the suggested dose: "+meddose);
								}
								else if(patientage>0 && patientage<18 || patientage>65){
									c15.setDose(200);
									meddose=c15.getDose();
									System.out.println("the suggested dose: "+meddose);
								}
							}
							else {
								System.out.println("Sorry there is no available medicine right now");
							}
							break;
						}
						if(choice5==4) {
							disname=c16.get(3);
							System.out.println("patient is suffering from: "+disname);
							if(medicines[i].getMedicineName().equalsIgnoreCase(" Advil") || medicines[i].getMedicineName().equalsIgnoreCase("Motrin")) {
								medname=medicines[i].getMedicineName();
								System.out.println("medicine suggestion: "+medname);
								medprice=medicines[i].getMedicinePrice();
								foundmed=true;
								if(patientage>=18 && patientage<=65) {
									c15.setDose(1000);
									meddose=c15.getDose();
									System.out.println("the suggested dose: "+meddose);
								}
								else if(patientage>0 && patientage<18 || patientage>65){
									c15.setDose(500);
									meddose=c15.getDose();
									System.out.println("the suggested dose: "+meddose);
								}
							}
							else {
								System.out.println("Sorry there is no available medicine right now");
							}
							break;
						}
						if(choice5==5) {
							disname=c16.get(4);
							System.out.println("patient is suffering from: "+disname);
							if(medicines[i].getMedicineName().equalsIgnoreCase("Cetirizine") || medicines[i].getMedicineName().equalsIgnoreCase("Loratadine ")) {
								medname=medicines[i].getMedicineName();
								System.out.println("medicine suggestion: "+medname);
								medprice=medicines[i].getMedicinePrice();
								foundmed=true;
								if(patientage>=18 && patientage<=65) {
									c15.setDose(800);
									meddose=c15.getDose();
									System.out.println("the suggested dose: "+meddose);
								}
								else if(patientage>0 && patientage<18 || patientage>65){
									c15.setDose(400);
									meddose=c15.getDose();
									System.out.println("the suggested dose: "+meddose);
								}
							}
							else {
								System.out.println("Sorry there is no available medicine right now");
							}
							break;
						}
						if(choice5==6) {
							disname=c16.get(5);
							System.out.println("patient is suffering from: "+disname);
							if(medicines[i].getMedicineName().equalsIgnoreCase("zinc") || medicines[i].getMedicineName().equalsIgnoreCase("vitamin c")) {
								medname=medicines[i].getMedicineName();
								System.out.println("medicine suggestion: "+medname);
								medprice=medicines[i].getMedicinePrice();
								foundmed=true;
								if(patientage>=18 && patientage<=65) {
									c15.setDose(1000);
									meddose=c15.getDose();
									System.out.println("the suggested dose: "+meddose);
								}
								else if(patientage>0 && patientage<18 || patientage>65){
									c15.setDose(1000);
									meddose=c15.getDose();
									System.out.println("the suggested dose: "+meddose);
								}
							}
							else {
								System.out.println("Sorry there is no available medicine right now");
							}
							break;
						}
						if(choice5==7) {
							disname=c16.get(6);
							System.out.println("patient is suffering from: "+disname);
							if(medicines[i].getMedicineName().equalsIgnoreCase("Tylenol") || medicines[i].getMedicineName().equalsIgnoreCase("advil")) {
								medname=medicines[i].getMedicineName();
								System.out.println("medicine suggestion: "+medname);
								medprice=medicines[i].getMedicinePrice();
								foundmed=true;
								if(patientage>=18 && patientage<=65) {
									c15.setDose(600);
									meddose=c15.getDose();
									System.out.println("the suggested dose: "+meddose);
								}
								else if(patientage>0 && patientage<18 || patientage>65){
									c15.setDose(200);
									meddose=c15.getDose();
									System.out.println("the suggested dose: "+meddose);
								}
							}
							else {
								System.out.println("Sorry there is no available medicine right now");
							}
							break;
						}
						if(choice5==8) {
							disname=c16.get(7);
							System.out.println("patient is suffering from: "+disname);
							if(medicines[i].getMedicineName().equalsIgnoreCase("aspirin") || medicines[i].getMedicineName().equalsIgnoreCase("paracetamol")) {
								medname=medicines[i].getMedicineName();
								System.out.println("medicine suggestion: "+medname);
								medprice=medicines[i].getMedicinePrice();
								foundmed=true;
								if(patientage>=18 && patientage<=65) {
									c15.setDose(300);
									meddose=c15.getDose();
									System.out.println("the suggested dose: "+meddose);
								}
								else if(patientage>0 && patientage<18 || patientage>65){
									c15.setDose(100);
									meddose=c15.getDose();
									System.out.println("the suggested dose: "+meddose);
								}
							}
							else {
								System.out.println("Sorry there is no available medicine right now");
							}
							break;
						}
						if(choice5==9) {
							disname=c16.get(8);
							System.out.println("patient is suffering from: "+disname);
							if(medicines[i].getMedicineName().equalsIgnoreCase("Hydrocortisone")) {
								medname=medicines[i].getMedicineName();
								System.out.println("medicine suggestion: "+medname);
								medprice=medicines[i].getMedicinePrice();
								foundmed=true;
								if(patientage>=18 && patientage<=65) {
									c15.setDose(100);
									meddose=c15.getDose();
									System.out.println("the suggested dose: "+meddose);
								}
								else if(patientage>0 && patientage<18 || patientage>65){
									c15.setDose(50);
									meddose=c15.getDose();
									System.out.println("the suggested dose: "+meddose);
								}
							}
							else {
								System.out.println("Sorry there is no available medicine right now");
							}
							break;
						}
						if(choice5==10) {
							disname=c16.get(9);
							System.out.println("patient is suffering from: "+disname);
							if(medicines[i].getMedicineName().equalsIgnoreCase("coartem") || medicines[i].getMedicineName().equalsIgnoreCase("malarone")) {
								medname=medicines[i].getMedicineName();
								System.out.println("medicine suggestion: "+medname);
								medprice=medicines[i].getMedicinePrice();
								foundmed=true;
								if(patientage>=18 && patientage<=65) {
									c15.setDose(1500);
									meddose=c15.getDose();
									System.out.println("the suggested dose: "+meddose);
								}
								else if(patientage>0 && patientage<18 || patientage>65){
									c15.setDose(1000);
									meddose=c15.getDose();
									System.out.println("the suggested dose: "+meddose);
								}
							}
							else {
								System.out.println("Sorry there is no available medicine right now");
							}
							break;
						}
				}
					String docname;
					String timing;
					in.nextLine();
					if(foundmed==true) {
					System.out.println("enter the doctor name: ");
					docname=in.nextLine();
					System.out.println("enter the timing of the medicine: ");
					timing=in.nextLine();
					Prescriptionmedication c17=new Prescriptionmedication(docname,timing,medname,medprice);
					String txt5File = "Prescriptionmedication.txt";
					try (FileWriter writer = new FileWriter(txt5File)){
					      writer.append("Prescriptionmedication detials:\n\n"+c17.toString());
					}catch (IOException e) {
					      System.err.println("Error writing to TXT file: " + e.getMessage());
				    }
					System.out.println("Prescription medication:"
							+"\ndate: XX-XX-XXXX\n"
							+"\n"+c7.getPhname()
							+("\npatient fname: ")+patientfname
							+("\npatient lname: ")+patientlname
							+("\npatient age: ")+patientage
							+c17.toString()+
							"\thope you get well soon :)");
					System.out.println("_________________________________________________________________________");
				}
					else {
						System.out.println("there is no order!! ");
					}
			}
		}
	}
}