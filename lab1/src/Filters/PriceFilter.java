package Filters;
import Insurance.Filter;
import Insurance.Insurance;


public class PriceFilter implements Filter {

    private double minPrice;
    private double maxPrice;

 
    public PriceFilter(double minPrice, double maxPrice) {
        this.setMinPrice(minPrice);
        this.setMaxPrice(maxPrice);
    }

	@Override
	public boolean check(Insurance insurance) {
		return (insurance.getPrice()>=minPrice && insurance.getPrice()<=maxPrice);
	}

	public double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}

	public double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}

  
}