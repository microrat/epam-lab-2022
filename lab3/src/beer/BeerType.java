package beer;

public enum BeerType {
    Lager("Lager"), Light("Light"), Dark("Dark"), Porter("Porter");

    private String type;

    BeerType(String type) {
	this.setType(type);
    }

    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
    }

}
