package insurance;

import java.util.ArrayList;
import java.util.List;

public class Derivative {
	List<Insurance> derivative=new ArrayList<Insurance>();
	
	public Derivative(Insurance ...insurances){
		for(int i=0;i<insurances.length;i++)
			derivative.add(insurances[i]);
	}
	
	
	
	public List<Insurance> sortByRisk(){
		
		return derivative;
		
	}
	
	public List<Insurance> getDerivative() {
		return derivative;
	}
	
	public void getInfo() {
			for(Insurance i : derivative) {
				i.getInfo();
			
		}
	}
}
