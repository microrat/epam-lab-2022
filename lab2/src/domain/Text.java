package domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {
    private String filename;
    private String text;
    private List<Sentence> sentences = new ArrayList<Sentence>();
    private List<String> allPhoneNumbers = new ArrayList<String>();
    private List<String> allEmails = new ArrayList<String>();
    private List<String> allModifiedSentences = new ArrayList<String>();

    public Text(String filename) {
	this.filename = filename;
	setText();
	setSentences();
	setAllPhoneNumbers();
	setAllEmails();
	setAllModifiedSentences();

    }

    public void setSentences() {
	Pattern pattern = Pattern.compile("([':@()+a-zA-Z0-9,\\s-]+)([^@][A-Za-z0-9]+)[.?!]+");
	Matcher matcher = pattern.matcher(text);
	while (matcher.find()) {
	    System.out.print(matcher.group() + "\n");
	    sentences.add(new Sentence(matcher.group()));
	}
    }

    public List<String> getSentences() {
	List<String> sentencesString = new ArrayList<String>();
	for (Sentence sen : sentences) {
	    sentencesString.add(sen.getSentence());
	}
	return sentencesString;
    }

    public Sentence getOneSentence(int index) {
	return sentences.get(index);
    }

    public String getFilename() {
	return filename;
    }

    public void setFilename(String filename) {
	this.filename = filename;
    }

    public String getText() {
	return text;
    }

    public void setText() {
	try {
	    text = Files.readString(Path.of(filename));
	    text = text.replaceAll("\\s{2,}", " ");
	} catch (IOException ex) {
	    System.err.println(ex);
	}
    }

    public List<String> getAllPhoneNumbers() {
	return allPhoneNumbers;
    }

    public void setAllPhoneNumbers() {
	for (Sentence sen : sentences) {
	    allPhoneNumbers.addAll(sen.getPhoneNumbers());
	}
    }

    public List<String> getAllEmails() {
	return allEmails;
    }

    public void setAllEmails() {
	for (Sentence sen : sentences) {
	    allEmails.addAll(sen.getEmails());
	}
    }

    public List<String> getAllModifiedSentences() {
	return allModifiedSentences;
    }

    public void setAllModifiedSentences() {
	for (Sentence sen : sentences) {
	    allModifiedSentences.add(sen.getNewSentence());
	}
    }

}
