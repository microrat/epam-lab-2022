package Comparator;

import java.util.Comparator;

import Insurance.Insurance;

public class SortByRisk implements Comparator<Insurance> {

	@Override
	public int compare(Insurance o1, Insurance o2) {
		return (int) (o1.getRisk() - o2.getRisk());
	}

}
