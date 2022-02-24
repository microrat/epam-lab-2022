package Insurance;

public class CarInsurance extends Insurance{
	private int yearOfRelease;
	private String carType;
	private String brand;
	
	public CarInsurance(int period, int yearOfRelease,String carType, String brand){
		super(period);
		this.yearOfRelease=yearOfRelease;
		this.carType=carType;
		this.brand=brand;
		setRisk();
		setPrice();
	}

	@Override
	public void setRisk() {
		this.risk=0.005*yearOfRelease;
		
	}
	@Override
	public void setPrice() {
		this.price=500*risk*period;
		
	}

	@Override
	public void getInfo() {
		System.out.println("Year of Release: "+yearOfRelease+"\nCar Type: "+carType+"\nBrand: "+brand+"\nRisk: "+risk+"\nPrice: "+price+"\n");
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
}
