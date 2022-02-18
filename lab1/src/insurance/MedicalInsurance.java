package insurance;

public class MedicalInsurance extends Insurance{

	private int age;
	private String name;
	private String surname;
	
	public MedicalInsurance(int period, int age, String name,String surname) {
		super(period);
		this.setAge(age);
		this.setName(name);
		this.setSurname(surname);		
	}
	public void getInfo() {
		System.out.println("Name: "+name+"\nSurname: "+surname+"\nAge: "+age+"\n");
	}
	@Override
	public double countRisk() {
		double risk=65*age;
		return risk;
	}

	@Override
	public double countPrice() {
		double price=age*period*0.5;
		return price;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	
}
