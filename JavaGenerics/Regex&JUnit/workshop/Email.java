package workshop;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class  Email<T>{
	private T emailAddress;
	Email(T emailAddress){
		set(emailAddress);
	}
	
	public void set(T emailAddress) {
		this.emailAddress=emailAddress;
	}
	public T get() {
		return emailAddress;
	}
	public boolean isValid(String emailAddress) {
		String regex = "\\b[a-zA-Z0-9._]+@company.com\\b"; 
		Pattern pattern = Pattern.compile(regex);
		 Matcher matcher = pattern.matcher(emailAddress);
		 if (matcher.find()) {
	            System.out.println("Matched: " + matcher.group());
	            return true;
	        }
		return false;
	}
	public static void main(String[] args) {
		String emailAddress= "username@company.com";
		Email<String> obj = new Email<>(emailAddress);
		System.out.println(obj.get());
		obj.isValid(emailAddress);
		
	}
}
