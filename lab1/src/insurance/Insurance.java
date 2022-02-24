package Insurance;

public abstract class Insurance {
	protected int period;
	protected double price;
	protected double risk;
	
	public abstract void setRisk();
	public abstract void setPrice() ;
	public abstract void getInfo();
	
	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public double getPrice() {
		return price;
	}

	public double getRisk() {
		return risk;
	}

	public Insurance(int period){
		this.period=period;
	}
}
