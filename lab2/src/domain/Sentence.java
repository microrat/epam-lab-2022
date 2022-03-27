package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentence {
    private String sentenceText;
    private List<String> phoneNumbers = new ArrayList<String>();
    private List<String> emails = new ArrayList<String>();

    public Sentence(String sentence) {
	this.sentenceText = sentence;
	setPhoneNumbers();
	setEmails();
    }

    public String getSentenceText() {
	return sentenceText;
    }

    public void setSentenceText(String sentence) {
	this.sentenceText = sentence;
    }

    public List<String> getPhoneNumbers() {
	return phoneNumbers;
    }

    public void setPhoneNumbers() {
	Pattern phone = Pattern.compile("([+]\\d{3}[(]\\d{2}[)]\\d{3}[-]?\\d{2}[-]?\\d{2})");
	Matcher matcher = phone.matcher(sentenceText);
	while (matcher.find()) {
	    phoneNumbers.add(matcher.group());
	}
    }

    public List<String> getEmails() {
	return emails;
    }

    public void setEmails() {
	Pattern email = Pattern.compile("([a-z]+[@][a-z]+[.][a-z]{2,})");
	Matcher matcher = email.matcher(sentenceText);
	while (matcher.find()) {
	    emails.add(matcher.group());
	}
    }

    public String getNewSentence(String begin, String end) {
	String newSentence;
	Pattern deleteSubstring = Pattern.compile(begin + ".+" + end);
	Matcher matcher = deleteSubstring.matcher(sentenceText);
	if (!matcher.find()) {
	    newSentence = sentenceText;
	} else {
	    newSentence = sentenceText.replace(matcher.group(), "");
	}
	return newSentence;
    }

}
