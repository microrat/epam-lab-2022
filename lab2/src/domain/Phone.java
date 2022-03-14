package domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Phone {
	private String phone; 
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Phone(String phone) throws WrongFormatException {
		Pattern phonePattern = Pattern.compile("([+]\\d{3}[(]\\d{2}[)]\\d{3}[-]?\\d{2}[-]?\\d{2})");
		Matcher matcher = phonePattern.matcher(phone);
		if (matcher.find()) {
			this.phone=phone;
		} else {
			throw new WrongFormatException("Wrong phone format\n") ;
			
		}
		
	}
	@Override
	public String toString() { 
	    return "Phone: " + this.phone;
	} 
}
