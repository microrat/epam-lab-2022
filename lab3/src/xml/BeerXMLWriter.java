package xml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import beer.Beer;
import beer.Ingridient;

public class BeerXMLWriter {
    public void write(List<Beer> beerList, String fileName) throws FileNotFoundException, XMLStreamException {
	XMLStreamWriter writer = null;
	try {
	    XMLOutputFactory factory = XMLOutputFactory.newFactory();
	    writer = factory.createXMLStreamWriter(new FileOutputStream(fileName), "UTF-8");
	    writer.writeStartDocument("UTF-8", "1.0");
	    writer.writeStartElement("tns:BeerList");
	    writer.writeAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
	    writer.writeAttribute("xmlns:tns", "https://www.example.org/BeerList");
	    writer.writeAttribute("xsi:schemaLocation", "http://www.example.org/BeerList beer.xsd ");
	    for (Beer beer : beerList) {
		writer.writeStartElement("tns:Beer");
		writer.writeAttribute("id", beer.getIdentifier());
		writer.writeStartElement("tns:Title");
		writer.writeCharacters(beer.getTitle());
		writer.writeEndElement();
		writer.writeStartElement("tns:BeerType");
		writer.writeCharacters(beer.getBeerType().toString());
		writer.writeEndElement();
		writer.writeStartElement("tns:Al");
		writer.writeCharacters(String.valueOf(beer.getAl()));
		writer.writeEndElement();
		writer.writeStartElement("tns:Manufacturer");
		writer.writeCharacters(beer.getManufacturer());
		writer.writeEndElement();
		writer.writeStartElement("tns:Chars");
		writer.writeStartElement("tns:Filtered");
		writer.writeCharacters(String.valueOf(beer.getChars().getFiltered()));
		writer.writeEndElement();
		writer.writeStartElement("tns:Calories");
		writer.writeCharacters(String.valueOf(beer.getChars().getCalories()));
		writer.writeEndElement();
		writer.writeStartElement("tns:TypeOfFilling");
		writer.writeStartElement("tns:MaterialType");
		writer.writeCharacters(String.valueOf(beer.getChars().getTypeOfFilling().getMaterialType()));
		writer.writeEndElement();
		writer.writeStartElement("tns:Volume");
		writer.writeCharacters(String.valueOf(beer.getChars().getTypeOfFilling().getVolume()));
		writer.writeEndElement();
		writer.writeEndElement();
		writer.writeStartElement("tns:NumberOfTurns");
		writer.writeCharacters(String.valueOf(beer.getChars().getNumberOfTurns()));
		writer.writeEndElement();
		writer.writeStartElement("tns:Tranparency");
		writer.writeCharacters(String.valueOf(beer.getChars().getTransparency()));
		writer.writeEndElement();
		writer.writeEndElement();
		
		writer.writeStartElement("tns:Ingridients");
		for (Ingridient ingridient : beer.getIngridients()) {
		    writer.writeStartElement("tns:Ingridient");
		    writer.writeStartElement("tns:IngrideintName");
		    writer.writeCharacters(String.valueOf(ingridient.getIngridientName()));
		    writer.writeEndElement();
		    writer.writeStartElement("tns:Amount");
		    writer.writeCharacters(String.valueOf(ingridient.getAmount()));
		    writer.writeEndElement();
		    writer.writeEndElement();
		}
		writer.writeEndElement();
		writer.writeEndElement();
	    }
	    writer.writeEndElement();
	} catch (XMLStreamException e) {
	    System.err.println(e);
	} finally {
	    writer.close();
	}

    }
}
