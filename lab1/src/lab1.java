import insurance.*;

public class lab1 {

	public static void main(String[] args) {
		CarInsurance BMW= new CarInsurance(12,1995,"Motorcycle","Ford",0.2);
		CarInsurance Audi= new CarInsurance(14,1980,"Truck","Audi",0.2);
		MedicalInsurance Kenny=new MedicalInsurance(24,9,"Kenny","McKormick");
		Derivative der=new Derivative(BMW,Audi,Kenny);
		der.getInfo();
		
		
	}

}
