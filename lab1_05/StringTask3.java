public class StringTask3{// сортировка пузырьком это?
	public static void main(String[] args){

		String s1 = "инфЁрматика";
		String s2 = "инфёрматика";
		int minlen = s1.length() > s2.length() ? s2.length() : s1.length(); // тернарный оператор: условие ? если правда : если ложь 
		for (int i = 0; i < minlen; ++i){
			if (s1.charAt(i) != s2.charAt(i)){
				if (s1.charAt(i) == 'ё' && s2.charAt(i) > 'е'){
					System.out.println(-1);
					return;
				}
				if (s1.charAt(i) == 'Ё' && s2.charAt(i) > 'Е'){
					System.out.println(-1);
					return;
				}
				if (s2.charAt(i) == 'ё' && s1.charAt(i) > 'е'){
					System.out.println(-1);
					return;
				}
				if (s2.charAt(i) == 'Ё' && s1.charAt(i) > 'Е'){
					System.out.println(-1);
					return;
				}
				System.out.println(s1.charAt(i) < s2.charAt(i) ? -1 : 1);
				return;
			}
		}
		if (s1.length() > s2.length()){
			System.out.println(1);
		}
		else if (s1.length() < s2.length()){
			System.out.println(-1);
		}
		else {
			System.out.println(0);
		}
	}
}