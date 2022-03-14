package domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    private String email;

    public Email(String email) throws WrongFormatException {
	Pattern emailPattern = Pattern.compile("([a-z]+[@][a-z]+[.][a-z]{2,})");
	Matcher matcher = emailPattern.matcher(email);
	if (matcher.find()) {
	    this.email = email;
	} else {
	    throw new WrongFormatException("Wrong email format\n");

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
