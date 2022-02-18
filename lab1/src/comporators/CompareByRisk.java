package comporators;
import insurance.*;
import java.util.Comparator;

public class CompareByRisk implements Comparator<Insurance> {
	@Override
	public int compare(Insurance o1, Insurance o2) {
		return o1.countRisk().compareTo(o2.countRisk());
	}

}
