import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import domain.Email;
import domain.Phone;
import domain.Sentence;
import domain.Text;
import domain.WrongFormatException;

public class lab2 {

	public static void main(String[] args) throws Exception {
		System.out.println("In each sentence of the text, exclude the maximum \nlength substring starting and ending with the specified characters. "
				+ "\nFor example starting with 'e' and ending with 'o'.");
		System.out.println("Sentences in text are: \n");
	
		Text text=new Text("src/resources/data.txt");
		System.out.println("\n"+text.getSentences());
		
		System.out.println("\nYou can get single sentence with index and get all phone numbers\nemails and modify this single sentence: \n");
		
		Sentence one=text.getOneSentence(3);
		System.out.println(one.getSentence());
		System.out.println(one.getPhoneNumbers());
		System.out.println(one.getEmails());
		System.out.println(one.getNewSentence());
		
		System.out.println("\nYou can get all phone numbers, emails and modified sentences from all text: \n");
		
		System.out.println(text.getAllPhoneNumbers());
		System.out.println(text.getAllEmails());
		System.out.println(text.getAllModifiedSentences());
		
		System.out.println("\nSpecials classes for presentation emails and phones: \n");
		Email email = new Email(one.getEmails().get(0));
		Phone phone = new Phone(one.getPhoneNumbers().get(0));
		System.out.println(email);
		System.out.println(phone);
		try {
		Phone failedPhone =new Phone("33-56-78");
		}catch(WrongFormatException ex) {
			System.err.print(ex);
		}
		try {
			Email failedEmail =new Email("qwe@qwe.b");
			}catch(WrongFormatException ex) {
				System.err.print(ex);
			}
		
		
	}
}
