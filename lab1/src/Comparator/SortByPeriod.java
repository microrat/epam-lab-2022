package Comparator;

import java.util.Comparator;

import Insurance.Insurance;

public class SortByPeriod implements Comparator<Insurance> {

	@Override
	public int compare(Insurance o1, Insurance o2) {
		return (int) (o1.getPeriod() - o2.getPeriod());
	}

}
