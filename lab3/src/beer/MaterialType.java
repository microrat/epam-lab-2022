package beer;

public enum MaterialType {
    Plastic("Plastic"), Glass("Glass"), Steel("Steel");

    private String type;

    MaterialType(String type) {
	this.setType(type);
    }

    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
    }

}
