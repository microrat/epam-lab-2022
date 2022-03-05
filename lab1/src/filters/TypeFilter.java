package filters;

import insurance.Filter;
import insurance.Insurance;
import insurance.Type;

public class TypeFilter implements Filter {

	private Type type;

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public TypeFilter(Type type) {
		this.setType(type);;
	}

	@Override
	public boolean check(Insurance insurance) {
		return (insurance.getType() == type);
	}

}
