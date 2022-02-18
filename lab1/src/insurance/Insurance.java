package insurance;

public abstract class Insurance {
	protected int period;
	
	public abstract void getInfo();
	public abstract double countRisk();
	public abstract double countPrice();
	
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	
	public Insurance(int period) {
		this.period=period;
	}
	
}
