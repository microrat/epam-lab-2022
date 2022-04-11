package comparators;

import java.util.Comparator;

import beer.Beer;

public class TitleComparator implements Comparator<Beer> {

    @Override
    public int compare(Beer o1, Beer o2) {
	if (o1.getTitle() != o2.getTitle()) {
	    return o1.getTitle().compareTo(o2.getTitle());
	} else
	    return 0;
    }
}
