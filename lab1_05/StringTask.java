public class StringTask{
	public static void main(String[] args){
		String s1 = "12345";
		String s2 = "09876";
		if (s1 == s2){
			System.out.println("равны");
			return; //отправляет к завершению метода (main(2 строка))
		}
		if (s1.length() != s2.length()){
			System.out.println("разные");
			return;
		}
		for (int i = 0; i < s1.length(); ++i){
			if (s1.charAt(i) != s2.charAt(i)){
				System.out.println("разные");
				return;
			} 
		}
		System.out.println("равны");

	}
}