public class ForTest1{
	public static void main(String[] args){ // [] - определение массива 
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}
		for (int i = 2; i < 129; i = i * 2) {
			System.out.println(i);
		}
		int i = 0;
		i = 4;
		for ( ; i < 10; i++) {
			System.out.println(i);
		}
		System.out.println(i);
		for (int k = 0, n = 3; k < 10 && n < 30; k++, n = n + 3) {
			System.out.println(k);
		}
// arif progress
		int ar = 0;
		for (int j = 0; j < 1000; j++) {
			ar = ar + (1 + j*5);
		}
		System.out.println(ar);
// febonachi
		int a = 1;
		int b = 1;
		System.out.println(a);
		System.out.println(b);
		for (int k = 3; k <= 6; k++) {
			System.out.println(a + b);
			int c = a + b;
			b = a;
			a = c;
		}
	}
}