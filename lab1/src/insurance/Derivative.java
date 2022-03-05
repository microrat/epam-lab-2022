package insurance;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import exceptions.ParameterNotFoundException;

public class Derivative {
	List<Insurance> derivative = new ArrayList<Insurance>();
	private int derivativeId;
	private int insuranceAmount;
	private String fio;

	public void sort(Comparator<Insurance> comparator) {
		Collections.sort(getDerivative(), comparator);
	}

	public List<Insurance> find(Filter filter) throws ParameterNotFoundException {
		List<Insurance> list = new ArrayList<>();
		for (Insurance i : derivative) {
			if (filter.check(i)) {
				list.add(i);
			}
		}
		if (!list.isEmpty()) {
			return list;
		} else {
			throw new ParameterNotFoundException("Cant't find objects with this parameter\n");
		}

	}

	public Derivative(int derivativeId, String fio, Insurance... insurances) {
		this.setDerivativeId(derivativeId);
		this.fio = fio;
		this.insuranceAmount = insurances.length;
		for (int i = 0; i < insurances.length; i++)
			derivative.add(insurances[i]);
	}

	public List<Insurance> getDerivative() {
		return derivative;
	}

	public void getInfo() {
		System.out.print("Derivative id: " + derivativeId + "\nAmount of insurances: " + insuranceAmount
				+ "\nOwner name: " + fio + "\n\n");
	}

	public void getInfoInsurance() {
		for (Insurance i : derivative) {
			i.getInfo();
		}
	}

	public int getDerivativeId() {
		return derivativeId;
	}

	public void setDerivativeId(int derivativeId) {
		this.derivativeId = derivativeId;
	}

	public void countTotalPrice() {
		double totalPrice = 0;
		for (Insurance i : derivative) {
			totalPrice += i.getPrice();
		}
		System.out.println("Total derivative price = " + totalPrice);
	}

}