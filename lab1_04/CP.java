public class CP{
	public static void main(String[] args){
		String el = "0123456789абвгдеёжзАБВГДЕЁЖЗ";
		for (int i = 0; i < el.length(); ++i){
			System.out.println(el.charAt(i) + " -- " + 
				(int)(el.charAt(i)));
		}
		System.out.println('5' - 48);
	}
}
// в джава по умолчанию используется кодировка UTF16