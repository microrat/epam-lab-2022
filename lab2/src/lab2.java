import java.io.IOException;


import domain.Email;
import domain.Phone;
import domain.Sentence;
import domain.Text;
import domain.WrongFormatException;

public class lab2 {

    public static void main(String[] args) /* throws Exception */ {
	System.out.println(
		"In each sentence of the text, exclude the maximum \nlength substring starting and ending with the specified characters. "
			+ "\nFor example starting with 'e' and ending with 'o'.");
	System.out.println("Sentences in text are: \n");

	try {
	    Text text = new Text("src/resources/data.txt");
	    System.out.println("\n" + text.getSentences());

	    System.out.println(
		    "\nYou can get single sentence with index and get all phone numbers\nemails and modify this single sentence: \n");

	    Sentence singleSentence = text.getOneSentence(3);
	    System.out.println(singleSentence.getSentenceText());
	    System.out.println(singleSentence.getPhoneNumbers());
	    System.out.println(singleSentence.getEmails());
	    System.out.println(singleSentence.getNewSentence("e","o"));

	    System.out.println("\nYou can get all phone numbers, emails and modified sentences from all text: \n");

	    System.out.println(text.getAllPhoneNumbers());
	    System.out.println(text.getAllEmails());
	    System.out.println(text.getAllModifiedSentences("e","o"));

	    System.out.println("\nSpecials classes for presentation emails and phones: \n");
	    try {
		Email email = new Email(singleSentence.getEmails().get(0));
		Phone phone = new Phone(singleSentence.getPhoneNumbers().get(0));
		System.out.println(email);
		System.out.println(phone);
	    } catch (WrongFormatException ex) {
		System.err.print(ex);
	    }
	    try {
		Phone failedPhone = new Phone("33-56-78");
		System.out.println(failedPhone);
	    } catch (WrongFormatException ex) {
		System.err.print(ex);
	    }
	    try {
		Email failedEmail = new Email("qwe@qwe.b");
		System.out.println(failedEmail);
	    } catch (WrongFormatException ex) {
		System.err.print(ex);
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }
}
