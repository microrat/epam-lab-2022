package beer;

import java.util.List;

public class Beer {
    private String identifier;
    private String title;
    private BeerType beerType;
    private boolean al;
    private String manufacturer;
    private Chars chars;
    private List<Ingridient> ingridients;
    
    public Beer() {}
        
    public String getTitle() {
	return title;
    }
    public void setTitle(String title) {
	this.title = title;
    }
    public BeerType getBeerType() {
	return beerType;
    }
    public void setBeerType(BeerType beerType) {
	this.beerType = beerType;
    }
    public boolean getAl() {
	return al;
    }
    public void setAl(boolean al) {
	this.al = al;
    }
    public String getManufacturer() {
	return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
	this.manufacturer = manufacturer;
    }
    public Chars getChars() {
	return chars;
    }
    public void setChars(Chars chars) {
	this.chars = chars;
    }
    public List<Ingridient> getIngridients() {
	return ingridients;
    }
    public void setIngridients(List<Ingridient> ingridients) {
	this.ingridients = ingridients;
    }

    public String getIdentifier() {
	return identifier;
    }

    public void setIdentifier(String identifier) {
	this.identifier = identifier;
    }
    @Override
    public String toString() {
	return "\nid: "+identifier+"\ntitle: "+title+"\nbeer type: "+beerType+"\nalcoholic: "+al+"\nmanufacturer: "+manufacturer+"\nchars:\n"+chars+"\nIngridients: "+ingridients+"\n\n";
	
	
    }
    /*
    public static class BeerBuilder {
	private Beer beer = new Beer();
	public BeerBuilder build() {
	    return new BeerBuilder();
	}
	public BeerBuilder appendAl(boolean al) {
	    beer.setAl(al);
	    return this;
	}
	public Beer get() {
	    return beer;
	}
    }
    */
}
