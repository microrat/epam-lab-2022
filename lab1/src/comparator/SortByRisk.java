package comparator;

import java.util.Comparator;
import insurance.Insurance;

public class SortByRisk implements Comparator<Insurance> {

	@Override
	public int compare(Insurance o1, Insurance o2) {
		if(o1.getRisk()!=o2.getRisk()) {		
			return o2.getRisk()>o1.getRisk() ? 1:-1;
		}
		else return 0;
	}

}
