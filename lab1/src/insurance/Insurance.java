package insurance;

public abstract class Insurance implements Comparable<Insurance> {
	protected Type type;
	protected int period;
	protected double price;
	protected double risk;

	public abstract void setRisk();

	public abstract void setPrice();

	public abstract void getInfo();

	@Override
	public int compareTo(Insurance i) {
		return this.period - i.getPeriod();
	}

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

	public Insurance(Type type, int period) {
		this.type = type;
		this.period = period;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
}
