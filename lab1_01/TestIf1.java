public class TestIf1 {
	public static void main(String arguments[]) {
		int a = -1;

		if (a > -3 && a < 3)
			System.out.println("True");
		else
			System.out.println("False");
		if (a > -3 && a < 3){
			System.out.println("Раскрываем модуль" + a);
			System.out.println("True");
		}

		else{
			System.out.println("Раскрываем модуль" + a);
			System.out.println("False");
		}
		// u - вверх,  d - вниз, r, l
		char c = 'u';
		if (c == 'u' || c == 'U'){

		}
		else if (c == 'd' || c == 'D'){
			System.out.println("Движемся вниз");
		}
		else if (c == 'd' || c == 'D'){
			System.out.println("Движемся вниз");
		}
		else if (c == 'd' || c == 'D'){
			System.out.println("Движемся вниз");
		}
		int b = 10;
		// ++x - инкримент это аналог  x = x+1, x+=1 он сначала увеличивается а потом выводится
		// x++ сначала используется в выражении а потом увеличивается
		if (b < 50 && ++b > 10){
			System.out.println("" + b);
		}
	}
}