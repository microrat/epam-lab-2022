package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentence {
	private String sentence;
	private List<String> phoneNumbers = new ArrayList<String>();
	private List<String> emails = new ArrayList<String>();
	String newSentence;

	public Sentence(String sentence) {
		this.sentence = sentence;
		setPhoneNumbers();
		setEmails();
		setNewSentence();
	}

	public String getSentence() {
		return sentence;
	}

	public void setSentence(String sentence) {
		this.sentence = sentence;
	}

	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers() {
		Pattern phone = Pattern.compile("([+]\\d{3}[(]\\d{2}[)]\\d{3}[-]?\\d{2}[-]?\\d{2})");
		Matcher matcher = phone.matcher(sentence);
		while (matcher.find()) {
			phoneNumbers.add(matcher.group());
		}
	}

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails() {
		Pattern email = Pattern.compile("([a-z]+[@][a-z]+[.][a-z]{2,})");
		Matcher matcher = email.matcher(sentence);
		while (matcher.find()) {
			emails.add(matcher.group());
		}
	}

	public String getNewSentence() {
		return newSentence;
	}

	public void setNewSentence() {
		Pattern deleteSubstring = Pattern.compile("e.+o");
		Matcher matcher = deleteSubstring.matcher(sentence);
		if (!matcher.find()) {
			newSentence=sentence;
		} else {
			newSentence=sentence.replace(matcher.group(), "");
		}

	}
}
