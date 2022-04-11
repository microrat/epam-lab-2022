package beer;

public enum IngridientName {
    Water("Water"), Malt("Malt"), Hop("Hop"), Sugar("Sugar");

    private String type;

    IngridientName(String type) {
	this.setType(type);
    }

    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
    }
}
