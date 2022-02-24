import java.util.List;

import Comparator.*;
import Filters.*;
import Insurance.*;

public class lab1 {

	public static void main(String[] args) {
		CarInsurance BMW=new CarInsurance(12,1995,"Passanger","BMW");
		CarInsurance Audi=new CarInsurance(24,101,"Truck","Audi");
		MedicalInsurance Eric=new MedicalInsurance(16,10,"Eric","Cartman");
		
		Derivative one=new Derivative(126532,"Kenny McCormick",BMW,Audi,Eric);
		System.out.println("Total info about derivative\n");
		one.getInfo();
		
		System.out.println("Unsorted derivative\n");
		one.getInfoInsurance();
		
		one.sort(new SortByRisk());
		System.out.println("Sorted derivative\n");
		one.getInfoInsurance();
		
		
		System.out.println("Find by period\n");
		List<Insurance> list1 = one.find(new PeriodFilter(15, 25));
		for(Insurance i:list1)i.getInfo();
		
		System.out.println("Find by price\n");
		List<Insurance> list2 = one.find(new PriceFilter(10000, 30000));
		for(Insurance i:list2)i.getInfo();
		
		one.countTotalPrice();
	
	}
	
}
