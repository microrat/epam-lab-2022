package domain;

import java.util.regex.Pattern;

public class Email {
    private String email;

    public Email(String email) throws WrongFormatException {
	if (Pattern.matches("([a-z]+[@][a-z]+[.][a-z]{2,})", email)) {
	    this.email = email;
	} else {
	    throw new WrongFormatException("Wrong phone email\n");
	}

    }

    @Override
    public String toString() {
	return "Email: " + this.email;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

}
