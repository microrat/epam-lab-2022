package comparator;

import java.util.Comparator;
import insurance.Insurance;

public class SortByPrice implements Comparator<Insurance> {

    @Override
    public int compare(Insurance o1, Insurance o2) {
	return (int) (o1.getPrice() - o2.getPrice());
    }

}
