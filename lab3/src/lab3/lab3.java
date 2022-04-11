package lab3;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.xml.sax.SAXException;

import beer.*;
import comparators.TitleComparator;
import xml.*;

public class lab3 {
    public static void main(String[] args) throws IOException {
	List<Beer> beer;
	BeerXMLValidator validator = new BeerXMLValidator("src/XMLresources/beer.xml");
	try {
	    validator.checkValidity();
	    System.out.println(validator.checkValidity());
	    try {
		beer=new BeerXMLReader().read("src/XMLresources/beer.xml");
		Collections.sort(beer, new TitleComparator());
		System.out.println(beer);
		BeerXMLWriter writer=new BeerXMLWriter();
		writer.write(beer, "src/XMLresources/beer-writer.xml");
		System.out.println("\nCheck BeerXMLWriter waorkability\n");
		beer=new BeerXMLReader().read("src/XMLresources/beer-writer.xml");
		System.out.println(beer);
	    }catch(XMLStreamException x) {
		System.err.println();
	    }
	}catch(SAXException e) {
	    System.err.println();
	}	
    }
}
