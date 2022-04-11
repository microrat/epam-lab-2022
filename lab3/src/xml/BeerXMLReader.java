package xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import beer.Beer;
import beer.BeerType;
import beer.Chars;
import beer.Ingridient;
import beer.IngridientName;
import beer.MaterialType;
import beer.TypeOfFilling;

public class BeerXMLReader {
    public List<Beer> read(String xmlFilePath) throws FileNotFoundException, IOException, XMLStreamException {
	XMLStreamReader xmlStreamReader = null;
	try {

	    XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
	    xmlStreamReader = xmlInputFactory.createXMLStreamReader(new FileInputStream(xmlFilePath));

	    List<Beer> beerList = null;
	    List<Ingridient> ingridients = null;
	    Ingridient ingridient = null;
	    Beer beer = null;
	    Chars chars = null;
	    TypeOfFilling typeOfFilling = null;

	    while (xmlStreamReader.hasNext()) {
		int type = xmlStreamReader.next();
		if (type == XMLStreamConstants.START_ELEMENT) {
		    String tagName = xmlStreamReader.getLocalName();
		    switch (tagName) {
		    case "BeerList":
			beerList = new ArrayList<Beer>();
			break;
		    case "Beer": {
			beer = new Beer();
			beer.setIdentifier(xmlStreamReader.getAttributeValue(null, "id"));
			break;
		    }
		    case "Title":
			beer.setTitle(xmlStreamReader.getElementText());
			break;
		    case "BeerType":
			beer.setBeerType(BeerType.valueOf(xmlStreamReader.getElementText()));
			break;
		    case "Al":
			beer.setAl(Boolean.parseBoolean(xmlStreamReader.getElementText()));
			break;
		    case "Manufacturer":
			beer.setManufacturer(xmlStreamReader.getElementText());
		    case "Chars":
			chars = new Chars();
			break;
		    case "Filtered":
			chars.setFiltered(Boolean.parseBoolean(xmlStreamReader.getElementText()));
			break;
		    case "Calories":
			chars.setCalories(Float.parseFloat(xmlStreamReader.getElementText()));
			break;
		    case "TypeOfFilling":
			typeOfFilling = new TypeOfFilling();
			break;
		    case "Volume":
			typeOfFilling.setVolume(Float.parseFloat(xmlStreamReader.getElementText()));
			break;
		    case "MaterialType":
			typeOfFilling.setMaterialType(MaterialType.valueOf(xmlStreamReader.getElementText()));
			break;
		    case "NumberOfTurns":
			chars.setNumberOfTurns(Float.parseFloat(xmlStreamReader.getElementText()));
			break;
		    case "Tranparency":
			chars.setTransparency(xmlStreamReader.getElementText());
			break;
		    case "Ingridients":
			ingridients = new ArrayList<Ingridient>();
			break;
		    case "Ingridient":
			ingridient = new Ingridient();
			break;
		    case "IngrideintName":
			ingridient.setIngridientName(IngridientName.valueOf(xmlStreamReader.getElementText()));
			break;
		    case "Amount":
			ingridient.setAmount(Float.parseFloat(xmlStreamReader.getElementText()));
			break;
		    default:
			System.out.println("Unknown open tag " + tagName);
			break;
		    }

		} else if (type == XMLStreamConstants.END_ELEMENT) {
		    String tagName = xmlStreamReader.getLocalName();
		    switch (tagName) {
		    case "Ingridient":
			ingridients.add(ingridient);
			break;
		    case "Ingridients":
			beer.setIngridients(ingridients);
			break;
		    case "TypeOfFilling":
			chars.setTypeOfFilling(typeOfFilling);
			break;
		    case "Chars":
			beer.setChars(chars);
			break;
		    case "Beer":
			beerList.add(beer);
			break;
		    case "BeerList":
			break;
		    default:
			System.out.println("Unknown close tag " + tagName);
			break;
		    }

		}
	    }
	    return beerList;
	} catch (XMLStreamException e) {
	    System.err.println(e);
	    System.out.println("BeerXMLRader XMLStreamException e IN CaTCH");
	    return new ArrayList<Beer>();
	} finally {
	    xmlStreamReader.close();
	}
    }
}
