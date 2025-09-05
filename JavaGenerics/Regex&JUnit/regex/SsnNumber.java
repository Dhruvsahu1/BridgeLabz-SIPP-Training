package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class SsnNumber {
	public static void main(String[] args) {
		 String regex = "\\b\\d{3}-\\d{2}-\\d{4}\\b"; 
	        Pattern pattern = Pattern.compile(regex);
	        String[] inputs = {
	                "My SSN is 123-45-6789.",
	                "This one is invalid: 123456789.",
	                "Another wrong: 12-345-6789."
	            };
	        
	        for (String text : inputs) {
	            Matcher matcher = pattern.matcher(text);
	            if (matcher.find()) {
	                System.out.println( matcher.group() + " is valid");
	            } else {
	                System.out.println(" No valid SSN found in: \"" + text + "\"");
	            }
	        }

	}
}

