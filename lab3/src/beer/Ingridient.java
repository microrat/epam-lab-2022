package beer;

public class Ingridient {
    private IngridientName ingridientName;
    private float amount;
    
    public IngridientName getIngridientName() {
	return ingridientName;
    }
    public void setIngridientName(IngridientName ingridientName) {
	this.ingridientName = ingridientName;
    }
    public float getAmount() {
	return amount;
    }
    public void setAmount(float amount) {
	this.amount = amount;
    }
    @Override 
    public String toString() {
	return ""+ingridientName+"-"+amount;
    }
}
