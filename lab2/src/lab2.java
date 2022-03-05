import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class lab2 {

	public static void main(String[] args) {
		String fileContent = null;
		try {
		    fileContent = Files.readString(Path.of("src/resources/data.txt"));
		} catch (IOException ex) {
			System.err.println(ex);
		}
		System.out.println(fileContent);
		
		//Pattern pattern = Pattern.compile("(\\w+)|([\s!?.,])");
		
		fileContent =fileContent.replaceAll("\s+|\t"," ");
		fileContent =fileContent.replaceAll("\s+|\t"," ");
		
		System.out.println(fileContent);
		Pattern pattern = Pattern.compile("([a-zA-Z0-9,\s]+)|(.)");
        Matcher matcher = pattern.matcher(fileContent);
        List<String> sentenses=new ArrayList();
        while(matcher.find()) {
            System.out.println(matcher.group());
            sentenses.add(matcher.group());
        }
        System.out.println(sentenses);
        
        
	}
}
