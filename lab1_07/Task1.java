import java.util.regex.Pattern;

public class Task1{
	public static void main(String[] args){
		String password1 = "^[a-zA-Z]+\\d+[\\^\\$\\%\\@\\#\\&\\*\\!\\?]+";
		String password2 = "^(.){8,}";
		String password3 = "^.*[A-Z]+.*";
		String password4 = "^.*[a-z]+.*";
		String password5 = "^.*\\d+.*";
		System.out.println(
			Pattern.matches(password1, "Der34&")
		);
		System.out.println(
			Pattern.matches(password2, "fhf54&*577878878")
		);
		System.out.println(
			Pattern.matches(password3, "Der34&")
		);
		System.out.println(
			Pattern.matches(password4, "Der34&")
		);
		System.out.println(
			Pattern.matches(password5, "Der34&")
		);
	}
}