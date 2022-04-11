package xml;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class BeerXMLValidator {
    private String xmlFilePath;
    
    static final String xsdFilePath = "src/XMLresources/beer.xsd";
    static final SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
   
    public boolean checkValidity() throws SAXException, IOException {
	try {
	Schema schema = schemaFactory.newSchema(new File(xsdFilePath));
	Validator validator = schema.newValidator();
	validator.validate(new StreamSource(xmlFilePath));
	return true;
	}catch(SAXException e) {
	    return false;
	}
    }
    
    
    public BeerXMLValidator(String xmlFilePath) {
   	super();
   	this.xmlFilePath = xmlFilePath;
       }  
    public String getXmlFilePath() {
	return xmlFilePath;
    }
    public void setXmlFilePath(String xmlFilePath) {
	this.xmlFilePath = xmlFilePath;
    }
    
    
}
