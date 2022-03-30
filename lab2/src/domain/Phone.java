package domain;

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
	if(Pattern.matches( "[+]\\d{3}[(]\\d{2}[)]\\d{3}[-]?\\d{2}[-]?\\d{2}", phone)) {
	    this.phone = phone;
	   	} else {
	   	    throw new WrongFormatException("Wrong phone format\n");
	   	} 
    }

    @Override
    public String toString() {
	return "Phone: " + this.phone;
    }
}
