package insurance;

public class MedicalInsurance extends Insurance {
	private int age;
	private String name;
	private String surname;

	public MedicalInsurance(Type type, int period, int age, String name, String surname) {
		super(type, period);
		this.setAge(age);
		this.setName(name);
		this.setSurname(surname);
		setRisk();
		setPrice();
	}

	@Override
	public void setRisk() {
		this.risk = 0.09 * age;
	}

	@Override
	public void setPrice() {
		this.price = 1500 * period * risk;
	}

	@Override
	public void getInfo() {
		System.out.println("Type: " + type + "\nName: " + name + "\nSurname: " + surname + "\nAge: " + age + "\nRisk: "
				+ risk + "\nPrice: " + price + "\n");
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

}
