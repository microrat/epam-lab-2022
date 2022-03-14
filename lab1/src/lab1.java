import java.util.List;

import comparator.*;
import exceptions.ParameterNotFoundException;
import filters.*;
import insurance.*;

public class lab1 {

    public static void main(String[] args) {
	Insurance BMW = new CarInsurance(Type.CAR, 12, 1995, "Passanger", "BMW");
	Insurance Ferrari = new CarInsurance(Type.CAR, 10, 1995, "Passanger", "Ferrari");
	Insurance Audi = new CarInsurance(Type.CAR, 24, 101, "Truck", "Audi");
	Insurance Eric = new MedicalInsurance(Type.MEDICAL, 16, 10, "Eric", "Cartman");

	Derivative one = new Derivative(126532, "Kenny McCormick", BMW, Audi, Eric, Ferrari);
	System.out.println("Total info about derivative\n");
	one.getInfo();

	System.out.println("Unsorted derivative\n");
	one.getInfoInsurance();

	one.sort(new SortByRisk().thenComparing(new SortByPeriod()));
	System.out.println("Sorted by risk derivative\n");
	one.getInfoInsurance();

	System.out.println("Find by period\n");
	try {
	    List<Insurance> list1 = one.find(new PeriodFilter(15, 25));
	    for (Insurance i : list1)
		i.getInfo();
	} catch (ParameterNotFoundException ex) {
	    System.err.print(ex);
	}
	System.out.println("Find by price\n");
	try {
	    List<Insurance> list2 = one.find(new PriceFilter(10000, 30000));
	    for (Insurance i : list2)
		i.getInfo();
	} catch (ParameterNotFoundException ex) {
	    System.err.print(ex);
	}

	System.out.println("Find by type\n");
	try {
	    List<Insurance> list3 = one.find(new TypeFilter(Type.PROPERTY));
	    for (Insurance i : list3)
		i.getInfo();
	} catch (ParameterNotFoundException ex) {
	    System.err.print(ex);
	}
	one.countTotalPrice();

    }

}
