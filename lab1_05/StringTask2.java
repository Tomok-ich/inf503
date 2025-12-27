public class StringTask2{
	public static void main(String[] args){
		String s1 = "informatika";
		String s2 = "tikam";
		for (int i = 0; i < s1.length(); ++i){
			if (s1.charAt(i) == s2.charAt(0)){
				int count = 0;
				if (i + s2.length() > s1.length()){
					break;
				}
				for (int j = 0; j < s2.length(); ++j){
					if (s1.charAt(i + j) == s2.charAt(j)){
						count++;
					}
				}
				if (count == s2.length()){
					System.out.println("ИНдекс строки: " + i);
					return;
				}
			}
		}
		System.out.println("Подстроки не найдено");
	}
}