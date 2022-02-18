package insurance;

public class CarInsurance extends Insurance {
	
	private int yearOfRelease;
	private String carType;
	private String brand;
	private double coeff;
	
	public void getInfo() {
		System.out.println("Year of Release: "+yearOfRelease+"\nCar Type: "+carType+"\nBrand: "+brand+"\nCoefficient: "+coeff+"\n");
	}
	
	public CarInsurance(int period, int yearOfRelease,String carType, String brand, double coeff) {
		super(period);
		this.yearOfRelease=yearOfRelease;
		this.carType=carType;
		this.brand=brand;
		this.coeff=coeff;
	}

	@Override
	public double countRisk() {
		double risk=0;
		switch(carType) {
		case "Motorcycle":{
			risk=coeff*yearOfRelease+120;
			break;
		}
		case "Passanger":{
			risk=coeff*yearOfRelease+60;
			break;
		}
		case "Truck":{
			risk=coeff*yearOfRelease+75;
			break;
		}
		default:
			risk=coeff*yearOfRelease+100;
			break;
		}
		return risk;
	}

	@Override
	public double countPrice() {
		double price=12000*coeff*period;
		return price;
	}

	public int getYearOfRelease() {
		return yearOfRelease;
	}

	public void setYearOfRelease(int yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getCoeff() {
		return coeff;
	}
	
	public void setCoeff(double coeff) {
	this.coeff=coeff;
	}
}
